package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.products.model.entity.Repayment_plan_relationship;
import com.peanut.p2p.products.model.query.Repayment_plan_relationshipQueryObject;
import com.peanut.p2p.products.service.Repayment_plan_relationshipService;
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
public class Repayment_plan_relationshipController {
    @Resource
    private Repayment_plan_relationshipService repayment_plan_relationshipService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    private static final String REPAYMENT_PLAN_RELATIONSHIP_QUERY_MODEL_NAME = "repayment_plan_relationshipQueryObject";

    private static final String REPAYMENT_PLAN_RELATIONSHIP_PAGE_MODEL_NAME = "repayment_plan_relationshipPage";

    private static final String REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME = "repayment_plan_relationshipModel";

    @RequestMapping(value = "/repayment_plan_relationship/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME)) {
            model.addAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME, new Repayment_plan_relationship());
        }
        return "products/repayment_plan_relationship/add";
    }

    @RequestMapping(value = "/repayment_plan_relationship/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(REPAYMENT_PLAN_RELATIONSHIP_QUERY_MODEL_NAME) Repayment_plan_relationshipQueryObject repayment_plan_relationshipQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(repayment_plan_relationshipQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Repayment_plan_relationship> repayment_plan_relationshipPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(REPAYMENT_PLAN_RELATIONSHIP_PAGE_MODEL_NAME, repayment_plan_relationshipPage);
        model.addAttribute(REPAYMENT_PLAN_RELATIONSHIP_QUERY_MODEL_NAME, repayment_plan_relationshipQueryObject);
        return "products/repayment_plan_relationship/index";
    }

    @RequestMapping(value = "/repayment_plan_relationship/add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME) @Valid Repayment_plan_relationship repayment_plan_relationship,
                      BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME, repayment_plan_relationship);
            return gotoAdd(model);
        }
        repayment_plan_relationshipService.doSave(repayment_plan_relationship);
        return "products/repayment_plan_relationship/success";
    }

    @RequestMapping(value = "/repayment_plan_relationship/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable Integer id, Model model) {
        if (!model.containsAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME)) {
            Repayment_plan_relationship repayment_plan_relationship = repayment_plan_relationshipService.queryByID(id);
            model.addAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME, repayment_plan_relationship);
        }
        return "products/repayment_plan_relationship/update";
    }

    @RequestMapping(value = "/repayment_plan_relationship/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME) @Valid Repayment_plan_relationship repayment_plan_relationship,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(REPAYMENT_PLAN_RELATIONSHIP_MODEL_NAME, repayment_plan_relationship);
            return gotoUpdate(repayment_plan_relationship.getShip_id(), model);
        }
        repayment_plan_relationshipService.doUpdate(repayment_plan_relationship);
        return "products/repayment_plan_relationship/success";
    }

    @RequestMapping(value = "/repayment_plan_relationship/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "repayment_plan_relationship/delete";
    }

    @RequestMapping(value = "/repayment_plan_relationship/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        repayment_plan_relationshipService.doDelete(id);
        return "products/repayment_plan_relationship/success";
    }
}