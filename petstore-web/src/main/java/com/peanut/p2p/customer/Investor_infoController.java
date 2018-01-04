package com.peanut.p2p.customer;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.customer.investor_info.model.entity.Investor_info;
import com.peanut.p2p.customer.investor_info.model.query.Investor_infoQueryObject;
import com.peanut.p2p.customer.investor_info.service.Investor_infoService;
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
public class Investor_infoController {
    @Resource
    private Investor_infoService investor_infoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String INVESTOR_INFO_QUERY_MODEL_NAME = "investor_infoQueryObject";

    private static final String INVESTOR_INFO_PAGE_MODEL_NAME = "investor_infoPage";

    private static final String INVESTOR_INFO_MODEL_NAME = "investor_infoModel";

    @RequestMapping(value = "/investor_info/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(INVESTOR_INFO_MODEL_NAME)) {
            model.addAttribute(INVESTOR_INFO_MODEL_NAME, new Investor_info());
        }
        return "investor_info/add";
    }

    @RequestMapping(value = "/investor_info/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(INVESTOR_INFO_QUERY_MODEL_NAME) Investor_infoQueryObject investor_infoQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(investor_infoQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Investor_info> investor_infoPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(INVESTOR_INFO_PAGE_MODEL_NAME, investor_infoPage);
        model.addAttribute(INVESTOR_INFO_QUERY_MODEL_NAME, investor_infoQueryObject);
        return "investor_info/index";
    }

    @RequestMapping(value = "/investor_info/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(INVESTOR_INFO_MODEL_NAME) @Valid Investor_info investor_info,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(INVESTOR_INFO_MODEL_NAME, investor_info);
            return gotoAdd(model);
        }
        investor_infoService.doSave(investor_info);
        return "investor_info/success";
    }

    @RequestMapping(value = "/investor_info/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(INVESTOR_INFO_MODEL_NAME)) {
            Investor_info investor_info = investor_infoService.queryByID(id);
            model.addAttribute(INVESTOR_INFO_MODEL_NAME, investor_info);
        }
        return "investor_info/update";
    }

    @RequestMapping(value = "/investor_info/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(INVESTOR_INFO_MODEL_NAME) @Valid Investor_info investor_info,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(INVESTOR_INFO_MODEL_NAME, investor_info);
            return gotoUpdate(investor_info.getLender_id(), model);
        }
        investor_infoService.doUpdate(investor_info);
        return "investor_info/success";
    }

    @RequestMapping(value = "/investor_info/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "investor_info/delete";
    }

    @RequestMapping(value = "/investor_info/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        investor_infoService.doDelete(id);
        return "investor_info/success";
    }
}