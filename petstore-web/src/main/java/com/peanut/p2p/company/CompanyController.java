package com.peanut.p2p.company;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.company.model.entity.Company;
import com.peanut.p2p.company.model.query.CompanyQueryObject;
import com.peanut.p2p.company.service.CompanyService;
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
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String COMPANY_QUERY_MODEL_NAME = "companyQueryObject";

    private static final String COMPANY_PAGE_MODEL_NAME = "companyPage";

    private static final String COMPANY_MODEL_NAME = "companyModel";

    @RequestMapping(value = "/company/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(COMPANY_MODEL_NAME)) {
            model.addAttribute(COMPANY_MODEL_NAME, new Company());
        }
        return "company/add";
    }

    @RequestMapping(value = "/company/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(COMPANY_QUERY_MODEL_NAME) CompanyQueryObject companyQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(companyQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Company> companyPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(COMPANY_PAGE_MODEL_NAME, companyPage);
        model.addAttribute(COMPANY_QUERY_MODEL_NAME, companyQueryObject);
        return "company/index";
    }

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(COMPANY_MODEL_NAME) @Valid Company company,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(COMPANY_MODEL_NAME, company);
            return gotoAdd(model);
        }
        companyService.doSave(company);
        return "company/success";
    }

    @RequestMapping(value = "/company/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(COMPANY_MODEL_NAME)) {
            Company company = companyService.queryByID(id);
            model.addAttribute(COMPANY_MODEL_NAME, company);
        }
        return "company/update";
    }

    @RequestMapping(value = "/company/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(COMPANY_MODEL_NAME) @Valid Company company,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(COMPANY_MODEL_NAME, company);
            return gotoUpdate(company.getId(), model);
        }
        companyService.doUpdate(company);
        return "company/success";
    }

    @RequestMapping(value = "/company/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "company/delete";
    }

    @RequestMapping(value = "/company/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        companyService.doDelete(id);
        return "company/success";
    }

}