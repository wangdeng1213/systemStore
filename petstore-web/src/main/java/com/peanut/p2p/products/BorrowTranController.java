package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.BorrowTran;
import com.peanut.p2p.products.model.query.BorrowTranQueryObject;
import com.peanut.p2p.products.service.BorrowTranService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Administrator on 2015/4/11.
 */
@Controller
public class BorrowTranController {

    @Resource
    private BorrowTranService borrowTranService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String BORROWTRAN_QUERY_MODEL_NAME = "borrowTranQueryObject";

    private static final String BORROWTRAN_PAGE_MODEL_NAME = "borrowTranPage";

    private static final String BORROWTRAN_MODEL_NAME = "borrowTranModel";

    @RequestMapping(value = "/borrowTran/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BORROWTRAN_MODEL_NAME)) {
            model.addAttribute(BORROWTRAN_MODEL_NAME, new BorrowTran());
        }
        return "products/borrowTran/add";
    }

    @RequestMapping(value = "/borrowTran/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BORROWTRAN_QUERY_MODEL_NAME) BorrowTranQueryObject borrowTranQueryObject,
            Model model) {
        borrowTranQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(borrowTranQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<BorrowTran> borrowTranPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(BORROWTRAN_PAGE_MODEL_NAME, borrowTranPage);
        model.addAttribute(BORROWTRAN_QUERY_MODEL_NAME, borrowTranQueryObject);
        return "products/borrowTran/index";
    }

    @RequestMapping(value = "/borrowTran/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(BORROWTRAN_MODEL_NAME) @Valid BorrowTran borrowTran,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(BORROWTRAN_MODEL_NAME, borrowTran);
            return gotoAdd(model);
        }
        borrowTranService.doSave(borrowTran);
        return "products/borrowTran/success";
    }

    @RequestMapping(value = "/borrowTran/{borrow_order_id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Long borrow_tran_id, Model model) {
        if (!model.containsAttribute(BORROWTRAN_MODEL_NAME)) {
            BorrowTran borrowTran = borrowTranService.queryByID(borrow_tran_id);
            model.addAttribute(BORROWTRAN_MODEL_NAME, borrowTran);
        }
        return "products/borrowTran/update";
    }

    @RequestMapping(value = "/borrowTran/{borrow_tran_id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(BORROWTRAN_MODEL_NAME) @Valid BorrowTran borrowTran,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(BORROWTRAN_MODEL_NAME, borrowTran);
            return gotoUpdate(borrowTran.getId(), model);
        }
        borrowTranService.doUpdate(borrowTran);
        return "products/borrowTran/success";
    }

    @RequestMapping(value = "/borrowTran/{borrow_tran_id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "borrowTran/delete";
    }

    @RequestMapping(value = "/borrowTran/{borrow_tran_id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long borrow_tran_id) {
        borrowTranService.doUpdate(borrow_tran_id);
        return "products/borrowTran/success";
    }
}
