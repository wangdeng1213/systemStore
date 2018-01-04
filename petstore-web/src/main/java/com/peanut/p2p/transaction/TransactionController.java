package com.peanut.p2p.transaction;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.transaction.model.entity.Transaction;
import com.peanut.p2p.transaction.model.query.TransactionQueryObject;
import com.peanut.p2p.transaction.service.TransactionService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class TransactionController {
    @Resource
    private TransactionService transactionService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String TRANSACTION_QUERY_MODEL_NAME = "transactionQueryObject";

    private static final String TRANSACTION_PAGE_MODEL_NAME = "transactionPage";

    private static final String TRANSACTION_MODEL_NAME = "transactionModel";

    @RequestMapping(value = "/transaction/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(TRANSACTION_MODEL_NAME)) {
            model.addAttribute(TRANSACTION_MODEL_NAME, new Transaction());
        }
        return "transactions/transaction/add";
    }

    @RequestMapping(value = "/transaction/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(TRANSACTION_QUERY_MODEL_NAME) TransactionQueryObject transactionQueryObject,
            Model model) {
        if(null == transactionQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id", OrderType.desc);
            transactionQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(transactionQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Transaction> transactionPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(TRANSACTION_PAGE_MODEL_NAME, transactionPage);
        model.addAttribute(TRANSACTION_QUERY_MODEL_NAME, transactionQueryObject);
        return "transactions/transaction/index";
    }

    @RequestMapping(value = "/transaction/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(TRANSACTION_MODEL_NAME) @Valid Transaction transaction,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(TRANSACTION_MODEL_NAME, transaction);
            return gotoAdd(model);
        }
        transactionService.doSave(transaction);
        return "transactions/transaction/success";
    }

    @RequestMapping(value = "/transaction/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(TRANSACTION_MODEL_NAME)) {
            Transaction transaction = transactionService.queryByID(id);
            model.addAttribute(TRANSACTION_MODEL_NAME, transaction);
        }
        return "transactions/transaction/update";
    }

    @RequestMapping(value = "/transaction/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(TRANSACTION_MODEL_NAME) @Valid Transaction transaction,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(TRANSACTION_MODEL_NAME, transaction);
            return gotoUpdate(transaction.getTransaction_id(), model);
        }
        transactionService.doUpdate(transaction);
        return "transactions/transaction/success";
    }

    @RequestMapping(value = "/transaction/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "transaction/delete";
    }

    @RequestMapping(value = "/transaction/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        transactionService.doDelete(id);
        return "transactions/transaction/success";
    }
}