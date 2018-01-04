package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.AccountCash;
import com.peanut.p2p.products.model.query.AccountCashQueryObject;
import com.peanut.p2p.products.service.AccountCashService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author my
 * @version 1.0
 */
@Controller
public class AccountCashController {
    @Resource
    private AccountCashService accountCashService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String ACCOUNT_CASH_QUERY_MODEL_NAME = "accountCashQueryObject";

    private static final String ACCOUNT_CASH_PAGE_MODEL_NAME = "accountCashPage";

    private static final String ACCOUNT_CASH_MODEL_NAME = "accountCashModel";


    @RequestMapping(value = "/accountCash/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ACCOUNT_CASH_QUERY_MODEL_NAME) AccountCashQueryObject accountCashQueryObject,
            Model model) {
        if(null == accountCashQueryObject){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            accountCashQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(accountCashQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<AccountCash> accountCashPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(ACCOUNT_CASH_PAGE_MODEL_NAME, accountCashPage);
        model.addAttribute(ACCOUNT_CASH_QUERY_MODEL_NAME, accountCashQueryObject);
        return "products/accountCash/index";
    }

 /*   @RequestMapping(value = "/accountCash/add", method = RequestMethod.POST)
    protected String add(Model model,
                         @ModelAttribute(ACCOUNT_CASH_MODEL_NAME) @Valid AccountCash accountCash,
                         BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(ACCOUNT_CASH_MODEL_NAME, accountCash);
            return gotoAdd(model);
        }
        accountCashService.doSave(accountCash);
        return "products/accountCash/success";
    }*/

 /*   @RequestMapping(value = "/accountCash/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(ACCOUNT_CASH_MODEL_NAME)) {
            AccountCash accountCash = accountCashService.queryByPID(String.valueOf(id));
            model.addAttribute(ACCOUNT_CASH_MODEL_NAME, accountCash);
        }
        return "products/accountCash/update";
    }

    @RequestMapping(value = "/accountCash/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(ACCOUNT_CASH_MODEL_NAME) @Valid AccountCash accountCash,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ACCOUNT_CASH_MODEL_NAME, accountCash);
            return gotoUpdate(accountCash.getStock_id(), model);
        }
        accountCashService.doUpdate(accountCash);
        return "products/accountCash/success";
    }
*/
  /*  @RequestMapping(value = "/accountCash/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "accountCash/delete";
    }

    @RequestMapping(value = "/accountCash/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        accountCashService.doDelete(id);
        return "products/accountCash/success";
    }*/
}