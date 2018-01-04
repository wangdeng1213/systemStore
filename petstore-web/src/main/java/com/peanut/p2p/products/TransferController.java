package com.peanut.p2p.products;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Agent;
import com.peanut.p2p.code.model.entity.EnsureType;
import com.peanut.p2p.code.service.AgentService;
import com.peanut.p2p.code.service.EnsureTypeService;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.products.model.entity.*;
import com.peanut.p2p.products.model.query.TransferQueryObject;
import com.peanut.p2p.products.service.Real_stockService;
import com.peanut.p2p.products.service.RiskinfoService;
import com.peanut.p2p.products.service.Search_stockService;
import com.peanut.p2p.products.service.TransferService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@Controller
public class TransferController {
    @Resource
    private TransferService transfer_Service;
    @Resource
    private Real_stockService real_stockService;
    @Resource
    private Search_stockService search_stockService;
    @Resource
    private QueryInfoBuilder queryInfoBuilder;
    @Resource
    private RiskinfoService riskinfoService;
    @Resource
    private AgentService agentService;

    @Resource
    private EnsureTypeService ensureTypeService;

    private static final String ALL_AGENT_MODEL = "allAgentModel";

    private static final String ALL_RISKINFO_MODEL = "allRiskinfoModel";

    private static final String ALL_ENSURETYPE_MODEL = "allEnsureTypeModel";

    @Resource
    private PageService pageService;

    private static final String TRANSFER_QUERY_MODEL_NAME = "transferQueryObject";

    private static final String TRANSFER_PAGE_MODEL_NAME = "transferPage";

    private static final String TRANSFER_MODEL_NAME = "transferModel";


    @ModelAttribute(ALL_RISKINFO_MODEL)
    public List<Riskinfo> getAllRisk() {
        return riskinfoService.queryAll();
    }

    @ModelAttribute(ALL_AGENT_MODEL)
    public List<Agent> getAllAgent() {
        return agentService.queryAll();
    }

    @ModelAttribute(ALL_ENSURETYPE_MODEL)
    public List<EnsureType> getAllEnsureType() {
        return ensureTypeService.queryAll();
    }

    public List<Transfer> queryAll(){
        return transfer_Service.queryAll();
    };


    @RequestMapping(value = "/transfer/{pid}/add", method = RequestMethod.GET)
    public String gotoAdd(Model model,@PathVariable String pid) {
        if (!model.containsAttribute(TRANSFER_MODEL_NAME)) {
            model.addAttribute(TRANSFER_MODEL_NAME, new Transfer());
        }
        model.addAttribute("pid",pid);
        return "products/transfer/add";
    }
//    @RequestMapping(value = "/transfer/{pid}/info", method = RequestMethod.GET)
//         public String gotoInfo(Model model,@PathVariable String pid) {
//        Transfer t = transfer_Service.queryByPID(pid);
//        model.addAttribute(TRANSFER_MODEL_NAME, t);
//        return "products/transfer/info";
//    }
    @RequestMapping(value = "/transfer/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(TRANSFER_QUERY_MODEL_NAME) TransferQueryObject transfer_QueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(transfer_QueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Transfer> transferPage = pageService.queryDefaultPageSizePage(queryInfo);
        model.addAttribute(TRANSFER_PAGE_MODEL_NAME, transferPage);
        model.addAttribute(TRANSFER_QUERY_MODEL_NAME, transfer_QueryObject);
        return "products/transfer/index";
    }

    @RequestMapping(value = "/transfer/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable String id, Model model) {
        if (!model.containsAttribute(TRANSFER_MODEL_NAME)) {
            Transfer transfer = transfer_Service.queryByPID(id);
            model.addAttribute(TRANSFER_MODEL_NAME, transfer);
        }
        return "products/transfer/update";
    }
    @RequestMapping(value = "/transfer/{id}/update", method = RequestMethod.POST)
    public String update(
            @ModelAttribute(TRANSFER_MODEL_NAME)@Valid Transfer transfer,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(TRANSFER_MODEL_NAME, transfer);
            return gotoUpdate(transfer.getProductId(), model);
        }
        transfer_Service.doUpdate(transfer);
        return "products/transfer/success";
    }


    @RequestMapping(value = "/transfer/{id}/delete", method = RequestMethod.GET)
    public String gotoDelete() {
        return "transfer/delete";
    }

    @RequestMapping(value = "/transfer/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        transfer_Service.doDelete(id);
        return "products/transfer/success";
    }
}