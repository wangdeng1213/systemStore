
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Period;
import com.peanut.p2p.code.model.query.PeriodQueryObject;
import com.peanut.p2p.code.service.PeriodService;
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
public class PeriodController {
    private static final String PERIOD_PAGE_MODEL_NAME = "periodPage";

    private static final String PERIOD_QUERY_MODEL_NAME = "periodQueryObject";

    private static final String PERIOD_MODEL_NAME = "periodModel";

    @Resource
    private PeriodService periodService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/period/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(PERIOD_QUERY_MODEL_NAME) PeriodQueryObject periodQueryObject,
            Model model) {
        periodQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(periodQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Period> periodPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(PERIOD_PAGE_MODEL_NAME, periodPage);
        model.addAttribute(PERIOD_QUERY_MODEL_NAME, periodQueryObject);
        return "code/period/index";
    }

    @RequestMapping(value = "/period/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(PERIOD_MODEL_NAME)) {
            model.addAttribute(PERIOD_MODEL_NAME, new Period());
        }
        return "code/period/add";
    }

    @RequestMapping(value = "/period/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(PERIOD_MODEL_NAME) @Valid Period period,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(PERIOD_MODEL_NAME, period);
            return gotoAdd(model);
        }
        periodService.doSave(period);
        return "code/period/success";
    }

    @RequestMapping(value = "/period/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(PERIOD_MODEL_NAME)) {
            Period period = periodService.queryByID(id);
            model.addAttribute(PERIOD_MODEL_NAME, period);
        }
        return "code/period/update";
    }

    @RequestMapping(value = "/period/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(PERIOD_MODEL_NAME) @Valid Period period,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(PERIOD_MODEL_NAME, period);
            return gotoUpdate(period.getId(), model);
        }
        periodService.doUpdate(period);
        return "code/period/success";
    }

    @RequestMapping(value = "/period/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        periodService.doUpdate(id);
        return "code/period/success";
    }

//    @RequestMapping(value = "/period/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        periodService.doDelete(batchDeleteIds);
//        return "code/period/success";
//    }
}