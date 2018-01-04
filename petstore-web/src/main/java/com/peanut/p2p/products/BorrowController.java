package com.peanut.p2p.products;

import com.google.common.collect.Maps;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Pic;
import com.peanut.p2p.code.service.AgentService;
import com.peanut.p2p.code.service.PicService;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.BorrowTran;
import com.peanut.p2p.products.model.entity.Riskinfo;
import com.peanut.p2p.products.model.entity.Shcl;
import com.peanut.p2p.products.model.query.BorrowTranQueryObject;
import com.peanut.p2p.products.service.BorrowTranService;
import com.peanut.p2p.products.service.RiskinfoService;
import com.peanut.p2p.products.service.ShclService;
import com.peanut.p2p.user.model.entity.UserInfo;
import com.peanut.p2p.user.service.UserInfoService;
import com.peanut.pagination.page.Page;
import com.peanut.security.realm.entity.user.User;
import com.peanut.security.springSecurity.utils.AuthUtils;
import com.peanut.workflow.domain.PageQuery;
import com.peanut.workflow.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by my on 2015/4/21.
 */
@Controller
public class BorrowController {
    private static Logger logger = LoggerFactory.getLogger(BorrowController.class);

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @Resource
    private BorrowTranService borrowTranService;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RiskinfoService riskinfoService;

    @Resource
    private TaskService peanutTaskService;

    @Resource
    private ShclService shclService;

    @Resource
    private PicService picService;

    @Autowired
    private TaskService taskService;
    @Resource
    private AgentService agentService;

    private static final String BORROWE_PAGE_MODEL_NAME = "borrowPage";

    private static final String BORROWE_QUERY_MODEL_NAME = "borrowQueryObject";

    private static final String BORROWE_MODEL_NAME = "borrowModel";

    private static final String USER_MODEL_NAME = "userInfoModel";

    private static final String RISKINFO_MODEL_NAME = "riskInfoModel";

    @RequestMapping(value = "/borrow/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BORROWE_QUERY_MODEL_NAME) BorrowTranQueryObject borrowTranQueryObject,
            Model model) {
        borrowTranQueryObject.setAct_status(1);
        borrowTranQueryObject.setDeal_status("0");
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(borrowTranQueryObject);
        queryInfo.setPageNum(pageNum);
        Page<BorrowTran> borrowOrderInfoPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(BORROWE_PAGE_MODEL_NAME, borrowOrderInfoPage);
        model.addAttribute(BORROWE_QUERY_MODEL_NAME, borrowTranQueryObject);
        return "products/borrow/index";
    }

    @RequestMapping(value = "/borrow/approvalList", method = RequestMethod.GET)
    public String approvalList(
            @RequestParam(defaultValue = "1") int pageNum,
            Model model) {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNum(pageNum);
        pageQuery.setPageSize(10);

        User user = AuthUtils.getCurrentUser();
        if(null == user || user.equals("")){
            return "errors/error";
        }
        Page<BorrowTran> page = peanutTaskService.findTodoTasks(BorrowTran.class, String.valueOf(user.getId()), pageQuery);

        model.addAttribute(BORROWE_QUERY_MODEL_NAME, pageQuery);
        model.addAttribute(BORROWE_PAGE_MODEL_NAME, page);
        return "products/borrow/index";
    }

    @RequestMapping(value = "/borrow/{id}/info", method = RequestMethod.GET)
    public String gotoInfo(Model model, @PathVariable Long id) {
        //查询出借款人信息
        BorrowTran borrowTran = borrowTranService.queryByID(id);
        if (null != borrowTran && !("").equals(borrowTran)) {
            model.addAttribute(BORROWE_MODEL_NAME, borrowTran);
        }
        Integer userId = borrowTran.getUser_id();
        if (null != userId && !("").equals(userId)) {
            //查询出借款人的基本信息
            UserInfo userInfo = userInfoService.queryByID(userId);
            model.addAttribute(USER_MODEL_NAME, userInfo);
        }
        Long riskInfoId = borrowTran.getRiskinfoid();
        if(null!= riskInfoId && !riskInfoId.equals("")){
            //查询风控信息
            Riskinfo riskinfo = riskinfoService.queryByID(riskInfoId);
            if (null == riskinfo || riskinfo.equals("")) {
                return "errors/error";
            }
            model.addAttribute(RISKINFO_MODEL_NAME, riskinfo);
                String sfrz = riskinfo.getSfrz();
            if(null != sfrz && !sfrz.equals("")){
                Shcl shcl1 =  shclService.queryByID(Long.valueOf(sfrz));
                model.addAttribute("shcl1", shcl1);
            }
                String gzrz = riskinfo.getGzrz();
            if(null != gzrz && !gzrz.equals("")){
                Shcl shcl2 =  shclService.queryByID(Long.valueOf(gzrz));
                model.addAttribute("shcl2", shcl2);
            }
                String xyrz = riskinfo.getXyrz();
            if(null != xyrz && !xyrz.equals("")){
                Shcl shcl3 =  shclService.queryByID(Long.valueOf(xyrz));
                model.addAttribute("shcl3", shcl3);
            }
                String srrz = riskinfo.getSrrz();
            if(null != srrz && !srrz.equals("")){
                Shcl shcl4 =  shclService.queryByID(Long.valueOf(srrz));
                model.addAttribute("shcl4", shcl4);
            }
                String fcrz = riskinfo.getFcrz();
            if(null != fcrz && !fcrz.equals("")){
                Shcl shcl5 =  shclService.queryByID(Long.valueOf(fcrz));
                model.addAttribute("shcl5", shcl5);
            }
                String gcrz = riskinfo.getGcrz();
            if(null != gcrz && !gcrz.equals("")){
                Shcl shcl6 =  shclService.queryByID(Long.valueOf(gcrz));
                model.addAttribute("shcl6", shcl6);
            }
                String jhrz = riskinfo.getJhrz();
            if(null != jhrz && !jhrz.equals("")){
                Shcl shcl7 =  shclService.queryByID(Long.valueOf(jhrz));
                model.addAttribute("shcl7", shcl7);
            }
                String xlrz = riskinfo.getXlrz();
            if(null != xlrz && !xlrz.equals("")){
                Shcl shcl8 =  shclService.queryByID(Long.valueOf(xlrz));
                model.addAttribute("shcl8", shcl8);
            }
                String zcrz = riskinfo.getZcrz();
            if(null != zcrz && !zcrz.equals("")){
                Shcl shcl9 =  shclService.queryByID(Long.valueOf(zcrz));
                model.addAttribute("shcl9", shcl9);
            }
                String sjrz = riskinfo.getSjrz();
            if(null != sjrz && !sjrz.equals("")){
                Shcl shcl10 =  shclService.queryByID(Long.valueOf(sjrz));
                model.addAttribute("shcl10", shcl10);
            }
            String jzrz = riskinfo.getJzrz();
                if(jzrz!= null && !jzrz.equals("")){
                  Shcl shcl11 =  shclService.queryByID(Long.valueOf(jzrz));
                    model.addAttribute("shcl11", shcl11);
                }
        }
        return "products/borrow/info";
    }
    /*审批*/
    @RequestMapping(value = "/borrow/{id}/approval", method = RequestMethod.GET)
    public String gotoApproval(@PathVariable Long id, Model model) {
        if (!model.containsAttribute(BORROWE_MODEL_NAME)) {
            //查询借款交易表信息
            BorrowTran borrowTran = borrowTranService.queryByID(id);
            if (null == borrowTran || borrowTran.equals("")) {
                return "errors/error";
            }
            model.addAttribute(BORROWE_MODEL_NAME, borrowTran);
            //查询用户基本信息
            UserInfo userInfo = userInfoService.queryByID(borrowTran.getUser_id());
            if (null == userInfo || userInfo.equals("")) {
                return "errors/error";
            }
            model.addAttribute(USER_MODEL_NAME, userInfo);
            Long riskInfoId = borrowTran.getRiskinfoid();
            if(null!= riskInfoId && !riskInfoId.equals("")){
                //查询风控信息
                Riskinfo riskinfo = riskinfoService.queryByID(riskInfoId);
                if (null == riskinfo || riskinfo.equals("")) {
                    return "errors/error";
                }
                model.addAttribute(RISKINFO_MODEL_NAME, riskinfo);
                String sfrz = riskinfo.getSfrz();
                if(null != sfrz && !sfrz.equals("")){
                    //根据审核ID查询shcl
                    Shcl shcl1 =  shclService.queryByID(Long.valueOf(sfrz));
                    if(null == shcl1 || ("").equals(shcl1)){
                        shcl1.setShzt("5");
                        shcl1.setShyj("未审核");
                    }
                    model.addAttribute("shcl1", shcl1);
                }
                String gzrz = riskinfo.getGzrz();
                if(null != gzrz && !gzrz.equals("")){
                    Shcl shcl2 =  shclService.queryByID(Long.valueOf(gzrz));
                    if(null == shcl2 || ("").equals(shcl2)){
                        shcl2.setShzt("5");
                        shcl2.setShyj("未审核");
                    }
                    model.addAttribute("shcl2", shcl2);
                }
                String xyrz = riskinfo.getXyrz();
                if(null != xyrz && !xyrz.equals("")){
                    Shcl shcl3 =  shclService.queryByID(Long.valueOf(xyrz));
                    if(null == shcl3 || ("").equals(shcl3)){
                        shcl3.setShzt("5");
                        shcl3.setShyj("未审核");
                    }
                    model.addAttribute("shcl3", shcl3);
                }
                String srrz = riskinfo.getSrrz();
                if(null != srrz && !srrz.equals("")){
                    Shcl shcl4 =  shclService.queryByID(Long.valueOf(srrz));
                    if(null == shcl4 || ("").equals(shcl4)){
                        shcl4.setShzt("5");
                        shcl4.setShyj("未审核");
                    }
                    model.addAttribute("shcl4", shcl4);
                }
                String fcrz = riskinfo.getFcrz();
                if(null != fcrz && !fcrz.equals("")){
                    Shcl shcl5 =  shclService.queryByID(Long.valueOf(fcrz));
                    if(null == shcl5 || ("").equals(shcl5)){
                        shcl5.setShzt("5");
                        shcl5.setShyj("未审核");
                    }
                    model.addAttribute("shcl5", shcl5);
                }
                String gcrz = riskinfo.getGcrz();
                if(null != gcrz && !gcrz.equals("")){
                    Shcl shcl6 =  shclService.queryByID(Long.valueOf(gcrz));
                    if(null == shcl6 || ("").equals(shcl6)){
                        shcl6.setShzt("5");
                        shcl6.setShyj("未审核");
                    }
                    model.addAttribute("shcl6", shcl6);
                }
                String jhrz = riskinfo.getJhrz();
                if(null != jhrz && !jhrz.equals("")){
                    Shcl shcl7 =  shclService.queryByID(Long.valueOf(jhrz));
                    if(null == shcl7 || ("").equals(shcl7)){
                        shcl7.setShzt("5");
                        shcl7.setShyj("未审核");
                    }
                    model.addAttribute("shcl7", shcl7);
                }
                String xlrz = riskinfo.getXlrz();
                if(null != xlrz && !xlrz.equals("")){
                    Shcl shcl8 =  shclService.queryByID(Long.valueOf(xlrz));
                    if(null == shcl8 || ("").equals(shcl8)){
                        shcl8.setShzt("5");
                        shcl8.setShyj("未审核");
                    }
                    model.addAttribute("shcl8", shcl8);
                }
                String zcrz = riskinfo.getZcrz();
                if(null != zcrz && !zcrz.equals("")){
                    Shcl shcl9 =  shclService.queryByID(Long.valueOf(zcrz));
                    if(null == shcl9 || ("").equals(shcl9)){
                        shcl9.setShzt("5");
                        shcl9.setShyj("未审核");
                    }
                    model.addAttribute("shcl9", shcl9);
                }
                String sjrz = riskinfo.getSjrz();
                if(null != sjrz && !sjrz.equals("")){
                    Shcl shcl10 =  shclService.queryByID(Long.valueOf(sjrz));
                    if(null == shcl10 || ("").equals(shcl10)){
                        shcl10.setShzt("5");
                        shcl10.setShyj("未审核");
                    }
                    model.addAttribute("shcl10", shcl10);
                }
                String jzrz = riskinfo.getJzrz();
                if(jzrz!= null && !jzrz.equals("")){
                    Shcl shcl11 =  shclService.queryByID(Long.valueOf(jzrz));
                    if(null == shcl11 || ("").equals(shcl11)){
                        shcl11.setShzt("5");
                        shcl11.setShyj("未审核");
                    }
                    model.addAttribute("shcl11", shcl11);
                }
            }
        }
        return "products/borrow/approval";
    }

    /*审核材料*/
    @RequestMapping(value = "/borrow/approvalSh", method = RequestMethod.POST)
    public void gotoApprovalSh(@RequestParam String picId, @RequestParam String shyj, @RequestParam String shzt,HttpServletRequest request, HttpServletResponse response) {
        String msg = "false";
        Shcl shcl = shclService.queryByID(Long.valueOf(picId));
        String shy = shcl.getShyj();
        if(null !=shy && !("").equals(shy)){
            shcl.setShyj(shy+";"+shyj);
        }else{
            shcl.setShyj(shyj);
        }
        shcl.setShzt(shzt);
        User user = AuthUtils.getCurrentUser();
        String userId = shcl.getVerify_user();
        if(null !=userId || !("").equals(userId)){
            shcl.setVerify_user(userId + ";" + user.getUserName());
        }
        shcl.setVerify_user(user.getUserName());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date rzrq = sd.parse(sd.format(new Date()));
            shcl.setRzrq(rzrq);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            shclService.doUpdate(shcl);
            msg = "true";
            request.setAttribute("msg",msg);
            response.getWriter().print(msg);
        } catch (IOException io) {
            System.out.print(io);
        }

    }
    @RequestMapping(value = "/borrow/{id}/approval", method = RequestMethod.POST)
    public String approval(@PathVariable Long id, Model model,@ModelAttribute(BORROWE_MODEL_NAME) BorrowTran borrowTran,
                           BindingResult result) {
        if (!model.containsAttribute(BORROWE_MODEL_NAME)) {
            model.addAttribute(BORROWE_MODEL_NAME, borrowTran);
        }
        BorrowTran borrowTran1 = borrowTranService.queryByID(id);

        //审批状态
        String deal_status = borrowTran.getDeal_status();
        if(deal_status!=null&&!deal_status.equals("")){
            // 设置审核状态
            borrowTran1.setDeal_status(deal_status);
        }
        //获得当前用户
        User user = AuthUtils.getCurrentUser();
        //设置审核时间
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        borrowTran1.setFk_time(Timestamp.valueOf(time));
        borrowTran1.setFk_user(user.getUserName());
        borrowTran1.setFk_opinion(borrowTran.getFk_opinion());
        borrowTranService.doUpdate(borrowTran1);

        return "products/borrow/success";
    }

  /*  @RequestMapping(value = "/borrow/{id}/approval", method = RequestMethod.POST)
    public String approval(@PathVariable("id")Long Id,@RequestParam String taskId,@RequestParam String type, @RequestParam Boolean applyResult, @RequestParam String opinion) {
        Map<String, Object> variables = Maps.newHashMap();
        variables.put(type, applyResult);
        variables.put("opinion", opinion);

        try {
            peanutTaskService.complete(taskId, variables);
            return "products/borrow/success";
        } catch (Exception e) {
            logger.error("approval task {} error, variables={}", new Object[]{taskId, variables, e});
            return "error";
        }
    }*/

    @RequestMapping(value = "approval/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String approval(@PathVariable("id") String taskId, Map<String, Object> variables) {
        try {
            peanutTaskService.complete(taskId, variables);
            return "products/borrow/success";
        } catch (Exception e) {
            logger.error("approval task {} error, variables={}", new Object[]{taskId, variables, e});
            return "error";
        }
    }

    @RequestMapping(value = "/borrow/{picId}/show", method = RequestMethod.GET)
    public void showImage(@PathVariable Integer picId,HttpServletResponse response) throws IOException{
        Pic pic =  picService.queryByID(picId);
        byte[]  data = pic.getContent();

        if (data != null) {
            // 输出
            response.setContentType("image/jpeg");
            OutputStream outs = response.getOutputStream();
            outs.write(data, 0, data.length);
            outs.flush();
        }

    }
}