package com.peanut.p2p.user.service;

import com.peanut.p2p.user.model.entity.UserPrivilege;

/**
 * Created by my on 2015/2/5.
 */
public interface UserPrivilegeService {
    UserPrivilege queryByID(Integer id);

    void doSave(UserPrivilege userPrivilege);

    void doUpdate(UserPrivilege userPrivilege);

    void doDelete(Integer id);
}
