
package com.peanut.p2p.security.logger;

import com.peanut.data.orm.jpql.expression.atomic.Order;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.security.model.entity.SysLog;
import com.peanut.p2p.security.model.query.SysLogQueryObject;
import com.peanut.p2p.security.service.SysLogService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author my
 * @version 1.0
 */
@Controller
public class SysLogController {
    private static final String SYSLOG_PAGE_MODEL_NAME = "sysLogPage";

    private static final String SYSLOG_QUERY_MODEL_NAME = "sysLogQueryObject";

    private static final String SYSLOG_MODEL_NAME = "sysLogModel";

    @Resource
    private SysLogService sysLogService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/sysLog/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(SYSLOG_QUERY_MODEL_NAME) SysLogQueryObject sysLogQueryObject,
            Model model) {
        //设置激活状态默认为1
        sysLogQueryObject.setAct_status(1);
        if(null == sysLogQueryObject.getOrders()){
            Order[] ss = new Order[1];
            ss[0]=new Order("id", OrderType.desc);
            sysLogQueryObject.setOrders(ss);
        }
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(sysLogQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<SysLog> sysLogPage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(SYSLOG_PAGE_MODEL_NAME, sysLogPage);
        model.addAttribute(SYSLOG_QUERY_MODEL_NAME, sysLogQueryObject);
        return "log/index";
    }

    @RequestMapping(value = "/sysLog/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        sysLogService.doUpdate(id);
        return "log/success";
    }

}