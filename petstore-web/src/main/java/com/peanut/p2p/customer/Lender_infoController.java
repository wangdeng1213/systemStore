package com.peanut.p2p.customer;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.customer.lender_info.model.entity.Lender_info;
import com.peanut.p2p.customer.lender_info.model.query.Lender_infoQueryObject;
import com.peanut.p2p.customer.lender_info.service.Lender_infoService;
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
public class Lender_infoController {
    @Resource
    private Lender_infoService lender_infoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String LENDER_INFO_QUERY_MODEL_NAME = "lender_infoQueryObject";

    private static final String LENDER_INFO_PAGE_MODEL_NAME = "lender_infoPage";

    private static final String LENDER_INFO_MODEL_NAME = "lender_infoModel";

    @RequestMapping(value = "/lender_info/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(LENDER_INFO_MODEL_NAME)) {
            model.addAttribute(LENDER_INFO_MODEL_NAME, new Lender_info());
        }
        return "lender_info/add";
    }

    @RequestMapping(value = "/lender_info/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(LENDER_INFO_QUERY_MODEL_NAME) Lender_infoQueryObject lender_infoQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(lender_infoQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Lender_info> lender_infoPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(LENDER_INFO_PAGE_MODEL_NAME, lender_infoPage);
        model.addAttribute(LENDER_INFO_QUERY_MODEL_NAME, lender_infoQueryObject);
        return "lender_info/index";
    }

    @RequestMapping(value = "/lender_info/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(LENDER_INFO_MODEL_NAME) @Valid Lender_info lender_info,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(LENDER_INFO_MODEL_NAME, lender_info);
            return gotoAdd(model);
        }
        lender_infoService.doSave(lender_info);
        return "lender_info/success";
    }

    @RequestMapping(value = "/lender_info/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(LENDER_INFO_MODEL_NAME)) {
            Lender_info lender_info = lender_infoService.queryByID(id);
            model.addAttribute(LENDER_INFO_MODEL_NAME, lender_info);
        }
        return "lender_info/update";
    }

    @RequestMapping(value = "/lender_info/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(LENDER_INFO_MODEL_NAME) @Valid Lender_info lender_info,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(LENDER_INFO_MODEL_NAME, lender_info);
            return gotoUpdate(lender_info.getLender_id(), model);
        }
        lender_infoService.doUpdate(lender_info);
        return "lender_info/success";
    }

    @RequestMapping(value = "/lender_info/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "lender_info/delete";
    }

    @RequestMapping(value = "/lender_info/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        lender_infoService.doDelete(id);
        return "lender_info/success";
    }
}