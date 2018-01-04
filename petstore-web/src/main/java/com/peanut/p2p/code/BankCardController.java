package com.peanut.p2p.code;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.BankCard;
import com.peanut.p2p.code.model.query.BankCardQueryObject;
import com.peanut.p2p.code.service.BankCardService;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by my on 2015/5/6.
 */
@Controller
public class BankCardController {

    @Resource
    private BankCardService bankCardService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String  BANK_CARD_QUERY_MODEL_NAME = "bankCardQueryObject";

    private static final String  BANK_CARD_PAGE_MODEL_NAME = "bankCardPage";

    private static final String  BANK_CARD_MODEL_NAME = "bankCardModel";

    @RequestMapping(value = "/bankCard/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BANK_CARD_MODEL_NAME)) {
            model.addAttribute(BANK_CARD_MODEL_NAME, new BankCard());
        }
        return "code/bankCard/add";
    }

    @RequestMapping(value = "/bankCard/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute( BANK_CARD_QUERY_MODEL_NAME) BankCardQueryObject bankCardQueryObject,
            Model model) {
        if(null == bankCardQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            bankCardQueryObject.setOrders(ss);
        }
        bankCardQueryObject.setActStatus(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(bankCardQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<BankCard> BankCardPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute( BANK_CARD_PAGE_MODEL_NAME, BankCardPage);
        model.addAttribute( BANK_CARD_QUERY_MODEL_NAME, bankCardQueryObject);
        return "code/bankCard/index";
    }

    @RequestMapping(value = "/bankCard/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(BANK_CARD_MODEL_NAME) @Valid BankCard bankCard,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute( BANK_CARD_MODEL_NAME, bankCard);
            return gotoAdd(model);
        }
        bankCardService.doSave(bankCard);
        return "code/bankCard/success";
    }

    @RequestMapping(value = "/bankCard/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute( BANK_CARD_MODEL_NAME)) {
            BankCard bankCard = bankCardService.queryByID(id);
            model.addAttribute( BANK_CARD_MODEL_NAME, bankCard);
        }
        return "code/bankCard/update";
    }

    @RequestMapping(value = "/bankCard/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute( BANK_CARD_MODEL_NAME) @Valid BankCard bankCard,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute( BANK_CARD_MODEL_NAME, bankCard);
            return gotoUpdate(bankCard.getId(), model);
        }
        bankCardService.doUpdate(bankCard);
        return "code/bankCard/success";
    }

    @RequestMapping(value = "/bankCard/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "code/bankCard/delete";
    }

    @RequestMapping(value = "/bankCard/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        bankCardService.doUpdate(id);
        return "code/bankCard/success";
    }
}
