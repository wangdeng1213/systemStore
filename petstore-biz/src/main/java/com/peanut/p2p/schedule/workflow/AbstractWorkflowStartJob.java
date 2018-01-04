package com.peanut.p2p.schedule.workflow;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.peanut.utilities.ExecutorServiceUtils;
import com.peanut.workflow.domain.ProcessInstanceEntity;
import com.peanut.workflow.service.ProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wentao.awt on 2015/4/27.
 */
public abstract class AbstractWorkflowStartJob {
    protected static Logger logger = LoggerFactory.getLogger(AbstractWorkflowStartJob.class);

    private ScheduledExecutorService workflowStartExecutorService;

    private int initialDelay = 0;

    private int period = 0;

    private int shutdownTimeout = 4000;

    private String processInstanceName;

    private String processInstanceKey;

    @Resource
    private ProcessService processService;

    @PostConstruct
    public void init() {
        workflowStartExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat(processInstanceName + "WorkflowStartExecutorService-%1$d").build());
    }


    public <T extends ProcessInstanceEntity> void execute() {
        workflowStartExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                Collection<T> processInstanceEntities = null;

                try {
                    processInstanceEntities = findAllStartProcessInstanceEntities();

                    for (T t : processInstanceEntities) {
                        try {
                            beforeStartWorkflow(t);
                            Map<String, Object> vars = Maps.newHashMap();
                            processService.startWorkflow(processInstanceKey, t, vars);
                        } catch (Exception e) {
                            logger.error("processInstanceName:[{}],instance:[{}],start workflow error!", e);
                        }
                    }
                } catch (Exception e) {
                    logger.error("job execute error!ProcessInstanceEntities:[{}]", processInstanceEntities);
                }
            }
        }, initialDelay, period, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void destroy() {
        ExecutorServiceUtils.shutdownNow(workflowStartExecutorService, shutdownTimeout);
    }

    public abstract <T extends ProcessInstanceEntity> Collection<T> findAllStartProcessInstanceEntities();

    public abstract <T extends ProcessInstanceEntity> void beforeStartWorkflow(T processInstanceEntity) throws Exception;

    public void setInitialDelay(int initialDelay) {
        this.initialDelay = initialDelay;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setShutdownTimeout(int shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public void setProcessInstanceKey(String processInstanceKey) {
        this.processInstanceKey = processInstanceKey;
    }
}
