package com.peanut.p2p.user;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.user.model.entity.UserInfo;
import com.peanut.p2p.user.model.entity.UserPrivilege;
import com.peanut.p2p.user.model.query.UserPrivilegeQueryObject;
import com.peanut.p2p.user.service.UserInfoService;
import com.peanut.p2p.user.service.UserPrivilegeService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
@Controller
public class UserPrivilegeController {
    @Resource
    private UserPrivilegeService userPrivilegeService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @Resource
    private UserInfoService userInfoService;

    private static final String USER_PRIVILEGE_QUERY_MODEL_NAME = "userPrivilegeQueryObject";

    private static final String USER_PRIVILEGE_PAGE_MODEL_NAME = "userPrivilegePage";

    private static final String USER_PRIVILEGE_MODEL_NAME = "userPrivilegeModel";

    private static final String USER_INFO_MODEL_NAME = "userInfoModel";

//    @ModelAttribute(USER_INFO_MODEL_NAME)
//    public UserInfo getUserNameByID(@RequestParam Integer userId) {
//        return userInfoService.queryByID(userId);
//    }

    @RequestMapping(value = "/user/userprivilege/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_PRIVILEGE_MODEL_NAME)) {
            model.addAttribute(USER_PRIVILEGE_MODEL_NAME, new UserPrivilege());
        }
        return "user/userprivilege/add";
    }
    @RequestMapping(value = "/user/userprivilege/{id}/info",method = RequestMethod.GET)
    public String gotoInfo(Model model,@PathVariable Integer id){
        UserPrivilege userPrivilege = userPrivilegeService.queryByID(id);
        UserInfo userInfo = userInfoService.queryByID(Integer.valueOf(userPrivilege.getUserId()));
        model.addAttribute(USER_PRIVILEGE_MODEL_NAME,userPrivilege);
        model.addAttribute(USER_INFO_MODEL_NAME,userInfo);
        return "user/userprivilege/info";
    }
    @RequestMapping(value = "/user/userprivilege/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_PRIVILEGE_QUERY_MODEL_NAME) UserPrivilegeQueryObject userPrivilegeQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userPrivilegeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<UserPrivilege> userPrivilegePage = pageService.queryDefaultPageSizePage(queryInfo);
        Page<UserInfo> userInfoPage = pageService.queryDefaultPageSizePage(queryInfo);

        model.addAttribute(USER_PRIVILEGE_PAGE_MODEL_NAME, userPrivilegePage);
        model.addAttribute(USER_PRIVILEGE_PAGE_MODEL_NAME,userInfoPage);
        model.addAttribute(USER_PRIVILEGE_QUERY_MODEL_NAME, userPrivilegeQueryObject);
        return "user/userprivilege/index";
    }

    @RequestMapping(value = "/user/userprivilege/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(USER_PRIVILEGE_MODEL_NAME) @Valid UserPrivilege userPrivilege,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(USER_PRIVILEGE_MODEL_NAME, userPrivilege);
            return gotoAdd(model);
        }
        userPrivilegeService.doSave(userPrivilege);
        return "user/userprivilege/success";
    }

    @RequestMapping(value = "/user/userprivilege/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(USER_PRIVILEGE_MODEL_NAME)) {
            UserPrivilege userPrivilege = userPrivilegeService.queryByID(id);
            model.addAttribute(USER_PRIVILEGE_MODEL_NAME, userPrivilege);
        }
        return "user/userprivilege/update";
    }

    @RequestMapping(value = "/user/userprivilege/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_PRIVILEGE_MODEL_NAME) @Valid UserPrivilege userPrivilege,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(USER_PRIVILEGE_MODEL_NAME, userPrivilege);
            return gotoUpdate(userPrivilege.getId(), model);
        }
        userPrivilegeService.doUpdate(userPrivilege);
        return "user/userprivilege/success";
    }

    @RequestMapping(value = "/user/userprivilege/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "user/userprivilege/delete";
    }

    @RequestMapping(value = "/user/userprivilege/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        userPrivilegeService.doDelete(id);
        return "user/userprivilege/success";
    }
}

