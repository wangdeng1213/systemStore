package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.*;
import com.peanut.p2p.products.model.entity.*;
import com.peanut.p2p.products.service.*;
import com.peanut.p2p.transaction.dao.TransactionlDao;
import com.peanut.p2p.transaction.model.entity.Transaction;
import com.peanut.p2p.util.CreditUtil;
import com.peanut.p2p.util.DateUtil;
import com.peanut.p2p.util.JaxbUtil;
import com.peanut.p2p.xml.Callback;
import com.peanut.p2p.xml.Parameter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by my on 2014/12/12.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    private static final Logger log = Logger.getLogger(ProductServiceImpl.class);
    @Resource
    private ProductDao productDao;
    @Resource
    private TransferDao transferDao;

    @Resource
    private Real_stockDao real_stockDao;

    @Resource
    private Search_stockDao searchStockDao;

    @Resource
    private BorrowOrderInfoDao borrowOrderInfoDao;
    @Resource
    private BoRepaymentPlanDao boRepaymentPlanDao;

    @Resource
    private BoRepaymentDetailDao boRepaymentDetailDao;
    @Resource
    private TransactionlDao transactionDao;

    @Override
    public Product queryByID(Long id) {
        return productDao.findById(Product.class,id);
    }

    @Override
    @Transactional
    public void doSave(Product product, Transfer transfer) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        product.setProductCode(df.format(new Date()));
        //设置状态为-2 发标待审核
        product.setStatusCode("-2");
        product.setEnterStatus("0");
       // product.setApprovalStatus("0");
        product.setAct_status(1);
        //设置发布状态
       // product.setReleaseStatus("0");
        //页面接收过来的结束时间
        String finishDate = transfer.getFinishDate();
        Date date = new Date();
        if (finishDate != null && !finishDate.equals("")) {
            finishDate = df.format(date);
            transfer.setFinishTime(Timestamp.valueOf(finishDate));
        }

        Real_stock real_stock = new Real_stock();
        Search_stock search_stock = new Search_stock();
        //获得buyType的值判断
        String buyType = product.getBuyType();
        BigDecimal totalAmount = null;
        if (buyType != null && buyType.equals("1")) {
            BigDecimal perValue = transfer.getPerValue();
            //标的总份
            Integer productTotal = transfer.getProductTotal();
            if (productTotal != null && !productTotal.equals("")) {
                //设置实际库存
                real_stock.setLeft_amount(BigDecimal.valueOf(productTotal));
                //设置虚拟库存
                search_stock.setLeft_amount(BigDecimal.valueOf(productTotal));

            } else {
                totalAmount = new BigDecimal(0);
                real_stock.setLeft_amount(totalAmount);
                //设置虚拟库存
                search_stock.setLeft_amount(totalAmount);
            }
            //标的总额
            totalAmount = product.getTotalMoney();
        } else if (buyType != null && buyType.equals("2")) {
            totalAmount = product.getTotalMoney();
            //设置实际库存
            real_stock.setLeft_amount(totalAmount);
            //设置虚拟库存
            search_stock.setLeft_amount(totalAmount);
        } else {
            totalAmount = new BigDecimal(0);
            real_stock.setLeft_amount(totalAmount);
            //设置虚拟库存
            search_stock.setLeft_amount(totalAmount);

        }
        //设置总金额
        product.setTotalMoney(totalAmount);
        doSave(product);
        //得到productId
        Long productId = product.getId();
        //设置实际库存ID
        real_stock.setProduct_id(String.valueOf(productId));
        //设置虚拟库存ID
        search_stock.setProduct_id(String.valueOf(productId));


        //设置productId
        transfer.setProductId(String.valueOf(product.getId()));

        //应付收益总额
        BigDecimal profitMoney = transfer.getProfitMoney();
        //标的总额
        BigDecimal totalMoney = product.getTotalMoney();
        //年化收益
        BigDecimal yearRate = product.getYearRate();
        //月综合费率
        BigDecimal monthRate = transfer.getMonth_rate();
        if(null == monthRate || ("").equals(monthRate)){
            monthRate = BigDecimal.valueOf(1);
            transfer.setMonth_rate(monthRate);
        }
        //锁标期
        Integer overTerm = transfer.getOver_term();
        //平台管理费
        BigDecimal manage_fee = transfer.getManage_fee();
        //交易手续费
        BigDecimal transfer_fee = transfer.getTransfer_fee();
        //违约金
        BigDecimal odd = transfer.getOdd();
        CreditUtil c = new CreditUtil();
        //计算收益总额
        if(null == profitMoney || ("").equals(profitMoney)){
            profitMoney = c.getProfitMoney(totalMoney,yearRate,overTerm);
            transfer.setProfitMoney(profitMoney);
        }
        //计算待还本息
        if(null== manage_fee || ("").equals(manage_fee)){
            manage_fee = BigDecimal.valueOf(0);
            transfer.setManage_fee(BigDecimal.valueOf(0));
        }
        if(null== transfer_fee || ("").equals(transfer_fee)){
            transfer_fee = BigDecimal.valueOf(0);
            transfer.setTransfer_fee(BigDecimal.valueOf(0));
        }
        if(null== odd || ("").equals(odd)){
            odd = BigDecimal.valueOf(0);
            transfer.setOdd(BigDecimal.valueOf(0));
        }
        //待还本息
        BigDecimal toPay = c.getToPay(totalMoney,monthRate,overTerm,manage_fee,transfer_fee,odd);
        transfer.setTo_pay(toPay);
        transferDao.save(transfer);

        real_stockDao.save(real_stock);


        searchStockDao.save(search_stock);
        String type = transfer.getType();
        Long id = product.getId();
        //得到投标结束时间
        Timestamp startPeriod = transfer.getEndTime();
        //得到锁标结束时间
        Timestamp overTime = transfer.getOver_time();
        //如果为散标，生成计划还款表
        if(null != type && ("S").equals(type)) {
            String userId = transfer.getAgent();
            BorrowOrderInfo borrowOrderInfo = borrowOrderInfoDao.findByUser(Integer.valueOf(userId));
            Integer orderId = borrowOrderInfo.getBorrow_order_id();
            //修改状态为筹款中
            borrowOrderInfoDao.updateById(orderId);
            BoRepaymentPlan boRepaymentPlan =  boRepaymentPlanDao.findByUserId(Integer.valueOf(userId));
            if(null !=boRepaymentPlan && !("").equals(boRepaymentPlan)) {
                boRepaymentPlan.setProduct_id(String.valueOf(id));
                boRepaymentPlan.setRepayment_startperiod(startPeriod);
                boRepaymentPlan.setFinish_time(overTime);
                boRepaymentPlan.setMonth_rate(monthRate);
                boRepaymentPlan.setComfee(manage_fee.add(transfer_fee));

               // boRepaymentPlan.setRep_total_money(repTotalMoney);
                boRepaymentPlanDao.update(boRepaymentPlan);
            }
        }
    }

    @Transactional
    public void doUpdate(ProductInfo productInfo) {
        //从页面接收过来的值
        Product product = productInfo.getProduct();
        //页面接收过来的结束时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();

        String finishDate = productInfo.getTransfer().getFinishDate();
        if (finishDate != null && !finishDate.equals("")) {
            finishDate = df.format(date);
            productInfo.getTransfer().setFinishTime(Timestamp.valueOf(finishDate));

        }
        //根据productId查询出来数据库中的值
        Product product1 = queryByID(product.getId());
        product.setProductCode(product1.getProductCode());
        product.setApprovalStatus(product1.getApprovalStatus());
        product.setEnterStatus(product1.getEnterStatus());
        product.setReleaseStatus(product1.getReleaseStatus());
        product.setStatusCode(product1.getStatusCode());
        product.setAct_status(product1.getAct_status());
        //设置实际库存
        Real_stock realStock = real_stockDao.findByPId(String.valueOf(product.getId()));
        //设置搜索库存
        Search_stock searchStock = searchStockDao.findByPId(String.valueOf(product.getId()));
        //获得buyType的值
        String buyType = product.getBuyType();
        BigDecimal totalAmount = null;
        if (buyType != null && buyType.equals("1")) {
            BigDecimal perValue = productInfo.getTransfer().getPerValue();
            //标的总份
            Integer productTotal = productInfo.getTransfer().getProductTotal();
            if (productTotal != null && !productTotal.equals("")) {
                //设置实际库存
                realStock.setLeft_amount(BigDecimal.valueOf(productTotal));
                //设置虚拟库存
                searchStock.setLeft_amount(BigDecimal.valueOf(productTotal));

            } else {
                totalAmount = new BigDecimal(0);
                realStock.setLeft_amount(totalAmount);
                //设置虚拟库存
                searchStock.setLeft_amount(totalAmount);
            }
            //标的总额
            totalAmount = productInfo.getProduct().getTotalMoney();
        } else if (buyType != null && buyType.equals("2")) {
            totalAmount = productInfo.getProduct().getTotalMoney();
            //设置实际库存
            realStock.setLeft_amount(totalAmount);
            //设置虚拟库存
            searchStock.setLeft_amount(totalAmount);
        } else {
            totalAmount = new BigDecimal(0);
            realStock.setLeft_amount(totalAmount);
            //设置虚拟库存
            searchStock.setLeft_amount(totalAmount);

        }
        //设置总金额
        product.setTotalMoney(totalAmount);
        doUpdate(product);
        //修改transfer
        Transfer transfer = productInfo.getTransfer();
        transfer.setProductId(String.valueOf(product.getId()));
        //应付收益总额
        BigDecimal profitMoney = transfer.getProfitMoney();
        //标的总额
        BigDecimal totalMoney = product.getTotalMoney();
        //年化收益
        BigDecimal yearRate = product.getYearRate();
        //月综合费率
        BigDecimal monthRate = transfer.getMonth_rate();
        if(null == monthRate || ("").equals(monthRate)){
            monthRate = BigDecimal.valueOf(1);
            transfer.setMonth_rate(monthRate);
        }
        //锁标期
        Integer overTerm = transfer.getOver_term();
        //平台管理费
        BigDecimal manage_fee = transfer.getManage_fee();
        //交易手续费
        BigDecimal transfer_fee = transfer.getTransfer_fee();
        //违约金
        BigDecimal odd = transfer.getOdd();
        //定义工具类
        CreditUtil cs = new CreditUtil();
        //计算收益总额（标的总额*年化收益率）/12*锁标期
        if(null == profitMoney || ("").equals(profitMoney)){
            profitMoney = cs.getProfitMoney(totalMoney, yearRate, overTerm);
            transfer.setProfitMoney(profitMoney);
        }

        if(null== manage_fee || ("").equals(manage_fee)){
            manage_fee = BigDecimal.valueOf(0);
            transfer.setManage_fee(BigDecimal.valueOf(0));
        }
        if(null== transfer_fee || ("").equals(transfer_fee)){
            transfer_fee = BigDecimal.valueOf(0);
            transfer.setTransfer_fee(BigDecimal.valueOf(0));
        }
        if(null== odd || ("").equals(odd)){
            odd = BigDecimal.valueOf(0);
            transfer.setOdd(BigDecimal.valueOf(0));
        }
        //计算待还本息 标的总额*月综合费率*借款期限+标的总额（本金）+平台服务费（管理费和手续费）+违约金
        BigDecimal toPay = cs.getToPay(totalMoney, monthRate, overTerm, manage_fee, transfer_fee, odd);
        transfer.setTo_pay(toPay);
        transferDao.update(transfer);
        if (realStock != null && !realStock.equals("")) {
            real_stockDao.update(realStock);
        }
        if (searchStock != null && !searchStock.equals("")) {
            searchStockDao.update(searchStock);

        }
        String type = transfer.getType();
        Long id = product.getId();
        //得到投标结束时间
        Timestamp startPeriod = transfer.getEndTime();
        //得到锁标结束时间
        Timestamp overTime = transfer.getOver_time();
        //如果为散标，生成计划还款表
        if(null != type && ("S").equals(type)) {
            String userId = transfer.getAgent();
            BoRepaymentPlan boRepaymentPlan =  boRepaymentPlanDao.findByUserId(Integer.valueOf(userId));
            if(null !=boRepaymentPlan && !("").equals(boRepaymentPlan)) {
                //修改结束时间
                boRepaymentPlan.setFinish_time(overTime);
                //修改月综合费率
                boRepaymentPlan.setMonth_rate(monthRate);
                boRepaymentPlanDao.update(boRepaymentPlan);

            }
        }
    }

    @Override
    @Transactional
    public String confirmZZ(long id) {
        String requestNo = null;
        String code = null;
        Transaction transaction;
        BigDecimal deal = new BigDecimal(1);
        //通过productId查询每次交易流水号
        List<Transaction> transactionList = transactionDao.findByPID(String.valueOf(id));
        for(int i=0;i<transactionList.size();i++){
            transaction = transactionList.get(i);
            requestNo = transaction.getOrder_no();
            code = repaymentConfirm(requestNo);
            //设置每次处理完成交易流水号
            transaction.setDeal_status(code);
            deal = deal.multiply(BigDecimal.valueOf(Long.valueOf(code)));
            //修改交易表中的code码
            transactionDao.update(transaction);
        }
        //查询type和agent
        Transfer transfer = transferDao.getByPid(String.valueOf(id));
        CreditUtil c = new CreditUtil();
        String type = transfer.getType();
        String userId = null;
        if(type != null && type.equals("S")) {
            userId = transfer.getAgent();
            //修改借款订单的状态
            borrowOrderInfoDao.updateByUserId(Integer.valueOf(userId));
            //根据userId查询借款订单
            BoRepaymentPlan boRepaymentPlan =  boRepaymentPlanDao.findByUserId(Integer.valueOf(userId));
            //得到借款期数
            int term = boRepaymentPlan.getLoan_term();
            BigDecimal payment = boRepaymentPlan.getTotal_money();

            //计算每个月应还金额
            BigDecimal payPerMonth = c.payPerMonth(payment, term);
            BigDecimal comFee = boRepaymentPlan.getComfee().divide(new BigDecimal(100), 4, RoundingMode.HALF_DOWN);

            BigDecimal payFirstMonth=c.payFirstMonth(payment,term,comFee);

            Map<String,List<BigDecimal>> map = c.detail(payment,payPerMonth,term);

            List<BigDecimal> list1= map.get("principalFees");

            List<BigDecimal> list2 = map.get("interestFees");
            //应还总额
            BigDecimal repTotalMoney = new BigDecimal(0);

            boRepaymentPlan.setTerminal_money(payPerMonth);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //获取当前系统时间
            Timestamp date2 = Timestamp.valueOf(format.format(new Date()));
            for (int i = 0; i < term; i++) {
                //月份加1
                String date5 = DateUtil.getMonthToStr("yyyy-MM-dd HH:mm:ss", date2.toString(), i + 1);
                //计划还款详细表
                BoRepaymentDetail brd = new BoRepaymentDetail();
                brd.setProduct_id(Integer.valueOf(boRepaymentPlan.getProduct_id()));
                if (i == 0) {
                    brd.setRepayment_money(payFirstMonth);
                }else {
                    brd.setRepayment_money(payPerMonth);
                }
                repTotalMoney = repTotalMoney.add(brd.getRepayment_money());
                //设置第几期
                brd.setTerm(i + 1);
                //设置第几个月
                brd.setRepayment_time(Timestamp.valueOf(date5));
                BigDecimal principalFee =  list1.get(i);
                BigDecimal interestFee =  list2.get(i);
                brd.setInterest_fee(interestFee);
                brd.setPrincipal_fee(principalFee);
                boRepaymentDetailDao.save(brd);
            }
            boRepaymentPlan.setRepayment_startperiod(date2);
            boRepaymentPlan.setRep_total_money(repTotalMoney);
            boRepaymentPlanDao.update(boRepaymentPlan);
        }
        if(deal != null && deal.equals(1)){
            return String.valueOf(deal);
        }
            return null;

    }

    @Override
    public void doDelete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> getEndTimeafterSysTime() {
        return productDao.getTBZ();
    }

    @Override
    public List<Product> getSysTimeafterEndTime() {
        return productDao.getSAE();
    }

    @Override
    public List<Product> queryList() {
        return productDao.getSList();
    }

    @Override
    public List<Product> queryMBList() {
        return productDao.getMBList();
    }

    @Override
    public void doUpdate(Long id) {
        productDao.update(id);
    }

    @Override
    public void doUpdateEnter(Long id) {
        String enterStatus = "3" ;
        productDao.updateEnterS(enterStatus,id);
    }

    @Override
    public void doUpdateStatus(String statusCode,Long id) {
        productDao.updateStatus(statusCode,id);
    }

    @Override
    public void doSave(Product product) {
        productDao.save(product);
    }
    @Override
    public void doUpdate(Product product) {

        productDao.update(product);

    }
    /**
     * 接入转账确认接口
     * @param requestNo
     */
    public String repaymentConfirm(String requestNo){
        Parameter parameter=new Parameter();
        parameter.setRequestNo(requestNo);
        parameter.setMode("CONFIRM");
        parameter.setPlatformNo("10012464691");
        parameter.setNotifyUrl("www.baidu.com");
        JaxbUtil requestBinder = new JaxbUtil(Parameter.class,
                JaxbUtil.CollectionWrapper.class);
        String strXml=requestBinder.toXml(parameter,"utf-8");
        strXml = strXml.replaceAll("\r","");
        String req = strXml.replaceAll("\n","");
        //调用接口
        try {
            log.info("开始传参");
        }catch (Exception e){

        }
        System.out.println("开始确认");
        HttpClient client = new HttpClient();
        client.getParams().setContentCharset("utf-8");
        PostMethod post = new PostMethod("http://119.161.147.110:8088/member/bhaexter/bhaController");
        post.addParameter("req", req);
        post.addParameter("sign", "signdata");
        post.addParameter("service", "COMPLETE_TRANSACTION");
        try {
            client.executeMethod(post);
            Reader r = new InputStreamReader(post.getResponseBodyAsStream(), "utf-8");
            String resp= IOUtils.toString(r);
            log.info(resp);
            JaxbUtil requestBinder1 = new JaxbUtil(Callback.class,
                    JaxbUtil.CollectionWrapper.class);
            Callback callback = requestBinder1.fromXml(resp);
            String code=callback.getCode();
            return code;
        }catch (Exception e){

        }
        return null;
    }

}
