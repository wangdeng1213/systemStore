package com.peanut.p2p.user.service.impl;

import com.peanut.p2p.user.dao.InternetUserDao;
import com.peanut.p2p.user.dao.UserInfoDao;
import com.peanut.p2p.user.model.entity.InternetUser;
import com.peanut.p2p.user.model.entity.UserInfo;
import com.peanut.p2p.user.service.InternetUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by my on 2015/2/26.
 */
@Service("internetUserService")
public class InternetUserServiceImpl implements InternetUserService {
    @Resource
    private InternetUserDao internetUserDao;

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public void doUpdate(InternetUser internetUser) {
        internetUserDao.update(internetUser);
    }
   //userinfo转换为internetuser
    @Override
    @Transactional
    public void doUpdate(UserInfo userInfo) {
        InternetUser internetUser = queryByID(userInfo.getId());
        internetUser.setActStatus(userInfo.getActStatus());
        internetUser.setEmail(userInfo.getEmail());
        internetUser.setId(userInfo.getId());
        internetUser.setIdcard(userInfo.getIdcard());
        internetUser.setMobilephone(userInfo.getMobilephone());
        internetUser.setName(userInfo.getName());
        internetUser.setPassword(userInfo.getPassword());
        internetUser.setUserName(userInfo.getUserName());
        doUpdate(internetUser);
        userInfoDao.update(userInfo);
    }
    @Override
    @Transactional
    public void doUpdate(Integer id){
        internetUserDao.doUpdate(id);
        userInfoDao.doUpdate(id);
    }

    @Override
    public InternetUser queryByID(Integer id) {
        return
                internetUserDao.findById(InternetUser.class, id);
    }
}
