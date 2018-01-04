package com.peanut.p2p.products;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.BoActualRepayment;
import com.peanut.p2p.products.model.query.BoActualRepaymentQueryObject;
import com.peanut.p2p.products.service.BoActualRepaymentService;
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
public class BoActualRepaymentController {

    @Resource
    private BoActualRepaymentService boActualRepaymentService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String ACTUALREPAYMENT_QUERY_MODEL_NAME = "actualRepaymentQueryObject";

    private static final String ACTUALREPAYMENT_PAGE_MODEL_NAME = "actualRepaymentPage";

    private static final String VACTUALREPAYMENT_QUERY_MODEL_NAME = "vActualRepaymentQueryObject";

    private static final String VACTUALREPAYMENT_PAGE_MODEL_NAME = "vActualRepaymentPage";

    private static final String ACTUALREPAYMENT_MODEL_NAME = "actualRepaymentModel";

    @RequestMapping(value = "/actualRepayment/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(ACTUALREPAYMENT_MODEL_NAME)) {
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, new BoActualRepayment());
        }
        return "products/actualRepayment/add";
    }

    @RequestMapping(value = "/actualRepayment/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ACTUALREPAYMENT_QUERY_MODEL_NAME) BoActualRepaymentQueryObject actualRepaymentQueryObject,
            Model model) {
        if(null == actualRepaymentQueryObject){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            actualRepaymentQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(actualRepaymentQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<BoActualRepayment> actualRepaymentPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(ACTUALREPAYMENT_PAGE_MODEL_NAME, actualRepaymentPage);
        model.addAttribute(ACTUALREPAYMENT_QUERY_MODEL_NAME, actualRepaymentQueryObject);
        return "products/actualRepayment/index";
    }
    @RequestMapping(value = "/actualRepayment/queryList", method = RequestMethod.GET)
    public String index2(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(VACTUALREPAYMENT_QUERY_MODEL_NAME) BoActualRepaymentQueryObject actualRepaymentQueryObject,
            Model model) {
        if(null == actualRepaymentQueryObject){
            Order[] ss = new Order[1];
            ss[0] = new Order("id", OrderType.desc);
            actualRepaymentQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(actualRepaymentQueryObject);
        queryInfo.setPageNum(pageNum);
       // model.addAttribute(ACTUALREPAYMENT_PAGE_MODEL_NAME, actualRepaymentPage);
        model.addAttribute(ACTUALREPAYMENT_QUERY_MODEL_NAME, actualRepaymentQueryObject);
        return "products/actualRepayment/indexList";
    }
    @RequestMapping(value = "/actualRepayment/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(ACTUALREPAYMENT_MODEL_NAME) @Valid BoActualRepayment actualRepayment,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, actualRepayment);
            return gotoAdd(model);
        }
        boActualRepaymentService.doSave(actualRepayment);
        return "products/products/actualRepayment/success";
    }

    @RequestMapping(value = "/actualRepayment/{actual_repayment_id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(ACTUALREPAYMENT_MODEL_NAME)) {
            BoActualRepayment actualRepayment = boActualRepaymentService.queryByID(id);
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, actualRepayment);
        }
        return "products/actualRepayment/update";
    }

    @RequestMapping(value = "/actualRepayment/{actual_repayment_id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(ACTUALREPAYMENT_MODEL_NAME) @Valid BoActualRepayment actualRepayment,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ACTUALREPAYMENT_MODEL_NAME, actualRepayment);
            return gotoUpdate(actualRepayment.getId(), model);
        }
        boActualRepaymentService.doUpdate(actualRepayment);
        return "products/actualRepayment/success";
    }

    @RequestMapping(value = "/actualRepayment/{actual_repayment_id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "products/actualRepayment/delete";
    }

    @RequestMapping(value = "/actualRepayment/{actual_repayment_id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer actual_repayment_id) {
        boActualRepaymentService.doDelete(actual_repayment_id);
        return "products/actualRepayment/success";
    }
}
