package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.products.model.entity.Real_stock;
import com.peanut.p2p.products.model.query.Real_stockQueryObject;
import com.peanut.p2p.products.service.Real_stockService;
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
public class Real_stockController {
    @Resource
    private Real_stockService real_stockService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String REAL_STOCK_QUERY_MODEL_NAME = "real_stockQueryObject";

    private static final String REAL_STOCK_PAGE_MODEL_NAME = "real_stockPage";

    private static final String REAL_STOCK_MODEL_NAME = "real_stockModel";

    @RequestMapping(value = "/real_stock/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(REAL_STOCK_MODEL_NAME)) {
            model.addAttribute(REAL_STOCK_MODEL_NAME, new Real_stock());
        }
        return "products/real_stock/add";
    }

    @RequestMapping(value = "/real_stock/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(REAL_STOCK_QUERY_MODEL_NAME) Real_stockQueryObject real_stockQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(real_stockQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Real_stock> real_stockPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(REAL_STOCK_PAGE_MODEL_NAME, real_stockPage);
        model.addAttribute(REAL_STOCK_QUERY_MODEL_NAME, real_stockQueryObject);
        return "products/real_stock/index";
    }

    @RequestMapping(value = "/real_stock/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(REAL_STOCK_MODEL_NAME) @Valid Real_stock real_stock,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(REAL_STOCK_MODEL_NAME, real_stock);
            return gotoAdd(model);
        }
        real_stockService.doSave(real_stock);
        return "products/real_stock/success";
    }

    @RequestMapping(value = "/real_stock/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(REAL_STOCK_MODEL_NAME)) {
            Real_stock real_stock = real_stockService.queryByPID(String.valueOf(id));
            model.addAttribute(REAL_STOCK_MODEL_NAME, real_stock);
        }
        return "products/real_stock/update";
    }

    @RequestMapping(value = "/real_stock/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(REAL_STOCK_MODEL_NAME) @Valid Real_stock real_stock,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(REAL_STOCK_MODEL_NAME, real_stock);
            return gotoUpdate(real_stock.getStock_id(), model);
        }
        real_stockService.doUpdate(real_stock);
        return "products/real_stock/success";
    }

    @RequestMapping(value = "/real_stock/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "real_stock/delete";
    }

    @RequestMapping(value = "/real_stock/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        real_stockService.doDelete(id);
        return "products/real_stock/success";
    }
}