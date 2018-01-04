package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.RespParameter;
import com.peanut.p2p.code.model.query.RespParameterQueryObject;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by my on 2015/7/1.
 */
@Controller
public class RespParameterController {

    private static final String RESP_PARAMETER_QUERY_MODEL_NAME ="respQueryObject";

    private static final String RESP_PARAMETER_PAGE_MODEL_NAME ="respPage";

    @Resource
    private QueryInfoBuilder queryInfoBuilder;
    @Resource
    private PageService pageService;

    @RequestMapping(value = "/respParameter/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(RESP_PARAMETER_QUERY_MODEL_NAME) RespParameterQueryObject respParameterQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(respParameterQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<RespParameter> respParameterPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(RESP_PARAMETER_PAGE_MODEL_NAME, respParameterPage);
        model.addAttribute(RESP_PARAMETER_QUERY_MODEL_NAME, respParameterQueryObject);
        return "code/respParameter/index";
    }
}
