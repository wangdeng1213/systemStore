package com.peanut.p2p.products.service.impl;


import com.peanut.p2p.code.dao.AgentDao;
import com.peanut.p2p.code.model.entity.Agent;
import com.peanut.p2p.products.dao.BorrowOrderInfoDao;
import com.peanut.p2p.products.dao.BorrowTranDao;
import com.peanut.p2p.products.model.entity.BorrowTran;
import com.peanut.p2p.products.service.BorrowTranService;
import com.peanut.p2p.user.dao.InternetUserDao;
import com.peanut.p2p.user.model.entity.InternetUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by my on 2015/4/11.
 */
@Service("borrowTranService")
public class BorrowTranServiceImpl implements BorrowTranService {

    @Resource
    private BorrowTranDao borrowTranDao;

    @Resource
    private AgentDao agentDao;
    @Resource
    private InternetUserDao internetUserDao;
    @Resource
    private BorrowOrderInfoDao  borrowOrderInfoDao;
    @Override
    public BorrowTran queryByID(Long borrow_tran_id) {
        return
                borrowTranDao.findById(BorrowTran.class, borrow_tran_id);
    }

    @Override
    public void doSave(BorrowTran borrowTran) {
        borrowTranDao.save(borrowTran);
    }

    @Override
    @Transactional
    public void doUpdate(BorrowTran borrowTran) {
        borrowTranDao.update(borrowTran);
        Agent agent = new Agent();
        Integer userId = borrowTran.getUser_id();
        InternetUser internetUser = internetUserDao.findById(InternetUser.class, userId);
        String name = internetUser.getName();
        agent.setName(name);
        agent.setUserId(userId);
        agentDao.save(agent);
  /*      //审批后把借款订单状态设置为2
        Integer orderId = borrowTran.getOrder_id();
        borrowOrderInfoDao.updateById(orderId);*/
    }

    @Override
    public void doUpdate(Long id) {
        borrowTranDao.update(id);
    }

    @Override
    public void doDelete(Integer borrow_tran_id) {
        borrowTranDao.delete(borrow_tran_id);
    }
}
