package com.peanut.p2p.user.service.impl;

import com.peanut.p2p.user.dao.UserAccountDao;
import com.peanut.p2p.user.model.entity.UserAccount;
import com.peanut.p2p.user.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my on 2015/2/5.
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService{
    @Resource
    private UserAccountDao userAccountDao;

    @Override
    public UserAccount queryByID(Integer id) {
        return
                userAccountDao.findById(UserAccount.class, id);
    }

    @Override
    public void doSave(UserAccount userAccount) {
        userAccountDao.save(userAccount);
    }

    @Override
    public void doUpdate(UserAccount userAccount) {
        userAccountDao.update(userAccount);
    }

    @Override
    public void doDelete(Integer id) {
        UserAccount userAccount = userAccountDao.findById(UserAccount.class,id);
        userAccountDao.delete(userAccount);
    }
}
