package com.peanut.p2p.user;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.editor.DateEditor;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.user.model.entity.InternetUser;
import com.peanut.p2p.user.model.query.InternetUserQueryObject;
import com.peanut.p2p.user.service.InternetUserService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by my on 2015/6/12.
 */
@Controller
public class InternetUserController {
    @Resource
    private QueryInfoBuilder queryInfoBuilder;
    @Resource
    private PageService pageService;
    @Resource
    private InternetUserService internetUserService;

    private static final String INTERNET_USER_PAGE_MODEL_NAME = "internetUserPage";

    private static final String INTERNET_USER_QUERY_MODEL_NAME = "internetUserQueryObject";

    @RequestMapping(value = "/user/internetUser/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(INTERNET_USER_QUERY_MODEL_NAME) InternetUserQueryObject internetUserQueryObject,
            Model model) {
        if(null == internetUserQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            internetUserQueryObject.setOrders(ss);
        }
        internetUserQueryObject.setActStatus(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(internetUserQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<InternetUser> internetUserPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(INTERNET_USER_PAGE_MODEL_NAME, internetUserPage);
        model.addAttribute(INTERNET_USER_QUERY_MODEL_NAME, internetUserQueryObject);
        return "user/internetUser/index";
    }

    @RequestMapping(value = "/user/internetUser/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        internetUserService.doUpdate(id);
        return "user/internetUser/success";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
      binder.registerCustomEditor(Date.class, new DateEditor("yyyy-MM-dd"));
    }

}
