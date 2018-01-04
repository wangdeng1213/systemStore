
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Period;
import com.peanut.p2p.code.model.entity.ProductType;
import com.peanut.p2p.code.model.query.ProductTypeQueryObject;
import com.peanut.p2p.code.service.ProductTypeService;
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
public class ProductTypeController {
    private static final String PRODUCT_TYPE_PAGE_MODEL_NAME = "productTypePage";

    private static final String PRODUCT_TYPE_QUERY_MODEL_NAME = "productTypeQueryObject";

    private static final String PRODUCT_TYPE_MODEL_NAME = "productTypeModel";

    @Resource
    private ProductTypeService productTypeService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/productType/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PRODUCT_TYPE_QUERY_MODEL_NAME) ProductTypeQueryObject productTypeQueryObject,
            Model model) {
        productTypeQueryObject.setStatus(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(productTypeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<ProductType> productTypePage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(PRODUCT_TYPE_PAGE_MODEL_NAME, productTypePage);
        model.addAttribute(PRODUCT_TYPE_QUERY_MODEL_NAME, productTypeQueryObject);
        return "code/producttype/index";
    }

    @RequestMapping(value = "/productType/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(PRODUCT_TYPE_MODEL_NAME)) {
            model.addAttribute(PRODUCT_TYPE_MODEL_NAME, new ProductType());
        }
        return "code/producttype/add";
    }

    @RequestMapping(value = "/productType/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(PRODUCT_TYPE_MODEL_NAME) @Valid ProductType productType,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(PRODUCT_TYPE_MODEL_NAME, productType);
            return gotoAdd(model);
        }
        productTypeService.doSave(productType);
        return "code/producttype/success";
    }

    @RequestMapping(value = "/productType/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(PRODUCT_TYPE_MODEL_NAME)) {
            ProductType productType = productTypeService.queryByID(id);
            model.addAttribute(PRODUCT_TYPE_MODEL_NAME, productType);
        }
        return "code/producttype/update";
    }

    @RequestMapping(value = "/productType/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(PRODUCT_TYPE_MODEL_NAME) @Valid ProductType productType,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(PRODUCT_TYPE_MODEL_NAME, productType);
            return gotoUpdate(productType.getId(), model);
        }
        productTypeService.doUpdate(productType);
        return "code/producttype/success";
    }

    @RequestMapping(value = "/productType/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        productTypeService.doUpdate(id);
        return "code/producttype/success";
    }

//    @RequestMapping(value = "/productType/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        productTypeService.doDelete(batchDeleteIds);
//        return "code/productType/success";
//    }
}