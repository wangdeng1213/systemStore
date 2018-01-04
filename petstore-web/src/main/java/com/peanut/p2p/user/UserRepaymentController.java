package com.peanut.p2p.user;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.Product;
import com.peanut.p2p.products.service.ProductService;
import com.peanut.p2p.user.model.entity.UserInfo;
import com.peanut.p2p.user.model.entity.UserRepayment;
import com.peanut.p2p.user.model.query.UserRepaymentQueryObject;
import com.peanut.p2p.user.service.UserInfoService;
import com.peanut.p2p.user.service.UserRepaymentService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by my on 2015/2/6.
 */
@Controller
public class UserRepaymentController {
    @Resource
    private UserRepaymentService userRepaymentService;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private ProductService productService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String USER_REPAYMENT_QUERY_MODEL_NAME = "userRepaymentQueryObject";

    private static final String USER_REPAYMENT_PAGE_MODEL_NAME = "userRepaymentPage";

    private static final String USER_REPAYMENT_MODEL_NAME = "userRepaymentModel";

    private static final String USER_INFO_MODEL_NAME = "userInfoModel";

    private static final String PRODUCT_MODEL_NAME = "productModel";

    @ModelAttribute(USER_INFO_MODEL_NAME)
    public List<UserInfo> queryUserName(){
       return userInfoService.queryUserName();
    }
    @RequestMapping(value = "/user/userrepayment/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(USER_REPAYMENT_MODEL_NAME)) {
            model.addAttribute(USER_REPAYMENT_MODEL_NAME, new UserRepayment());
        }
        return "user/userrepayment/add";
    }
    @RequestMapping(value = "/user/userrepayment/{id}/info",method = RequestMethod.GET)
    public String gotoInfo(Model model,@PathVariable Integer id){
        UserRepayment userRepayment = userRepaymentService.queryByID(id);
        UserInfo userInfo = userInfoService.queryByID(userRepayment.getUserId());
        Product product = productService.queryByID(Long.valueOf(userRepayment.getProductId()));
        model.addAttribute(USER_REPAYMENT_MODEL_NAME,userRepayment);
        model.addAttribute(USER_INFO_MODEL_NAME,userInfo);
        model.addAttribute(PRODUCT_MODEL_NAME,product);
        return "user/userrepayment/info";
    }
    @RequestMapping(value = "/user/userrepayment/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(USER_REPAYMENT_QUERY_MODEL_NAME) UserRepaymentQueryObject userRepaymentQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(userRepaymentQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<UserRepayment> userRepaymentPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(USER_REPAYMENT_PAGE_MODEL_NAME, userRepaymentPage);
        model.addAttribute(USER_REPAYMENT_QUERY_MODEL_NAME, userRepaymentQueryObject);
        return "user/userrepayment/index";
    }

    @RequestMapping(value = "/user/userrepayment/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(USER_REPAYMENT_MODEL_NAME) @Valid UserRepayment userRepayment,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(USER_REPAYMENT_MODEL_NAME, userRepayment);
            return gotoAdd(model);
        }
        userRepaymentService.doSave(userRepayment);
        return "user/userrepayment/success";
    }

    @RequestMapping(value = "/user/userrepayment/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(USER_REPAYMENT_MODEL_NAME)) {
            UserRepayment userRepayment = userRepaymentService.queryByID(id);
            model.addAttribute(USER_REPAYMENT_MODEL_NAME, userRepayment);
        }
        return "user/userrepayment/update";
    }

    @RequestMapping(value = "/user/userrepayment/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(USER_REPAYMENT_MODEL_NAME) @Valid  UserRepayment userRepayment,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(USER_REPAYMENT_MODEL_NAME, userRepayment);
            return gotoUpdate(userRepayment.getId(), model);
        }
        userRepaymentService.doUpdate(userRepayment);
        return "user/userrepayment/success";
    }

    @RequestMapping(value = "/user/userrepayment/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "user/userrepayment/delete";
    }

    @RequestMapping(value = "/user/userrepayment/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        userRepaymentService.doDelete(id);
        return "user/userrepayment/success";
    }
}
