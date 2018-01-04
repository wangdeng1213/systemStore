package com.peanut.p2p.user.service.impl;

import com.peanut.p2p.user.dao.InternetUserDao;
import com.peanut.p2p.user.dao.UserInfoDao;
import com.peanut.p2p.user.model.entity.UserInfo;
import com.peanut.p2p.user.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private InternetUserDao internetUserDao;
    @Override
    public UserInfo queryByID(Integer id) {
        return
                userInfoDao.findById(UserInfo.class, id);
    }

    @Override
    public void doSave(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }

    @Override
    public void doUpdate(UserInfo userInfo) {
        userInfoDao.update(userInfo);
    }

    @Override
    @Transactional
    public void doUpdate(Integer id) {
        internetUserDao.doUpdate(id);
        userInfoDao.doUpdate(id);
    }

    @Override
    public List<UserInfo> queryUserName() {
        return userInfoDao.findUserName();
    }

}
