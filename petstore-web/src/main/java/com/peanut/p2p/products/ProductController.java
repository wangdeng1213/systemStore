package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Agent;
import com.peanut.p2p.code.model.entity.EnsureType;
import com.peanut.p2p.code.service.AgentService;
import com.peanut.p2p.code.service.EnsureTypeService;
import com.peanut.p2p.log.SysControllerLog;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.*;
import com.peanut.p2p.products.model.query.VproductQueryObject;
import com.peanut.p2p.products.service.*;
import com.peanut.p2p.transaction.model.entity.Transaction;
import com.peanut.p2p.transaction.service.TransactionService;
import com.peanut.p2p.user.model.entity.InvestRecord;
import com.peanut.p2p.user.service.InvestRecordService;
import com.peanut.pagination.page.Page;
import com.peanut.pagination.pageFactory.PageFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @version 1.0
 * @my
 */
@Controller
public class ProductController {
    private static final Logger log = Logger.getLogger(ProductController.class);
    @Resource
    private ProductService productService;

    @Resource
    private RiskinfoService riskinfoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @Resource
    private AgentService agentService;

    @Resource
    private EnsureTypeService ensureTypeService;

    @Resource
    private TransferService transfer_Service;

    @Resource
    private Real_stockService real_stockService;

    @Resource
    private Search_stockService search_stockService;
    @Resource
    private InvestRecordService investRecordService;
    @Resource
    private TransactionService transactionService;
    @Resource
    private BorrowOrderInfoService borrowOrderInfoService;

    private static final String ALL_AGENT_MODEL = "allAgentModel";

    private static final String ALL_RISKINFO_MODEL = "allRiskinfoModel";

    private static final String TRANSFER_MODEL_NAME = "transferModel";

    private static final String PRODUCT_QUERY_MODEL_NAME = "productQueryObject";

    private static final String PRODUCT_PAGE_MODEL_NAME = "productPage";

    private static final String PRODUCT_MODEL_NAME = "productModel";

    private static final String PRODUCT_INFO_MODEL_NAME = "productInfoModel";

    private static final String REAL_STOCK_MODEL_NAME = "realStockModel";

    private static final String AGENT_MODEL_NAME = "agentModel";

    private static final String RISK_INFO_MODEL_NAME = "riskInfoModel";

    private static final String ENSURE_TYPE_MODEL_NAME = "ensureTypeModel";

    private static final String ALL_ENSURETYPE_MODEL = "allEnsureTypeModel";

    private static final String PRODUCT_NAME = "product";
    private static final String TRANSFER_NAME = "transfer";

    @ModelAttribute(ALL_RISKINFO_MODEL)
    public List<Riskinfo> getAllRisk() {
        return riskinfoService.queryAll();
    }

    @ModelAttribute(ALL_AGENT_MODEL)
    public List<Agent> getAllAgent() {
        return agentService.queryAll();
    }

    @ModelAttribute(ALL_ENSURETYPE_MODEL)
    public List<EnsureType> getAllEnsureType() {
        return ensureTypeService.queryAll();
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(TRANSFER_NAME)){
            model.addAttribute(TRANSFER_NAME, new Transfer());
        }
        if (!model.containsAttribute(PRODUCT_NAME)) {
            model.addAttribute(PRODUCT_NAME, new Product());
        }
        return "products/product/add";
    }

    @RequestMapping(value = "/transfer/{pid}/info", method = RequestMethod.GET)
    public String gotoInfo(Model model, @PathVariable String pid) {
        Transfer t = transfer_Service.queryByPID(pid);
        //得到agent信息和riskinfo信息ensureType
        if (null != t.getAgent() && !("").equals(t.getAgent())) {
            Integer id = Integer.valueOf(t.getAgent());
            Agent agent = agentService.queryByUserID(id);
            model.addAttribute(AGENT_MODEL_NAME, agent);
        } else {
            return "errors/error";
        }
        if (null != t.getRiskInfo() && !("").equals(t.getRiskInfo())) {
            Long id2 = Long.valueOf(t.getRiskInfo());
            Riskinfo riskinfo = riskinfoService.queryByID(id2);
            model.addAttribute(RISK_INFO_MODEL_NAME, riskinfo);
        } else {
            return "errors/error";
        }
        if (null != t.getEnsureType() && !("").equals(t.getEnsureType())) {
            Integer id3 = Integer.valueOf(t.getEnsureType());
            EnsureType ensureType = ensureTypeService.queryByID(id3);
            model.addAttribute(ENSURE_TYPE_MODEL_NAME, ensureType);
        } else {
            return "errors/error";
        }
        Product p = productService.queryByID(Long.valueOf(pid));
        model.addAttribute(TRANSFER_MODEL_NAME, t);
        model.addAttribute(PRODUCT_MODEL_NAME, p);
        Real_stock realStock = real_stockService.queryByPID(pid);
        model.addAttribute(REAL_STOCK_MODEL_NAME, realStock);
        return "products/transfer/info";
    }

    @RequestMapping(value = "/product/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRODUCT_QUERY_MODEL_NAME) VproductQueryObject productQueryObject,
            Model model) {
        //查询当前系统时间是否大于预发布时间，修改状态位
        List<Product> list = productService.getEndTimeafterSysTime();
        for(int i = 0; i< list.size();i++){
            Product product1 = list.get(i);
            Long id = product1.getId();
            //设置statusCode由预发布0变为1
            String statusCode = "1";
            productService.doUpdateStatus(statusCode,id);
        }
        //查询当前系统时间是否大于投标结束时间，修改状态位为投标结束7
        List<Product> list2 = productService.getSysTimeafterEndTime();
        for(int i = 0; i< list2.size();i++){
            Product product1 = list2.get(i);
            Long id = product1.getId();
            //设置statusCode由投标中1变为投标结束7
            String statusCode = "7";
            productService.doUpdateStatus(statusCode,id);
        }
        //设置激活状态默认为1
        productQueryObject.setAct_status(1);
        if(null == productQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id",OrderType.desc);
            productQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(productQueryObject);
        queryInfo.setPageNum(pageNum);
        Page<Product> productPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(PRODUCT_PAGE_MODEL_NAME, productPage);
        model.addAttribute(PRODUCT_QUERY_MODEL_NAME, productQueryObject);
        return "products/product/index";
    }
    @RequestMapping(value = "/product/queryMBList", method = RequestMethod.GET)
    public String mbList(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRODUCT_QUERY_MODEL_NAME) VproductQueryObject productQueryObject,
            Model model) {
        //查询当前系统时间是否大于预发布时间，修改状态位
        List<Product> list = productService.getEndTimeafterSysTime();
        for(int i = 0; i< list.size();i++){
            Product product1 = list.get(i);
            Long id = product1.getId();
            //设置statusCode由预发布0变为1
            String statusCode = "1";
            productService.doUpdateStatus(statusCode,id);
        }
        //查询当前系统时间是否大于投标结束时间，修改状态位为投标结束7
        List<Product> list2 = productService.getSysTimeafterEndTime();
        for(int i = 0; i< list2.size();i++){
            Product product1 = list2.get(i);
            Long id = product1.getId();
            //设置statusCode由投标中1变为投标结束7
            String statusCode = "7";
            productService.doUpdateStatus(statusCode,id);
        }
        List<Product> productList = productService.queryMBList();
        Page<Product> productPage = PageFactory.createSearchedAllListPage(10,pageNum,productList);
        model.addAttribute(PRODUCT_PAGE_MODEL_NAME, productPage);
        model.addAttribute(PRODUCT_QUERY_MODEL_NAME, productQueryObject);
        return "products/product/mblist";
    }
    @RequestMapping(value = "/product/{id}/queryTransaction",method = RequestMethod.GET)
    public String queryTransaction(@PathVariable("id") String id,Model model){
        List<Transaction> transactionList =  transactionService.queryByPID(id);
        model.addAttribute("transactionList",transactionList);
        return "transactions/transaction/tlist";
    }
    @RequestMapping(value = "/product/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRODUCT_QUERY_MODEL_NAME) VproductQueryObject productQueryObject,
            Model model) {

        //查询当前系统时间是否大于预发布时间，修改状态位
        List<Product> list = productService.getEndTimeafterSysTime();
        for(int i = 0; i< list.size();i++){
            Product product1 = list.get(i);
            Long id = product1.getId();
            //设置statusCode由预发布0变为1
            String statusCode = "1";
            productService.doUpdateStatus(statusCode,id);
        }
        //查询当前系统时间是否大于投标结束时间，修改状态位为投标结束7
        List<Product> list2 = productService.getSysTimeafterEndTime();
        for(int i = 0; i< list2.size();i++){
            Product product1 = list2.get(i);
            Long id = product1.getId();
            //设置statusCode由投标中1变为投标结束7
            String statusCode = "7";
            productService.doUpdateStatus(statusCode,id);
        }
        List<Product> productList =  productService.queryList();
        Page<Product> productPage = PageFactory.createSearchedAllListPage(10, pageNum, productList);

        model.addAttribute(PRODUCT_PAGE_MODEL_NAME, productPage);
        model.addAttribute(PRODUCT_QUERY_MODEL_NAME, productQueryObject);
        return "products/product/indexlist";
    }
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(PRODUCT_NAME) @Valid Product product,
                      BindingResult result,
                      @ModelAttribute(TRANSFER_NAME) @Valid Transfer transfer,
                      BindingResult result1) {
        if (result.hasErrors()) {
            model.addAttribute(PRODUCT_NAME, product);
            return gotoAdd(model);
        }
        if(result1.hasErrors()){
            model.addAttribute(TRANSFER_NAME, transfer);
            return gotoAdd(model);
        }
        productService.doSave(product, transfer);
        return "products/transfer/success";
    }

    /**
     * 发布
     */
    @RequestMapping(value = "/product/{id}/release", method = RequestMethod.GET)
    public String gotoRelease(@PathVariable Long id, Model model) {
        Product product = productService.queryByID(id);
        if (!model.containsAttribute(PRODUCT_MODEL_NAME)) {
            model.addAttribute(PRODUCT_MODEL_NAME, product);
        }
      //  product.setReleaseStatus("1");
        product.setStatusCode("0");
        productService.doUpdate(product);
        return "products/product/success";
    }

    /*审批*/
    @RequestMapping(value = "/product/{pid}/approval", method = RequestMethod.GET)
    public String gotoApproval(@PathVariable Long pid, Model model) {
        //进入详细页面
        gotoInfo(model, String.valueOf(pid));
        if (!model.containsAttribute(PRODUCT_MODEL_NAME)) {
            model.addAttribute(PRODUCT_MODEL_NAME, new Product());
        }
        return "products/product/approval";
    }

    @RequestMapping(value = "/product/{id}/approval", method = RequestMethod.POST)
    public String approval(@PathVariable Long id, Model model, @ModelAttribute(PRODUCT_MODEL_NAME) Product product,
                           BindingResult result) {
        if (!model.containsAttribute(PRODUCT_MODEL_NAME)) {
            model.addAttribute(PRODUCT_MODEL_NAME, product);
        }
        Product product1 = productService.queryByID(id);
        String approval_opinion = product.getApproval_opinion();
        String status = product.getStatusCode();
        if (status != null && !status.equals("")) {
            //为1时审批通过
            if (status.equals("-1")) {
              /*设置状态为-1，如果审核通过，则为待发布*/
                product1.setStatusCode("-1");
            }
            if (status.equals("21")) {
                // 为2时审批驳回
                /*设置状态为-2，如果审核未通过，则为发标待审核*/
                product1.setStatusCode("-2");
            }
        } else {
            return "errors/error";
        }

        //设置审核时间
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        product1.setVerify_time(Timestamp.valueOf(time));
        productService.doUpdate(product1);
        return "products/product/success";
    }

    @RequestMapping(value = "/product/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable long id, Model model) {
        if (!model.containsAttribute(PRODUCT_INFO_MODEL_NAME) ) {
            ProductInfo productInfo = new ProductInfo();
            Product product = productService.queryByID(id);
            productInfo.setProduct(product);
            Transfer transfer = transfer_Service.queryByPID(String.valueOf(id));
            productInfo.setTransfer(transfer);
            model.addAttribute(PRODUCT_INFO_MODEL_NAME, productInfo);
        }
        return "products/product/update";
    }
    @RequestMapping(value = "/product/{id}/update", method = RequestMethod.POST)
    public String update(
            @ModelAttribute(PRODUCT_INFO_MODEL_NAME)@Valid ProductInfo productInfo,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(PRODUCT_INFO_MODEL_NAME, productInfo);
            return gotoUpdate(productInfo.getProduct().getId(), model);
        }
        productService.doUpdate(productInfo);
        return "products/product/success";
    }
    //跳转转账
    @RequestMapping(value = "/product/{id}/toZZ", method = RequestMethod.GET)
    public String toZZ(@PathVariable long id,Model model){
        Product product = productService.queryByID(id);
        model.addAttribute("productList",product);
        Transfer transfer = transfer_Service.queryByPID(String.valueOf(id));
        if (null != transfer.getAgent() && !("").equals(transfer.getAgent())) {
            Integer userId = Integer.valueOf(transfer.getAgent());
            Agent agent = agentService.queryByUserID(userId);
            model.addAttribute(AGENT_MODEL_NAME, agent);
        } else {
            return "errors/error";
        }
        String productId = String.valueOf(id);
        List<InvestRecord> investRecords = investRecordService.queryByPID(productId);
        model.addAttribute("investRecordList",investRecords);
        return "products/product/zz";
    }
    //确认转账
    @RequestMapping(value = "/product/{id}/confirmZZ", method = RequestMethod.POST)
    public String confirmZZ(@PathVariable long id,Model model){
      String code =   productService.confirmZZ(id);
      if(code != null && code.equals("1")){
          model.addAttribute("confirmList","转账成功");
      }else{
          model.addAttribute("confirmList","转账失败，请查询交易记录");
      }
      return toZZ(id,model);
    }
    //延時
    @RequestMapping(value = "/product/{id}/toDelay", method = RequestMethod.GET)
    public String toPay(@PathVariable long id,Model model){
        if (!model.containsAttribute(TRANSFER_MODEL_NAME)) {
            Transfer transfer1 = transfer_Service.queryByPID(String.valueOf(id));
            model.addAttribute(TRANSFER_MODEL_NAME, transfer1);
        }
       return "products/product/topay";
    }
    //延時
    @RequestMapping(value = "/product/{id}/Delay", method = RequestMethod.POST)
    public String Delay(@PathVariable long id,Timestamp endTime){
        transfer_Service.doUpdate(id,endTime);
        return "products/product/success";
    }
    @RequestMapping(value = "/product/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "product/delete";
    }

    @RequestMapping(value = "/product/{id}/delete", method = RequestMethod.DELETE)
    @SysControllerLog(description = "删除标的")
    public String delete(@PathVariable Long id) {
        productService.doUpdate(id);
        return "products/product/success";
    }

}