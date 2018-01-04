package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.ActualRepaymentPlan;
import com.peanut.p2p.products.model.entity.VActualRepayment;
import com.peanut.p2p.products.model.query.ActualRepaymentPlanQueryObject;
import com.peanut.p2p.products.model.query.VActualRepaymentQueryObject;
import com.peanut.p2p.products.service.ActualRepaymentPlanService;
import com.peanut.p2p.util.ExcelUtil;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by my on 2015/4/11.
 */
@Controller
public class ActualRepaymentPlanController {

    @Resource
    private ActualRepaymentPlanService actualRepaymentPlanService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String ACTUALREPAYMENT_QUERY_MODEL_NAME = "actualRepaymentPlanQueryObject";

    private static final String ACTUALREPAYMENT_PAGE_MODEL_NAME = "actualRepaymentPlanPage";

    private static final String VACTUALREPAYMENT_QUERY_MODEL_NAME = "vActualRepaymentPlanQueryObject";

    private static final String VACTUALREPAYMENT_PAGE_MODEL_NAME = "vActualRepaymentPlanPage";

    private static final String ACTUALREPAYMENT_MODEL_NAME = "actualRepaymentPlanModel";

    @RequestMapping(value = "/actualRepaymentPlan/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(ACTUALREPAYMENT_MODEL_NAME)) {
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, new ActualRepaymentPlan());
        }
        return "products/actualRepaymentPlan/add";
    }

    @RequestMapping(value = "/actualRepaymentPlan/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ACTUALREPAYMENT_QUERY_MODEL_NAME) ActualRepaymentPlanQueryObject actualRepaymentPlanQueryObject,
            Model model) {
        if(null == actualRepaymentPlanQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            actualRepaymentPlanQueryObject.setOrders(ss);
        }
        actualRepaymentPlanQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(actualRepaymentPlanQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<ActualRepaymentPlan> actualRepaymentPlanPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(ACTUALREPAYMENT_PAGE_MODEL_NAME, actualRepaymentPlanPage);
        model.addAttribute(ACTUALREPAYMENT_QUERY_MODEL_NAME, actualRepaymentPlanQueryObject);
        return "products/actualRepaymentPlan/index";
    }
    @RequestMapping(value = "/actualRepaymentPlan/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(VACTUALREPAYMENT_QUERY_MODEL_NAME) VActualRepaymentQueryObject actualRepaymentPlanQueryObject,
            Model model) {
        if(null == actualRepaymentPlanQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            actualRepaymentPlanQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(actualRepaymentPlanQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<VActualRepayment> actualRepaymentPlanPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(VACTUALREPAYMENT_PAGE_MODEL_NAME, actualRepaymentPlanPage);
        model.addAttribute(VACTUALREPAYMENT_QUERY_MODEL_NAME, actualRepaymentPlanQueryObject);
        return "products/actualRepaymentPlan/indexList";
    }

    @RequestMapping(value = "/actualRepaymentPlan/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(ACTUALREPAYMENT_MODEL_NAME) @Valid ActualRepaymentPlan actualRepaymentPlan,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, actualRepaymentPlan);
            return gotoAdd(model);
        }
        actualRepaymentPlanService.doSave(actualRepaymentPlan);
        return "products/products/actualRepaymentPlan/success";
    }

    @RequestMapping(value = "/actualRepaymentPlan/{actual_repayment_id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer actual_repayment_id, Model model) {
        if (!model.containsAttribute(ACTUALREPAYMENT_MODEL_NAME)) {
            ActualRepaymentPlan actualRepaymentPlan = actualRepaymentPlanService.queryByID(actual_repayment_id);
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, actualRepaymentPlan);
        }
        return "products/actualRepaymentPlan/update";
    }

    @RequestMapping(value = "/actualRepaymentPlan/{actual_repayment_id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(ACTUALREPAYMENT_MODEL_NAME) @Valid ActualRepaymentPlan actualRepaymentPlan,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, actualRepaymentPlan);
            return gotoUpdate(actualRepaymentPlan.getId(), model);
        }
        actualRepaymentPlanService.doUpdate(actualRepaymentPlan);
        return "products/actualRepaymentPlan/success";
    }

    @RequestMapping(value = "/actualRepaymentPlan/{actual_repayment_id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "products/actualRepaymentPlan/delete";
    }

    @RequestMapping(value = "/actualRepaymentPlan/{actual_repayment_id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer actual_repayment_id) {
        actualRepaymentPlanService.doUpdate(actual_repayment_id);
        return "products/actualRepaymentPlan/success";
    }
    @RequestMapping(value = "/actualRepaymentPlan/download")
    public String download(@ModelAttribute(VACTUALREPAYMENT_QUERY_MODEL_NAME) VActualRepaymentQueryObject vRepaymentPlanQueryObject,HttpServletRequest request,HttpServletResponse response) throws IOException {
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String date = date1.format(new Date());
        String fileName="计划还款统计列表"+ date;
        //填充VRepaymentPlan数据
        List<VActualRepayment> vRepaymentPlans = createData(vRepaymentPlanQueryObject);
        List<Map<String,Object>> list= createExcelRecord(vRepaymentPlans);
        String columnNames[]={"ID","标的名称","标的总额","年化收益","借款期限","标的种类","投资人","投资金额","应付收益时间","应付收益金额","银行名称","开户行支行","卡号","到账时间","到账金额","是否异常"};//列名
        String keys[]   =    {"id","productName","totalMoney","yearRate","overTerm","type","userName","investMoney","repaymentTime","money","bankName","bankBranch","cardNo","cardNo","cardNo","cardNo"};//map中的keyime","bank_name","bank_branch","bank_card_no"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        ExcelUtil.setRespo(is,response,fileName);
        return null;
    }
    private List<VActualRepayment> createData(VActualRepaymentQueryObject vRepaymentPlanQueryObject) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(vRepaymentPlanQueryObject);
        List<VActualRepayment> list = pageService.queryDefaultListSize(queryInfo);
        return list;
    }
    private List<Map<String, Object>> createExcelRecord(List<VActualRepayment> vRepaymentPlans) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        VActualRepayment vRepaymentPlan = null;
        for (int j = 0; j < vRepaymentPlans.size(); j++) {
            vRepaymentPlan= vRepaymentPlans.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("id", vRepaymentPlan.getId());
            mapValue.put("productName", vRepaymentPlan.getProductName());
            mapValue.put("yearRate", vRepaymentPlan.getYearRate());
            mapValue.put("totalMoney", vRepaymentPlan.getTotalMoney());
            mapValue.put("overTerm", vRepaymentPlan.getOverTerm());
            mapValue.put("type", vRepaymentPlan.getType());
            mapValue.put("userName", vRepaymentPlan.getUserName());
            mapValue.put("investMoney", vRepaymentPlan.getInvestMoney());
            mapValue.put("repaymentTime", vRepaymentPlan.getRepaymentTime());
            mapValue.put("money", vRepaymentPlan.getMoney());
            mapValue.put("bankName", vRepaymentPlan.getBankName());
            mapValue.put("bankBranch", vRepaymentPlan.getBankBranch());
            mapValue.put("cardNo", vRepaymentPlan.getCardNo());
            listmap.add(mapValue);

        }
        return listmap;
    }
}
