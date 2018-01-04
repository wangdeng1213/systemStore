package com.peanut.p2p.user.service;


import com.peanut.p2p.user.model.entity.UserAccountRecord;

/**
 * Created by my on 2015/2/5.
 */
public interface UserAccountRecordService {
    UserAccountRecord queryByID(Integer id);

    void doSave(UserAccountRecord userAccountRecode);

    void doUpdate(UserAccountRecord userAccountRecode);

    void doDelete(Integer id);
}
