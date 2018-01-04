
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.CreditInfo;
import com.peanut.p2p.code.model.query.CreditInfoQueryObject;
import com.peanut.p2p.code.service.CreditInfoService;
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
public class CreditInfoController {
    private static final String CREDIT_INFO_PAGE_MODEL_NAME = "creditInfoPage";

    private static final String CREDIT_INFO_QUERY_MODEL_NAME = "creditInfoQueryObject";

    private static final String CREDIT_INFO_MODEL_NAME = "creditInfoModel";

    @Resource
    private CreditInfoService creditInfoService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/creditInfo/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(CREDIT_INFO_QUERY_MODEL_NAME) CreditInfoQueryObject creditInfoQueryObject,
            Model model) {
        creditInfoQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(creditInfoQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<CreditInfo> creditInfoPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(CREDIT_INFO_PAGE_MODEL_NAME, creditInfoPage);
        model.addAttribute(CREDIT_INFO_QUERY_MODEL_NAME, creditInfoQueryObject);
        return "code/creditinfo/index";
    }

    @RequestMapping(value = "/creditInfo/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(CREDIT_INFO_MODEL_NAME)) {
            model.addAttribute(CREDIT_INFO_MODEL_NAME, new CreditInfo());
        }
        return "code/creditinfo/add";
    }

    @RequestMapping(value = "/creditInfo/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(CREDIT_INFO_MODEL_NAME) @Valid CreditInfo creditInfo,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(CREDIT_INFO_MODEL_NAME, creditInfo);
            return gotoAdd(model);
        }
        creditInfoService.doSave(creditInfo);
        return "code/creditinfo/success";
    }

    @RequestMapping(value = "/creditInfo/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(CREDIT_INFO_MODEL_NAME)) {
            CreditInfo creditInfo = creditInfoService.queryByID(id);
            model.addAttribute(CREDIT_INFO_MODEL_NAME, creditInfo);
        }
        return "code/creditinfo/update";
    }

    @RequestMapping(value = "/creditInfo/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(CREDIT_INFO_MODEL_NAME) @Valid CreditInfo creditInfo,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(CREDIT_INFO_MODEL_NAME, creditInfo);
            return gotoUpdate(creditInfo.getId(), model);
        }
        creditInfoService.doUpdate(creditInfo);
        return "code/creditinfo/success";
    }

    @RequestMapping(value = "/creditInfo/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        creditInfoService.doUpdate(id);
        return "code/creditinfo/success";
    }

//    @RequestMapping(value = "/creditInfo/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        creditInfoService.doDelete(batchDeleteIds);
//        return "code/creditInfo/success";
//    }
}