package com.peanut.p2p.user.service;


import com.peanut.p2p.user.model.entity.UserAccount;

/**
 * Created by my on 2015/2/5.
 */
public interface UserAccountService {
    UserAccount queryByID(Integer id);

    void doSave(UserAccount userAccount);

    void doUpdate(UserAccount userAccount);

    void doDelete(Integer id);
}
