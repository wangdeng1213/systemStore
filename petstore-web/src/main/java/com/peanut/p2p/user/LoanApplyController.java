package com.peanut.p2p.user;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.editor.DateEditor;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.user.model.entity.InternetUser;
import com.peanut.p2p.user.model.entity.LoanApply;
import com.peanut.p2p.user.model.query.InternetUserQueryObject;
import com.peanut.p2p.user.model.query.LoanApplyQueryObject;
import com.peanut.p2p.user.service.InternetUserService;
import com.peanut.p2p.user.service.LoanApplyService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by my on 2015/7/6.
 */
@Controller
public class LoanApplyController {
    @Resource
    private QueryInfoBuilder queryInfoBuilder;
    @Resource
    private PageService pageService;
    @Resource
    private LoanApplyService applyService;

    private static final String LOAN_APPLY_PAGE_MODEL_NAME = "loanApplyPage";

    private static final String LOAN_APPLY_QUERY_MODEL_NAME = "loanApplyQueryObject";

    @RequestMapping(value = "/user/loanApply/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(LOAN_APPLY_QUERY_MODEL_NAME) LoanApplyQueryObject applyQueryObject,
            Model model) {
        if(null == applyQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            applyQueryObject.setOrders(ss);
        }
        applyQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(applyQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<LoanApply> applyPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(LOAN_APPLY_PAGE_MODEL_NAME, applyPage);
        model.addAttribute(LOAN_APPLY_QUERY_MODEL_NAME, applyQueryObject);
        return "user/loanApply/index";
    }

    @RequestMapping(value = "/user/loanApply/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        applyService.doUpdate(id);
        return "user/loanApply/success";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new DateEditor("yyyy-MM-dd"));
    }

}
