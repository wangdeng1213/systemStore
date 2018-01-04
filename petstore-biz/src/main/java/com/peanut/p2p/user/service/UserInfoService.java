package com.peanut.p2p.user.service;

import com.peanut.p2p.user.model.entity.UserInfo;

import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
public interface UserInfoService {
    UserInfo queryByID(Integer id);

    void doSave(UserInfo userInfo);

    void doUpdate(UserInfo userInfo);

    void doUpdate(Integer id);

    List<UserInfo> queryUserName();
}
