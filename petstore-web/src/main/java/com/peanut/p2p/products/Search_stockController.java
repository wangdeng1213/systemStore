package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.products.model.entity.Search_stock;
import com.peanut.p2p.products.model.query.Search_stockQueryObject;
import com.peanut.p2p.products.service.Search_stockService;
import com.peanut.p2p.pagination.service.PageService;
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
public class Search_stockController {
    @Resource
    private Search_stockService search_stockService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String SEARCH_STOCK_QUERY_MODEL_NAME = "search_stockQueryObject";

    private static final String SEARCH_STOCK_PAGE_MODEL_NAME = "search_stockPage";

    private static final String SEARCH_STOCK_MODEL_NAME = "search_stockModel";

    @RequestMapping(value = "/search_stock/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(SEARCH_STOCK_MODEL_NAME)) {
            model.addAttribute(SEARCH_STOCK_MODEL_NAME, new Search_stock());
        }
        return "products/search_stock/add";
    }

    @RequestMapping(value = "/search_stock/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(SEARCH_STOCK_QUERY_MODEL_NAME) Search_stockQueryObject search_stockQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(search_stockQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Search_stock> search_stockPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(SEARCH_STOCK_PAGE_MODEL_NAME, search_stockPage);
        model.addAttribute(SEARCH_STOCK_QUERY_MODEL_NAME, search_stockQueryObject);
        return "products/search_stock/index";
    }

    @RequestMapping(value = "/search_stock/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(SEARCH_STOCK_MODEL_NAME) @Valid Search_stock search_stock,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(SEARCH_STOCK_MODEL_NAME, search_stock);
            return gotoAdd(model);
        }
        search_stockService.doSave(search_stock);
        return "products/search_stock/success";
    }

    @RequestMapping(value = "/search_stock/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(SEARCH_STOCK_MODEL_NAME)) {
            Search_stock search_stock = search_stockService.queryByID(String.valueOf(id));
            model.addAttribute(SEARCH_STOCK_MODEL_NAME, search_stock);
        }
        return "products/search_stock/update";
    }

    @RequestMapping(value = "/search_stock/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(SEARCH_STOCK_MODEL_NAME) @Valid Search_stock search_stock,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(SEARCH_STOCK_MODEL_NAME, search_stock);
            return gotoUpdate(search_stock.getSearch_stock_id(), model);
        }
        search_stockService.doUpdate(search_stock);
        return "products/search_stock/success";
    }

    @RequestMapping(value = "/search_stock/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "search_stock/delete";
    }

    @RequestMapping(value = "/search_stock/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        search_stockService.doDelete(id);
        return "products/search_stock/success";
    }
}