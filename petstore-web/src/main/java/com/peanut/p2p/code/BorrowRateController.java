
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.BorrowRate;
import com.peanut.p2p.code.model.query.BorrowRateQueryObject;
import com.peanut.p2p.code.service.BorrowRateService;
import com.peanut.p2p.pagination.service.PageService;
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
public class BorrowRateController {
    private static final String BORROW_RATE_PAGE_MODEL_NAME = "borrowRatePage";

    private static final String BORROW_RATE_QUERY_MODEL_NAME = "borrowRateQueryObject";

    private static final String BORROW_RATE_MODEL_NAME = "borrowRateModel";

    @Resource
    private BorrowRateService borrowRateService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/borrowRate/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BORROW_RATE_QUERY_MODEL_NAME) BorrowRateQueryObject borrowRateQueryObject,
            Model model) {
        borrowRateQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(borrowRateQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<BorrowRate> borrowRatePage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(BORROW_RATE_PAGE_MODEL_NAME, borrowRatePage);
        model.addAttribute(BORROW_RATE_QUERY_MODEL_NAME, borrowRateQueryObject);
        return "code/borrowrate/index";
    }

    @RequestMapping(value = "/borrowRate/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BORROW_RATE_MODEL_NAME)) {
            model.addAttribute(BORROW_RATE_MODEL_NAME, new BorrowRate());
        }
        return "code/borrowrate/add";
    }

    @RequestMapping(value = "/borrowRate/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(BORROW_RATE_MODEL_NAME) @Valid BorrowRate borrowRate,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(BORROW_RATE_MODEL_NAME, borrowRate);
            return gotoAdd(model);
        }
        borrowRateService.doSave(borrowRate);
        return "code/borrowrate/success";
    }

    @RequestMapping(value = "/borrowRate/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(BORROW_RATE_MODEL_NAME)) {
            BorrowRate borrowRate = borrowRateService.queryByID(id);
            model.addAttribute(BORROW_RATE_MODEL_NAME, borrowRate);
        }
        return "code/borrowrate/update";
    }

    @RequestMapping(value = "/borrowRate/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(BORROW_RATE_MODEL_NAME) @Valid BorrowRate borrowRate,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(BORROW_RATE_MODEL_NAME, borrowRate);
            return gotoUpdate(borrowRate.getId(), model);
        }
        borrowRateService.doUpdate(borrowRate);
        return "code/borrowrate/success";
    }

    @RequestMapping(value = "/borrowRate/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        borrowRateService.doUpdate(id);
        return "code/borrowrate/success";
    }

//    @RequestMapping(value = "/borrowRate/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        borrowRateService.doDelete(batchDeleteIds);
//        return "code/borrowRate/success";
//    }
}