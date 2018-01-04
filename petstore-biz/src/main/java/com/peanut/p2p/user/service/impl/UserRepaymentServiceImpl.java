package com.peanut.p2p.user.service.impl;
import com.peanut.p2p.user.model.entity.UserRepayment;
import com.peanut.p2p.user.service.UserRepaymentService;
import com.peanut.p2p.user.dao.UserRepaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my on 2015/2/5.
 */
@Service("userRepaymentService")
public class UserRepaymentServiceImpl implements UserRepaymentService {
   @Resource
    private UserRepaymentDao userRepaymentDao;
    @Override
    public UserRepayment queryByID(Integer id) {
        return
                userRepaymentDao.findById(UserRepayment.class, id);
    }

    @Override
    public void doSave(UserRepayment userRepayment) {
        userRepaymentDao.save(userRepayment);
    }

    @Override
    public void doUpdate(UserRepayment userRepayment) {
        userRepaymentDao.update(userRepayment);
    }

    @Override
    public void doDelete(Integer id) {

        UserRepayment userRepayment = userRepaymentDao.findById(UserRepayment.class,id);
        userRepaymentDao.delete(userRepayment);
    }

}
