package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.AccountRecharge;
import com.peanut.p2p.products.model.query.AccountRechargeQueryObject;
import com.peanut.p2p.products.service.AccountRechargeService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author my
 * @version 1.0
 */
@Controller
public class AccountRechargeController {
    @Resource
    private AccountRechargeService accountRechargeService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String ACCOUNT_RECHARGE_QUERY_MODEL_NAME = "accountRechargeQueryObject";

    private static final String ACCOUNT_RECHARGE_PAGE_MODEL_NAME = "accountRechargePage";

    private static final String ACCOUNT_RECHARGE_MODEL_NAME = "accountRechargeModel";

  /*  @RequestMapping(value = "/accountRecharge/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(ACCOUNT_RECHARGE_MODEL_NAME)) {
            model.addAttribute(ACCOUNT_RECHARGE_MODEL_NAME, new AccountRecharge());
        }
        return "products/accountRecharge/add";
    }*/

    @RequestMapping(value = "/accountRecharge/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ACCOUNT_RECHARGE_QUERY_MODEL_NAME) AccountRechargeQueryObject accountRechargeQueryObject,
            Model model) {
        if(null == accountRechargeQueryObject){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            accountRechargeQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(accountRechargeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<AccountRecharge> accountRechargePage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(ACCOUNT_RECHARGE_PAGE_MODEL_NAME, accountRechargePage);
        model.addAttribute(ACCOUNT_RECHARGE_QUERY_MODEL_NAME, accountRechargeQueryObject);
        return "products/accountRecharge/index";
    }

 /*   @RequestMapping(value = "/accountRecharge/add", method = RequestMethod.POST)
    protected String add(Model model,
                         @ModelAttribute(ACCOUNT_RECHARGE_MODEL_NAME) @Valid AccountRecharge accountRecharge,
                         BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(ACCOUNT_RECHARGE_MODEL_NAME, accountRecharge);
            return gotoAdd(model);
        }
        accountRechargeService.doSave(accountRecharge);
        return "products/accountRecharge/success";
    }*/

 /*   @RequestMapping(value = "/accountRecharge/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(ACCOUNT_RECHARGE_MODEL_NAME)) {
            AccountRecharge accountRecharge = accountRechargeService.queryByPID(String.valueOf(id));
            model.addAttribute(ACCOUNT_RECHARGE_MODEL_NAME, accountRecharge);
        }
        return "products/accountRecharge/update";
    }

    @RequestMapping(value = "/accountRecharge/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(ACCOUNT_RECHARGE_MODEL_NAME) @Valid AccountRecharge accountRecharge,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ACCOUNT_RECHARGE_MODEL_NAME, accountRecharge);
            return gotoUpdate(accountRecharge.getStock_id(), model);
        }
        accountRechargeService.doUpdate(accountRecharge);
        return "products/accountRecharge/success";
    }
*/
    @RequestMapping(value = "/accountRecharge/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "accountRecharge/delete";
    }

    @RequestMapping(value = "/accountRecharge/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        accountRechargeService.doDelete(id);
        return "products/accountRecharge/success";
    }
}