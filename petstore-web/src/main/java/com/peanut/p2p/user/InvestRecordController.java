package com.peanut.p2p.user;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.editor.DateEditor;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.user.model.entity.InvestRecord;
import com.peanut.p2p.user.model.entity.VInvestRecord;
import com.peanut.p2p.user.model.query.InvestRecordQueryObject;
import com.peanut.p2p.user.model.query.VInvestRecordQueryObject;
import com.peanut.p2p.user.service.InvestRecordService;
import com.peanut.p2p.util.ExcelUtil;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by my on 2015/2/5.
 */
@Controller
public class InvestRecordController {

    @Resource
    private InvestRecordService investRecordService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String INVEST_RECORD_QUERY_MODEL_NAME = "investRecordQueryObject";

    private static final String INVEST_RECORD_PAGE_MODEL_NAME = "investRecordPage";

    private static final String INVEST_RECORD_MODEL_NAME = "investRecordModel";

    private static final String VINVEST_RECORD_QUERY_MODEL_NAME = "vInvestRecordQueryObject";

    private static final String VINVEST_RECORD_PAGE_MODEL_NAME = "vInvestRecordPage";
    @RequestMapping(value = "/user/investrecord/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(INVEST_RECORD_MODEL_NAME)) {
            model.addAttribute(INVEST_RECORD_MODEL_NAME, new InvestRecord());
        }
        return "user/investrecord/add";
    }

    @RequestMapping(value = "/user/investrecord/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(INVEST_RECORD_QUERY_MODEL_NAME) InvestRecordQueryObject investRecordQueryObject,
            Model model) {
        if(null == investRecordQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id", OrderType.desc);
            investRecordQueryObject.setOrders(ss);
        }
        investRecordQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(investRecordQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<InvestRecord> investRecordPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(INVEST_RECORD_PAGE_MODEL_NAME, investRecordPage);
        model.addAttribute(INVEST_RECORD_QUERY_MODEL_NAME, investRecordQueryObject);
        return "user/investrecord/index";
    }
    @RequestMapping(value = "/user/investrecord/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(VINVEST_RECORD_QUERY_MODEL_NAME) VInvestRecordQueryObject investRecordQueryObject,
            Model model) {
        if(null == investRecordQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id", OrderType.desc);
            investRecordQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(investRecordQueryObject);
        queryInfo.setPageNum(pageNum);
        Page<VInvestRecord> investRecordPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(VINVEST_RECORD_PAGE_MODEL_NAME, investRecordPage);
        model.addAttribute(VINVEST_RECORD_QUERY_MODEL_NAME, investRecordQueryObject);
        return "user/investrecord/indexlist";
    }
    @RequestMapping(value = "/user/investrecord/{id}/info",method = RequestMethod.GET)
    public String gotoInfo(Model model,@PathVariable Integer id){
        InvestRecord investRecord = investRecordService.queryByID(id);
        model.addAttribute(INVEST_RECORD_MODEL_NAME,investRecord);
        return "user/investrecord/info";
    }
    @RequestMapping(value = "/user/investrecord/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(INVEST_RECORD_MODEL_NAME) @Valid InvestRecord investRecord,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(INVEST_RECORD_MODEL_NAME, investRecord);
            return gotoAdd(model);
        }
        investRecordService.doSave(investRecord);
        return "user/investrecord/success";
    }

    @RequestMapping(value = "/user/investrecord/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(INVEST_RECORD_MODEL_NAME)) {
            InvestRecord investRecord = investRecordService.queryByID(id);
            model.addAttribute(INVEST_RECORD_MODEL_NAME, investRecord);
        }
        return "user/investrecord/update";
    }

    @RequestMapping(value = "/user/investrecord/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(INVEST_RECORD_MODEL_NAME) @Valid InvestRecord investRecord,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(INVEST_RECORD_MODEL_NAME, investRecord);
            return gotoUpdate(investRecord.getId(), model);
        }
        investRecordService.doUpdate(investRecord);
        return "user/investrecord/success";
    }

    @RequestMapping(value = "/user/investrecord/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "user/investrecord/delete";
    }

    @RequestMapping(value = "/user/investrecord/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        investRecordService.doUpdate(id);
        return "user/investrecord/success";
    }
    @RequestMapping(value = "/download")
    public String download(@ModelAttribute(VINVEST_RECORD_QUERY_MODEL_NAME) VInvestRecordQueryObject vInvestRecordQueryObject,HttpServletRequest request,HttpServletResponse response) throws IOException {
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String date = date1.format(new Date());
        String fileName="投资统计列表"+ date;
        //填充VInvestRecord数据
        List<VInvestRecord> investRecords = createData(vInvestRecordQueryObject);
        List<Map<String,Object>> list= createExcelRecord(investRecords);
        String columnNames[]={"ID","标的名称","投资总次数","投资人次数","投资总收益(元)","投资总金额(元)"};//列名
        String keys[]   =    {"id","productName","tztimes","tzperson","income","investMoney"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        ExcelUtil.setRespo(is,response,fileName);
        return null;
    }

    private List<VInvestRecord> createData(VInvestRecordQueryObject vInvestRecordQueryObject) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(vInvestRecordQueryObject);
        List<VInvestRecord> list = pageService.queryDefaultListSize(queryInfo);
        return list;
    }

    private List<Map<String, Object>> createExcelRecord(List<VInvestRecord> investRecords) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        VInvestRecord investRecord = null;
        for (int j = 0; j < investRecords.size(); j++) {
            investRecord = investRecords.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("id", investRecord.getId());
            mapValue.put("productName", investRecord.getProductName());
            mapValue.put("tztimes", investRecord.getTztimes());
            mapValue.put("tzperson", investRecord.getTzperson());
            mapValue.put("income", investRecord.getIncome());
            mapValue.put("investMoney", investRecord.getInvestMoney());
            listmap.add(mapValue);
        }
        return listmap;
    }
    @InitBinder
   public void initBinder(WebDataBinder binder){
       binder.registerCustomEditor(Timestamp.class,new DateEditor("yyyy-MM-dd HH:mm:ss"));
   }
}

