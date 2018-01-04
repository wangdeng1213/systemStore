package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.BorrowStat;
import com.peanut.p2p.products.model.query.BorrowStatQueryObject;
import com.peanut.p2p.products.service.BorrowStatService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by my on 2015/4/11.
 */
@Controller
public class BorrowStatController {
    @Resource
    private BorrowStatService borrowStatService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String BORROWSTAT_QUERY_MODEL_NAME = "borrowStatQueryObject";

    private static final String BORROWSTAT_PAGE_MODEL_NAME = "borrowStatPage";

    private static final String BORROWSTAT_MODEL_NAME = "borrowStatModel";

    @RequestMapping(value = "/borrowStat/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BORROWSTAT_MODEL_NAME)) {
            model.addAttribute(BORROWSTAT_MODEL_NAME, new BorrowStat());
        }
        return "products/borrowStat/add";
    }

    @RequestMapping(value = "/borrowStat/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BORROWSTAT_QUERY_MODEL_NAME) BorrowStatQueryObject borrowStatQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(borrowStatQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<BorrowStat> borrowStatPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(BORROWSTAT_PAGE_MODEL_NAME, borrowStatPage);
        model.addAttribute(BORROWSTAT_QUERY_MODEL_NAME, borrowStatQueryObject);
        return "products/borrowStat/index";
    }

    @RequestMapping(value = "/borrowStat/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(BORROWSTAT_MODEL_NAME) @Valid BorrowStat borrowStat,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(BORROWSTAT_MODEL_NAME, borrowStat);
            return gotoAdd(model);
        }
        borrowStatService.doSave(borrowStat);
        return "products/borrowStat/success";
    }

    @RequestMapping(value = "/borrowStat/{stat_id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer stat_id, Model model) {
        if (!model.containsAttribute(BORROWSTAT_MODEL_NAME)) {
            BorrowStat borrowStat = borrowStatService.queryByID(stat_id);
            model.addAttribute(BORROWSTAT_MODEL_NAME, borrowStat);
        }
        return "products/borrowStat/update";
    }

    @RequestMapping(value = "/borrowStat/{stat_id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(BORROWSTAT_MODEL_NAME) @Valid BorrowStat borrowStat,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(BORROWSTAT_MODEL_NAME, borrowStat);
            return gotoUpdate(borrowStat.getStat_id(), model);
        }
        borrowStatService.doUpdate(borrowStat);
        return "products/borrowStat/success";
    }

    @RequestMapping(value = "/borrowStat/{stat_id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "products/borrowStat/delete";
    }

    @RequestMapping(value = "/borrowStat/{stat_id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer stat_id) {
        borrowStatService.doDelete(stat_id);
        return "products/borrowStat/success";
    }
}
