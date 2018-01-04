package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.BorrowOrderInfo;
import com.peanut.p2p.products.model.query.BorrowOrderInfoQueryObject;
import com.peanut.p2p.products.service.BorrowOrderInfoService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/4/11.
 */
@Controller
public class BorrowOrderInfoController {
    @Resource
    private BorrowOrderInfoService borrowOrderInfoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String BORROWORDERINFO_QUERY_MODEL_NAME = "borrowOrderInfoQueryObject";

    private static final String BORROWORDERINFO_PAGE_MODEL_NAME = "borrowOrderInfoPage";

    private static final String BORROWORDERINFO_MODEL_NAME = "borrowOrderInfoModel";

    @RequestMapping(value = "/borrowOrderInfo/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BORROWORDERINFO_MODEL_NAME)) {
            model.addAttribute(BORROWORDERINFO_MODEL_NAME, new BorrowOrderInfo());
        }
        return "products/borrowOrderInfo/add";
    }

    @RequestMapping(value = "/borrowOrderInfo/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BORROWORDERINFO_QUERY_MODEL_NAME) BorrowOrderInfoQueryObject borrowOrderInfoQueryObject,
            Model model) {
            QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(borrowOrderInfoQueryObject);
            queryInfo.setPageNum(pageNum);
            Page<BorrowOrderInfo> borrowOrderInfoPage = pageService.queryDefaultPageSizePage(queryInfo);
            model.addAttribute(BORROWORDERINFO_PAGE_MODEL_NAME, borrowOrderInfoPage);
            model.addAttribute(BORROWORDERINFO_QUERY_MODEL_NAME, borrowOrderInfoQueryObject);

            return "products/borrowOrderInfo/index";

    }
    @RequestMapping(value = "/borrowOrderInfo/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(BORROWORDERINFO_MODEL_NAME) @Valid BorrowOrderInfo borrowOrderInfo,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(BORROWORDERINFO_MODEL_NAME, borrowOrderInfo);
            return gotoAdd(model);
        }
        borrowOrderInfoService.doSave(borrowOrderInfo);
        return "products/borrowOrderInfo/success";
    }

    @RequestMapping(value = "/borrowOrderInfo/{borrow_order_id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer borrow_order_id, Model model) {
        if (!model.containsAttribute(BORROWORDERINFO_MODEL_NAME)) {
            BorrowOrderInfo borrowOrderInfo = borrowOrderInfoService.queryByID(borrow_order_id);
            model.addAttribute(BORROWORDERINFO_MODEL_NAME, borrowOrderInfo);
        }
        return "products/borrowOrderInfo/update";
    }

    @RequestMapping(value = "/borrowOrderInfo/{borrow_order_id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(BORROWORDERINFO_MODEL_NAME) @Valid BorrowOrderInfo borrowOrderInfo,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(BORROWORDERINFO_MODEL_NAME, borrowOrderInfo);
            return gotoUpdate(borrowOrderInfo.getBorrow_order_id(), model);
        }
        borrowOrderInfoService.doUpdate(borrowOrderInfo);
        return "products/borrowOrderInfo/success";
    }

    @RequestMapping(value = "/borrowOrderInfo/{borrow_order_id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "borrowOrderInfo/delete";
    }

    @RequestMapping(value = "/borrowOrderInfo/{borrow_order_id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer borrow_order_id) {
        borrowOrderInfoService.doDelete(borrow_order_id);
        return "products/borrowOrderInfo/success";
    }
}
