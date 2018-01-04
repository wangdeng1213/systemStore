package com.peanut.p2p.user;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.user.model.entity.UserInfo;
import com.peanut.p2p.user.model.query.UserInfoQueryObject;
import com.peanut.p2p.user.service.InternetUserService;
import com.peanut.p2p.user.service.UserInfoService;
import com.peanut.p2p.util.ExcelExport;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created by my on 2015/2/5.
 */
@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userinfoService;
    @Resource
    private InternetUserService internetUserService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String USER_INFO_QUERY_MODEL_NAME = "userInfoQueryObject";

    private static final String USER_INFO_PAGE_MODEL_NAME = "userInfoPage";

    private static final String USER_INFO_MODEL_NAME = "userInfoModel";

    private static final String VUSER_INFO_QUERY_MODEL_NAME = "vUserInfoQueryObject";

    private static final String VUSER_INFO_PAGE_MODEL_NAME = "vUserInfoPage";

    @RequestMapping(value = "/user/userinfo/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_INFO_MODEL_NAME)) {
            model.addAttribute(USER_INFO_MODEL_NAME, new UserInfo());
        }
        return "user/userinfo/add";
    }
    @RequestMapping(value = "/user/userinfo/{id}/info",method = RequestMethod.GET)
    public String gotoInfo(Model model,@PathVariable Integer id){
        UserInfo userInfo = userinfoService.queryByID(id);
        model.addAttribute(USER_INFO_MODEL_NAME,userInfo);
        return "user/userinfo/info";
    }
    @RequestMapping(value = "/user/userinfo/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_INFO_QUERY_MODEL_NAME) UserInfoQueryObject userInfoQueryObject,
            Model model) {
        if(null == userInfoQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            userInfoQueryObject.setOrders(ss);
        }
        userInfoQueryObject.setActStatus(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userInfoQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<UserInfo> userInfoPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(USER_INFO_PAGE_MODEL_NAME, userInfoPage);
        model.addAttribute(USER_INFO_QUERY_MODEL_NAME, userInfoQueryObject);
        return "user/userinfo/index";
    }
    @RequestMapping(value = "/user/userinfo/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(VUSER_INFO_QUERY_MODEL_NAME) UserInfoQueryObject userInfoQueryObject,
            Model model) {

       // model.addAttribute(VUSER_INFO_PAGE_MODEL_NAME, userInfoPage);
       // model.addAttribute(VUSER_INFO_QUERY_MODEL_NAME, userInfoQueryObject);
        return "user/userinfo/indexList";
    }

    @RequestMapping(value = "/user/userinfo/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(USER_INFO_MODEL_NAME) @Valid UserInfo userInfo,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(USER_INFO_MODEL_NAME, userInfo);
            return gotoAdd(model);
        }
        userinfoService.doSave(userInfo);
        return "user/userinfo/success";
    }

    @RequestMapping(value = "/user/userinfo/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(USER_INFO_MODEL_NAME)) {
            UserInfo userInfo = userinfoService.queryByID(id);
            model.addAttribute(USER_INFO_MODEL_NAME, userInfo);
        }
        return "user/userinfo/update";
    }

    @RequestMapping(value = "/user/userinfo/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_INFO_MODEL_NAME) @Valid  UserInfo userInfo,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(USER_INFO_MODEL_NAME, userInfo);
            return gotoUpdate(userInfo.getId(), model);
        }
        internetUserService.doUpdate(userInfo);
        return "user/userinfo/success";
    }

    @RequestMapping(value = "/user/userinfo/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "user/userinfo/delete";
    }
    /*禁用*/
    @RequestMapping(value = "/user/userinfo/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        userinfoService.doUpdate(id);
        return "user/userinfo/success";
    }
    @RequestMapping(value = "/user/import",method = RequestMethod.GET)
    public String  gotoImport(){
       return "/user/userinfo/import";
    }
    @RequestMapping(value = "/user/import",method = RequestMethod.POST)
    public void doImport(@RequestParam("file") CommonsMultipartFile file){
        InputStream is = null;
        List list = null;
        String path = file.getOriginalFilename();
        try {
             is = file.getInputStream();
            list =  ExcelExport.exportListFromExcel(is,path,0);
            System.out.println(list+"=====");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

