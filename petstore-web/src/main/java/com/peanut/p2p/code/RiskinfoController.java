
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.Riskinfo;
import com.peanut.p2p.products.model.query.RiskinfoQueryObject;
import com.peanut.p2p.products.service.RiskinfoService;
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
public class RiskinfoController {
    private static final String RISK_INFO_PAGE_MODEL_NAME = "RiskinfoPage";

    private static final String RISK_INFO_QUERY_MODEL_NAME = "RiskinfoQueryObject";

    private static final String RISK_INFO_MODEL_NAME = "RiskinfoModel";

    @Resource
    private RiskinfoService riskinfoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/riskinfo/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(RISK_INFO_QUERY_MODEL_NAME) RiskinfoQueryObject riskinfoQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(riskinfoQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Riskinfo> riskinfoPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(RISK_INFO_PAGE_MODEL_NAME, riskinfoPage);
        model.addAttribute(RISK_INFO_QUERY_MODEL_NAME, riskinfoQueryObject);
        return "code/riskinfo/index";
    }

    @RequestMapping(value = "/riskinfo/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(RISK_INFO_MODEL_NAME)) {
            model.addAttribute(RISK_INFO_MODEL_NAME, new Riskinfo());
        }
        return "code/riskinfo/add";
    }

    @RequestMapping(value = "/riskinfo/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(RISK_INFO_MODEL_NAME) @Valid Riskinfo riskinfo,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(RISK_INFO_MODEL_NAME, riskinfo);
            return gotoAdd(model);
        }
        riskinfoService.doSave(riskinfo);
        return "code/riskinfo/success";
    }

    @RequestMapping(value = "/riskinfo/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Long id, Model model) {
        if (!model.containsAttribute(RISK_INFO_MODEL_NAME)) {
            Riskinfo riskinfo = riskinfoService.queryByID(id);
            model.addAttribute(RISK_INFO_MODEL_NAME, riskinfo);
        }
        return "code/riskinfo/update";
    }

    @RequestMapping(value = "/riskinfo/{id}/update", method = RequestMethod.POST)
    public String update(
            @ModelAttribute(RISK_INFO_MODEL_NAME) @Valid Riskinfo riskinfo,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(RISK_INFO_MODEL_NAME, riskinfo);
            return gotoUpdate(riskinfo.getId(), model);
        }
        riskinfoService.doUpdate(riskinfo);
        return "code/riskinfo/success";
    }

    @RequestMapping(value = "/riskinfo/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        riskinfoService.doUpdate(id);
        return "code/riskinfo/success";
    }

//    @RequestMapping(value = "/agent/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        agentService.doDelete(batchDeleteIds);
//        return "code/agent/success";
//    }
}