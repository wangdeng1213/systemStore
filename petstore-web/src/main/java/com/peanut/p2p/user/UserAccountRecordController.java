package com.peanut.p2p.user;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;

import com.peanut.p2p.user.model.entity.UserAccountRecord;
import com.peanut.p2p.user.model.query.UserAccountRecordQueryObject;
import com.peanut.p2p.user.service.UserAccountRecordService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by my on 2015/2/5.
 */
@Controller
public class UserAccountRecordController {
    @Resource
    private UserAccountRecordService userAccountRecordService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String USER_ACCOUNT_RECODE_QUERY_MODEL_NAME = "userAccountRecordQueryObject";

    private static final String USER_ACCOUNT_RECODE_PAGE_MODEL_NAME = "userAccountRecordPage";

    private static final String USER_ACCOUNT_RECODE_MODEL_NAME = "userAccountRecordModel";

    @RequestMapping(value = "/user/useraccountrecord/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_ACCOUNT_RECODE_MODEL_NAME)) {
            model.addAttribute(USER_ACCOUNT_RECODE_MODEL_NAME, new UserAccountRecord());
        }
        return "user/useraccountrecord/add";
    }
    @RequestMapping(value = "/user/useraccountrecord/{id}/info",method = RequestMethod.GET)
    public String gotoInfo(Model model,@PathVariable Integer id){
        UserAccountRecord userAccountRecord = userAccountRecordService.queryByID(id);
        model.addAttribute(USER_ACCOUNT_RECODE_MODEL_NAME,userAccountRecord);
        return "user/useraccountrecord/info";
    }
    @RequestMapping(value = "/user/useraccountrecord/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_ACCOUNT_RECODE_QUERY_MODEL_NAME) UserAccountRecordQueryObject userAccountRecordQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userAccountRecordQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<UserAccountRecord> userAccountRecodePage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(USER_ACCOUNT_RECODE_PAGE_MODEL_NAME, userAccountRecodePage);
        model.addAttribute(USER_ACCOUNT_RECODE_QUERY_MODEL_NAME, userAccountRecordQueryObject);
        return "user/useraccountrecord/index";
    }

    @RequestMapping(value = "/user/useraccountrecord/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(USER_ACCOUNT_RECODE_MODEL_NAME) @Valid UserAccountRecord userAccountRecode,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(USER_ACCOUNT_RECODE_MODEL_NAME, userAccountRecode);
            return gotoAdd(model);
        }
        userAccountRecordService.doSave(userAccountRecode);
        return "user/useraccountrecord/success";
    }

    @RequestMapping(value = "/user/useraccountrecord/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(USER_ACCOUNT_RECODE_MODEL_NAME)) {
            UserAccountRecord userAccountRecode = userAccountRecordService.queryByID(id);
            model.addAttribute(USER_ACCOUNT_RECODE_MODEL_NAME, userAccountRecode);
        }
        return "user/useraccountrecord/update";
    }

    @RequestMapping(value = "/user/useraccountrecord/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_ACCOUNT_RECODE_MODEL_NAME) @Valid UserAccountRecord userAccountRecode,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(USER_ACCOUNT_RECODE_MODEL_NAME, userAccountRecode);
            return gotoUpdate(userAccountRecode.getId(), model);
        }
        userAccountRecordService.doUpdate(userAccountRecode);
        return "user/useraccountrecord/success";
    }

    @RequestMapping(value = "/user/useraccountrecord/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "user/useraccountrecord/delete";
    }

    @RequestMapping(value = "/user/useraccountrecord/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        userAccountRecordService.doDelete(id);
        return "user/useraccountrecord/success";
    }
}

