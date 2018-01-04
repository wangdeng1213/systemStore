package com.peanut.p2p.schedule.workflow;

import com.peanut.p2p.products.dao.BorrowTranDao;
import com.peanut.p2p.products.model.entity.BorrowTran;
import com.peanut.workflow.domain.ProcessInstanceEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by wentao.awt on 2015/4/27.
 */
public class ProductWorkflowStartJob extends AbstractWorkflowStartJob {
    @Resource
    private BorrowTranDao borrowTranDao;

    @Override
    public Collection<BorrowTran> findAllStartProcessInstanceEntities() {
        return borrowTranDao.findProductByStatus("-1");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public <T extends ProcessInstanceEntity> void beforeStartWorkflow(T processInstanceEntity) throws Exception {
        BorrowTran borrowTran = borrowTranDao.findById(BorrowTran.class, processInstanceEntity.getId());
        borrowTran.setDeal_status("0");
        borrowTranDao.update(borrowTran);
    }
}
