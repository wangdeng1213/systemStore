
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Agent;
import com.peanut.p2p.code.model.query.AgentQueryObject;
import com.peanut.p2p.code.service.AgentService;
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
public class AgentController {
    private static final String AGENT_PAGE_MODEL_NAME = "agentPage";

    private static final String AGENT_QUERY_MODEL_NAME = "agentQueryObject";

    private static final String AGENT_MODEL_NAME = "agentModel";

    @Resource
    private AgentService agentService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/agent/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(AGENT_QUERY_MODEL_NAME) AgentQueryObject agentQueryObject,
            Model model) {
        agentQueryObject.setStatus(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(agentQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Agent> agentPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(AGENT_PAGE_MODEL_NAME, agentPage);
        model.addAttribute(AGENT_QUERY_MODEL_NAME, agentQueryObject);
        return "code/agent/index";
    }

    @RequestMapping(value = "/agent/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(AGENT_MODEL_NAME)) {
            model.addAttribute(AGENT_MODEL_NAME, new Agent());
        }
        return "code/agent/add";
    }
    @RequestMapping(value = "/agent/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(AGENT_MODEL_NAME) @Valid Agent agent,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(AGENT_MODEL_NAME, agent);
            return gotoAdd(model);
        }
        agent.setStatus(1);
        agentService.doSave(agent);
        return "code/agent/success";
    }

    @RequestMapping(value = "/agent/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(AGENT_MODEL_NAME)) {
            Agent agent = agentService.queryByID(id);
            model.addAttribute(AGENT_MODEL_NAME, agent);
        }
        return "code/agent/update";
    }

    @RequestMapping(value = "/agent/{id}/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(AGENT_MODEL_NAME) @Valid Agent agent,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(AGENT_MODEL_NAME, agent);
            return gotoUpdate(agent.getId(), model);
        }
        agentService.doUpdate(agent);
        return "code/agent/success";
    }

    @RequestMapping(value = "/agent/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        agentService.doUpdate(id);
        return "code/agent/success";
    }

//    @RequestMapping(value = "/agent/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        agentService.doDelete(batchDeleteIds);
//        return "code/agent/success";
//    }
}