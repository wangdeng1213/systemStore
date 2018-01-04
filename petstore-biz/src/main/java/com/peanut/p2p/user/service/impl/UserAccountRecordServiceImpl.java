package com.peanut.p2p.user.service.impl;


import com.peanut.p2p.user.dao.UserAccountRecordDao;
import com.peanut.p2p.user.model.entity.UserAccountRecord;
import com.peanut.p2p.user.service.UserAccountRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my on 2015/2/5.
 */
@Service("userAccountRecordService")
public class UserAccountRecordServiceImpl implements UserAccountRecordService {
    @Resource
    private UserAccountRecordDao userAccountRecordDao;

    @Override
    public UserAccountRecord queryByID(Integer id) {
        return userAccountRecordDao.findById(UserAccountRecord.class,id);
    }

    @Override
    public void doSave(UserAccountRecord userAccountRecode) {
          userAccountRecordDao.save(userAccountRecode);
    }

    @Override
    public void doUpdate(UserAccountRecord userAccountRecode) {
          userAccountRecordDao.update(userAccountRecode);
    }

    @Override
    public void doDelete(Integer id) {

        UserAccountRecord userAccountRecord = userAccountRecordDao.findById(UserAccountRecord.class,id);
        userAccountRecordDao.delete(userAccountRecord);
    }
}
