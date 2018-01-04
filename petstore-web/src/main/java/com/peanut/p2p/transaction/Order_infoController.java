package com.peanut.p2p.transaction;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.transaction.model.entity.Order_info;
import com.peanut.p2p.transaction.model.query.Order_infoQueryObject;
import com.peanut.p2p.transaction.service.Order_infoService;
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
public class Order_infoController {
    @Resource
    private Order_infoService order_infoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String ORDER_INFO_QUERY_MODEL_NAME = "order_infoQueryObject";

    private static final String ORDER_INFO_PAGE_MODEL_NAME = "order_infoPage";

    private static final String ORDER_INFO_MODEL_NAME = "order_infoModel";

    @RequestMapping(value = "/order_info/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(ORDER_INFO_MODEL_NAME)) {
            model.addAttribute(ORDER_INFO_MODEL_NAME, new Order_info());
        }
        return "transactions/order_info/add";
    }

    @RequestMapping(value = "/order_info/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ORDER_INFO_QUERY_MODEL_NAME) Order_infoQueryObject order_infoQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(order_infoQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Order_info> order_infoPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(ORDER_INFO_PAGE_MODEL_NAME, order_infoPage);
        model.addAttribute(ORDER_INFO_QUERY_MODEL_NAME, order_infoQueryObject);
        return "transactions/order_info/index";
    }

    @RequestMapping(value = "/order_info/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(ORDER_INFO_MODEL_NAME) @Valid Order_info order_info,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(ORDER_INFO_MODEL_NAME, order_info);
            return gotoAdd(model);
        }
        order_infoService.doSave(order_info);
        return "transactions/order_info/success";
    }

    @RequestMapping(value = "/order_info/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(ORDER_INFO_MODEL_NAME)) {
            Order_info order_info = order_infoService.queryByID(id);
            model.addAttribute(ORDER_INFO_MODEL_NAME, order_info);
        }
        return "transactions/order_info/update";
    }

    @RequestMapping(value = "/order_info/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(ORDER_INFO_MODEL_NAME) @Valid Order_info order_info,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ORDER_INFO_MODEL_NAME, order_info);
            return gotoUpdate(order_info.getOrder_id(), model);
        }
        order_infoService.doUpdate(order_info);
        return "transactions/order_info/success";
    }

    @RequestMapping(value = "/order_info/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "order_info/delete";
    }

    @RequestMapping(value = "/order_info/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        order_infoService.doDelete(id);
        return "transactions/order_info/success";
    }
}