package com.peanut.p2p.listener;

import com.peanut.p2p.schedule.workflow.ProductWorkflowStartJob;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2015/4/30.
 */
public class WorkflowStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        ProductWorkflowStartJob productWorkflowStartJob = applicationContext.getBean(ProductWorkflowStartJob.class);
        productWorkflowStartJob.execute();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
