package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.editor.EnumEditor;
import com.peanut.p2p.products.model.entity.Repayment_plan;
import com.peanut.p2p.products.model.entity.VRepaymentPlan;
import com.peanut.p2p.products.model.query.Repayment_planQueryObject;
import com.peanut.p2p.products.model.query.VRepaymentPlanQueryObject;
import com.peanut.p2p.products.service.Repayment_planService;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.service.VRepaymentPlanService;
import com.peanut.p2p.user.model.entity.VInvestRecord;
import com.peanut.p2p.util.ExcelUtil;
import com.peanut.pagination.page.Page;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author
 * @version 1.0
 */
@Controller
public class Repayment_planController {
   @Resource
   private Repayment_planService repayment_planService;
    @Resource
    private VRepaymentPlanService vRepaymentPlanService;
    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String REPAYMENT_PLAN_QUERY_MODEL_NAME = "repayment_planQueryObject";

    private static final String REPAYMENT_PLAN_PAGE_MODEL_NAME = "repayment_planPage";

    private static final String REPAYMENT_PLAN_MODEL_NAME = "repayment_planModel";

    private static final String VREPAYMENT_PLAN_QUERY_MODEL_NAME = "vRepaymentPlanQueryObject";

    private static final String VREPAYMENT_PLAN_PAGE_MODEL_NAME = "vRepaymentPlanPage";

    @RequestMapping(value = "/repayment_plan/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(REPAYMENT_PLAN_MODEL_NAME)) {
            model.addAttribute(REPAYMENT_PLAN_MODEL_NAME, new Repayment_plan());
        }
        return "products/repayment_plan/add";
    }

    @RequestMapping(value = "/repayment_plan/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(REPAYMENT_PLAN_QUERY_MODEL_NAME) Repayment_planQueryObject repayment_planQueryObject,
            Model model) {
        if(null == repayment_planQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id", OrderType.desc);
            repayment_planQueryObject.setOrders(ss);
        }
        repayment_planQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(repayment_planQueryObject);
        queryInfo.setPageNum(pageNum);
        Page<Repayment_plan> repayment_planPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(REPAYMENT_PLAN_PAGE_MODEL_NAME, repayment_planPage);
        model.addAttribute(REPAYMENT_PLAN_QUERY_MODEL_NAME, repayment_planQueryObject);
        return "products/repayment_plan/index";
    }
    @RequestMapping(value = "/repaymentPlan/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(VREPAYMENT_PLAN_QUERY_MODEL_NAME) VRepaymentPlanQueryObject vRepaymentPlanQueryObject,
            Model model) {
        if(null == vRepaymentPlanQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id", OrderType.desc);
            vRepaymentPlanQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(vRepaymentPlanQueryObject);
        queryInfo.setPageNum(pageNum);
        Page<VRepaymentPlan> vrepayment_planPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(VREPAYMENT_PLAN_PAGE_MODEL_NAME, vrepayment_planPage);
        model.addAttribute(VREPAYMENT_PLAN_QUERY_MODEL_NAME, vRepaymentPlanQueryObject);
        return "products/repayment_plan/indexList";
    }
    @RequestMapping(value = "/repayment_plan/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(REPAYMENT_PLAN_MODEL_NAME) @Valid Repayment_plan repayment_plan,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(REPAYMENT_PLAN_MODEL_NAME, repayment_plan);
            return gotoAdd(model);
        }
        repayment_planService.doSave(repayment_plan);
        return "products/repayment_plan/success";
    }

    @RequestMapping(value = "/repayment_plan/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(REPAYMENT_PLAN_MODEL_NAME)) {
            Repayment_plan repayment_plan = repayment_planService.queryByID(id);
            model.addAttribute(REPAYMENT_PLAN_MODEL_NAME, repayment_plan);
        }
        return "products/repayment_plan/update";
    }

    @RequestMapping(value = "/repayment_plan/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(REPAYMENT_PLAN_MODEL_NAME) @Valid Repayment_plan repayment_plan,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(REPAYMENT_PLAN_MODEL_NAME, repayment_plan);
            return gotoUpdate(repayment_plan.getRepayment_plan_id(), model);
        }
        repayment_planService.doUpdate(repayment_plan);
        return "products/repayment_plan/success";
    }

    @RequestMapping(value = "/repayment_plan/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "products/repayment_plan/delete";
    }

    @RequestMapping(value = "/repayment_plan/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        repayment_planService.doUpdate(id);
        return "products/repayment_plan/success";
    }
    @RequestMapping(value = "/repayment_plan/download")
    public String download(@ModelAttribute(VREPAYMENT_PLAN_QUERY_MODEL_NAME) VRepaymentPlanQueryObject vRepaymentPlanQueryObject,HttpServletRequest request,HttpServletResponse response) throws IOException {
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String date = date1.format(new Date());
        String fileName="收益计划统计列表"+ date;
        //填充VRepaymentPlan数据
        List<VRepaymentPlan> vRepaymentPlans = createData(vRepaymentPlanQueryObject);
        List<Map<String,Object>> list= createExcelRecord(vRepaymentPlans);
        String columnNames[]={"标的名称","标的总额(元)","年化收益%","借款期限","标的种类","投资人","投资金额(元)","应付收益时间","应付收益金额(元)","银行名称","开户行支行","卡号"};//列名
        String keys[]   =    {"productName","totalMoney","yearRate","overTerm","type","userName","investMoney","repaymentTime","money","bankName","bankBranch","cardNo"};//map中的key
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
    private List<VRepaymentPlan> createData(VRepaymentPlanQueryObject vRepaymentPlanQueryObject) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(vRepaymentPlanQueryObject);
        List<VRepaymentPlan> list = pageService.queryDefaultListSize(queryInfo);
        return list;
    }
    private List<Map<String, Object>> createExcelRecord(List<VRepaymentPlan> vRepaymentPlans) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        VRepaymentPlan vRepaymentPlan = null;
        for (int j = 0; j < vRepaymentPlans.size(); j++) {
            vRepaymentPlan = vRepaymentPlans.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
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
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(format, true);
        binder.registerCustomEditor(Date.class,
               dateEditor);
    }
}