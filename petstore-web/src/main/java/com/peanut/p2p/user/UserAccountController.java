package com.peanut.p2p.user;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.user.model.entity.UserAccount;
import com.peanut.p2p.user.model.query.UserAccountQueryObject;
import com.peanut.p2p.user.service.UserAccountService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by my on 2015/2/5.
 */
@Controller
public class UserAccountController {
    @Resource
    private UserAccountService userAccountService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String USER_ACCOUNT_QUERY_MODEL_NAME = "userAccountQueryObject";

    private static final String USER_ACCOUNT_PAGE_MODEL_NAME = "userAccountPage";

    private static final String USER_ACCOUNT_MODEL_NAME = "userAccountModel";

    @RequestMapping(value = "/user/useraccount/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_ACCOUNT_MODEL_NAME)) {
            model.addAttribute(USER_ACCOUNT_MODEL_NAME, new UserAccount());
        }
        return "user/useraccount/add";
    }
    @RequestMapping(value = "/user/useraccount/{id}/info",method = RequestMethod.GET)
    public String gotoInfo(Model model,@PathVariable Integer id){
        UserAccount userAccount = userAccountService.queryByID(id);
        model.addAttribute(USER_ACCOUNT_MODEL_NAME,userAccount);
        return "user/useraccount/info";
    }
    @RequestMapping(value = "/user/useraccount/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_ACCOUNT_QUERY_MODEL_NAME) UserAccountQueryObject userAccountQueryObject,
            Model model) {
        if(null != userAccountQueryObject.getCreateT()&& !userAccountQueryObject.getCreateT().equals("")){
            String[] createT = userAccountQueryObject.getCreateT();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            try {
          //      userAccountQueryObject.setCreateTimes(sdf.parse(createT));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userAccountQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<UserAccount> userAccountPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(USER_ACCOUNT_PAGE_MODEL_NAME, userAccountPage);
        model.addAttribute(USER_ACCOUNT_QUERY_MODEL_NAME, userAccountQueryObject);
        return "user/useraccount/index";
    }

    @RequestMapping(value = "/user/useraccount/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(USER_ACCOUNT_MODEL_NAME) @Valid UserAccount userAccount,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(USER_ACCOUNT_MODEL_NAME, userAccount);
            return gotoAdd(model);
        }
        userAccountService.doSave(userAccount);
        return "user/useraccount/success";
    }

    @RequestMapping(value = "/user/useraccount/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(USER_ACCOUNT_MODEL_NAME)) {
            UserAccount userAccount = userAccountService.queryByID(id);
            model.addAttribute(USER_ACCOUNT_MODEL_NAME, userAccount);
        }
        return "user/useraccount/update";
    }

    @RequestMapping(value = "/user/useraccount/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_ACCOUNT_MODEL_NAME) @Valid UserAccount userAccount,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(USER_ACCOUNT_MODEL_NAME, userAccount);
            return gotoUpdate(userAccount.getId(), model);
        }
        userAccountService.doUpdate(userAccount);
        return "user/useraccount/success";
    }

    @RequestMapping(value = "/user/useraccount/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "user/useraccount/delete";
    }

    @RequestMapping(value = "/user/useraccount/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        userAccountService.doDelete(id);
        return "user/useraccount/success";
    }
}

