
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Contract;
import com.peanut.p2p.code.model.query.ContractQueryObject;
import com.peanut.p2p.code.service.ContractService;
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
public class ContractController {
    private static final String CONTRACT_PAGE_MODEL_NAME = "contractPage";

    private static final String CONTRACT_QUERY_MODEL_NAME = "contractQueryObject";

    private static final String CONTRACT_MODEL_NAME = "contractModel";

    @Resource
    private ContractService contractService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/contract/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(CONTRACT_QUERY_MODEL_NAME) ContractQueryObject contractQueryObject,
            Model model) {
        contractQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(contractQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Contract> contractPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(CONTRACT_PAGE_MODEL_NAME, contractPage);
        model.addAttribute(CONTRACT_QUERY_MODEL_NAME, contractQueryObject);
        return "code/contract/index";
    }

    @RequestMapping(value = "/contract/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(CONTRACT_MODEL_NAME)) {
            model.addAttribute(CONTRACT_MODEL_NAME, new Contract());
        }
        return "code/contract/add";
    }

    @RequestMapping(value = "/contract/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(CONTRACT_MODEL_NAME) @Valid Contract contract,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(CONTRACT_MODEL_NAME, contract);
            return gotoAdd(model);
        }
        contractService.doSave(contract);
        return "code/contract/success";
    }

    @RequestMapping(value = "/contract/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(CONTRACT_MODEL_NAME)) {
            Contract contract = contractService.queryByID(id);
            model.addAttribute(CONTRACT_MODEL_NAME, contract);
        }
        return "code/contract/update";
    }

    @RequestMapping(value = "/contract/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(CONTRACT_MODEL_NAME) @Valid Contract contract,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(CONTRACT_MODEL_NAME, contract);
            return gotoUpdate(contract.getId(), model);
        }
        contractService.doUpdate(contract);
        return "code/contract/success";
    }

    @RequestMapping(value = "/contract/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        contractService.doUpdate(id);
        return "code/contract/success";
    }

//    @RequestMapping(value = "/contract/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        contractService.doDelete(batchDeleteIds);
//        return "code/contract/success";
//    }
}