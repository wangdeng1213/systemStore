package com.peanut.p2p.products.activiti.listener;

import com.peanut.p2p.products.dao.BorrowTranDao;
import com.peanut.p2p.products.model.entity.BorrowTran;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by wentao.awt on 2015/4/27.
 */
public class PresidentAuditListener implements TaskListener {
    @Autowired
    private RuntimeService runtimeService;

    @Resource
    private BorrowTranDao borrowTranDao;

    @Override
    public void notify(DelegateTask delegateTask) {
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        BorrowTran borrowTran = borrowTranDao.findById(BorrowTran.class, new Long(processInstance.getBusinessKey()));
        borrowTran.setDeal_status("4");

        borrowTranDao.save(borrowTran);
    }
}
