package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.*;
import com.peanut.p2p.products.model.query.BoRepaymentPlanQueryObject;
import com.peanut.p2p.products.model.query.TBoRepaymentPlanQueryObject;
import com.peanut.p2p.products.model.query.VBorrowRepaymentPlanQueryObject;
import com.peanut.p2p.products.model.query.VRepaymentPlanQueryObject;
import com.peanut.p2p.products.service.BoRepaymentDetailService;
import com.peanut.p2p.products.service.BoRepaymentPlanService;
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
 * @author my
 * @version 1.0
 */
@Controller
public class BoRepaymentPlanController {
    @Resource
    private BoRepaymentPlanService boRepaymentPlanService;
    @Resource
    private BoRepaymentDetailService boRepaymentDetailService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String BO_REPAYMENT_PLAN_QUERY_MODEL_NAME = "boRepaymentPlanQueryObject";

    private static final String BO_REPAYMENT_PLAN_PAGE_MODEL_NAME = "boRepaymentPlanPage";

    private static final String VBO_REPAYMENT_PLAN_QUERY_MODEL_NAME = "vboRepaymentPlanQueryObject";

    private static final String VBO_REPAYMENT_PLAN_PAGE_MODEL_NAME = "vboRepaymentPlanPage";

    private static final String BO_REPAYMENT_PLAN_MODEL_NAME = "boRepaymentPlanModel";

    private static final String BO_REPAYMENT_DETAIL_MODEL_NAME = "boRepaymentDetailModel";

    @RequestMapping(value = "/boRepaymentPlan/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BO_REPAYMENT_PLAN_MODEL_NAME)) {
            model.addAttribute(BO_REPAYMENT_PLAN_MODEL_NAME, new BoRepaymentPlan());
        }
        return "products/boRepaymentPlan/add";
    }

    @RequestMapping(value = "/boRepaymentPlan/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BO_REPAYMENT_PLAN_QUERY_MODEL_NAME) TBoRepaymentPlanQueryObject boRepaymentPlanQueryObject,
            Model model) {
        if(null == boRepaymentPlanQueryObject){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            boRepaymentPlanQueryObject.setOrders(ss);
        }
        boRepaymentPlanQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(boRepaymentPlanQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<TBoRepaymentPlan> boRepaymentPlanPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(BO_REPAYMENT_PLAN_PAGE_MODEL_NAME, boRepaymentPlanPage);
        model.addAttribute(BO_REPAYMENT_PLAN_QUERY_MODEL_NAME, boRepaymentPlanQueryObject);
        return "products/boRepaymentPlan/index";
    }

    @RequestMapping(value = "/boRepaymentPlan/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(VBO_REPAYMENT_PLAN_QUERY_MODEL_NAME) VBorrowRepaymentPlanQueryObject boRepaymentPlanQueryObject,
            Model model) {
        if(null == boRepaymentPlanQueryObject){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            boRepaymentPlanQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(boRepaymentPlanQueryObject);
        queryInfo.setPageNum(pageNum);
        Page<VBorrowRepaymentPlan> boRepaymentPlanPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(VBO_REPAYMENT_PLAN_PAGE_MODEL_NAME, boRepaymentPlanPage);
        model.addAttribute(VBO_REPAYMENT_PLAN_QUERY_MODEL_NAME, boRepaymentPlanQueryObject);
        return "products/boRepaymentPlan/indexList";
    }

    @RequestMapping(value = "/boRepaymentPlan/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(BO_REPAYMENT_PLAN_MODEL_NAME) @Valid BoRepaymentPlan boRepaymentPlan,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(BO_REPAYMENT_PLAN_MODEL_NAME, boRepaymentPlan);
            return gotoAdd(model);
        }
        boRepaymentPlanService.doSave(boRepaymentPlan);
        return "products/boRepaymentPlan/success";
    }

    @RequestMapping(value = "/boRepaymentPlan/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(BO_REPAYMENT_PLAN_MODEL_NAME)) {
            BoRepaymentPlan boRepaymentPlan = boRepaymentPlanService.queryByID(id);
            model.addAttribute(BO_REPAYMENT_PLAN_MODEL_NAME, boRepaymentPlan);
        }
        return "products/boRepaymentPlan/update";
    }
    @RequestMapping(value = "/boRepaymentPlan/{id}/info", method = RequestMethod.GET)
    public String gotoInfo(@PathVariable Integer id, Model model) {

        if(!model.containsAttribute(BO_REPAYMENT_DETAIL_MODEL_NAME)){
            List<BoRepaymentDetail> boRepaymentDetails = boRepaymentDetailService.findByProductId(id);
            model.addAttribute(BO_REPAYMENT_DETAIL_MODEL_NAME,boRepaymentDetails);
        }

        return "products/boRepaymentPlan/info";
    }
    @RequestMapping(value = "/boRepaymentPlan/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(BO_REPAYMENT_PLAN_MODEL_NAME) @Valid BoRepaymentPlan boRepaymentPlan,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(BO_REPAYMENT_PLAN_MODEL_NAME, boRepaymentPlan);
            return gotoUpdate(boRepaymentPlan.getId(), model);
        }
        boRepaymentPlanService.doUpdate(boRepaymentPlan);
        return "products/boRepaymentPlan/success";
    }

    @RequestMapping(value = "/boRepaymentPlan/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "products/boRepaymentPlan/delete";
    }

    @RequestMapping(value = "/boRepaymentPlan/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        boRepaymentPlanService.doUpdate(id);
        return "products/boRepaymentPlan/success";
    }
    @RequestMapping(value = "/boRepaymentPlan/download")
    public String download(@ModelAttribute(VBO_REPAYMENT_PLAN_QUERY_MODEL_NAME) VBorrowRepaymentPlanQueryObject vRepaymentPlanQueryObject,HttpServletRequest request,HttpServletResponse response) throws IOException {
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String date = date1.format(new Date());
        String fileName="计划还款统计列表"+ date;
        //填充VRepaymentPlan数据
        List<VBorrowRepaymentPlan> vRepaymentPlans = createData(vRepaymentPlanQueryObject);
        List<Map<String,Object>> list= createExcelRecord(vRepaymentPlans);
        String columnNames[]={"ID","标的名称","借款金额","标的种类","年化收益","借款期限","借款人","借款时间","还款类型","还款总额","每期应还金额","开始还款时间","结束时间","银行名称","开户行支行","卡号"};//列名
        String keys[]   =    {"id","product_name","total_money","type","year_rate","over_term","user_id","","repayment_type","rep_total_money","terminal_money","repayment_startperiod","finish_time","bank_name","bank_branch","bank_card_no"};//map中的key
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
    private List<VBorrowRepaymentPlan> createData(VBorrowRepaymentPlanQueryObject vRepaymentPlanQueryObject) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(vRepaymentPlanQueryObject);
        List<VBorrowRepaymentPlan> list = pageService.queryDefaultListSize(queryInfo);
        return list;
    }
    private List<Map<String, Object>> createExcelRecord(List<VBorrowRepaymentPlan> vRepaymentPlans) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        VBorrowRepaymentPlan vRepaymentPlan = null;
        for (int j = 0; j < vRepaymentPlans.size(); j++) {
            vRepaymentPlan= vRepaymentPlans.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("id", vRepaymentPlan.getId());
            mapValue.put("product_name", vRepaymentPlan.getProduct_name());
            mapValue.put("total_money", vRepaymentPlan.getTotal_money());
            mapValue.put("type", vRepaymentPlan.getType());
            mapValue.put("year_rate", vRepaymentPlan.getYear_rate());
            mapValue.put("over_term", vRepaymentPlan.getOver_term());
            mapValue.put("user_id", vRepaymentPlan.getUser_id());
            mapValue.put("", vRepaymentPlan.getUser_id());
            mapValue.put("repayment_type", vRepaymentPlan.getRepayment_type());
            mapValue.put("rep_total_money", vRepaymentPlan.getRep_total_money());
            mapValue.put("terminal_money", vRepaymentPlan.getTerminal_money());
            mapValue.put("repayment_startperiod", vRepaymentPlan.getRepayment_startperiod());
            mapValue.put("finish_time", vRepaymentPlan.getFinish_time());
            mapValue.put("bank_name", vRepaymentPlan.getBank_name());
            mapValue.put("bank_branch", vRepaymentPlan.getBank_branch());
            mapValue.put("bank_card_no", vRepaymentPlan.getBank_card_no());
            listmap.add(mapValue);
        }
        return listmap;
    }
}