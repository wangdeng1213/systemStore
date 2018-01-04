package com.peanut.p2p.user.service.impl;

import com.peanut.p2p.user.dao.UserPrivilegeDao;
import com.peanut.p2p.user.model.entity.UserPrivilege;
import com.peanut.p2p.user.service.UserPrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
@Service("userPrivilegeService")
public class UserPrivilegeServiceImpl implements UserPrivilegeService {
    @Resource
    private UserPrivilegeDao userPrivilegeDao;

//    public List<UserPrivilege> getPrivilegeByLevel(Integer level){
//        return userPrivilegeDao.getPrivilegeByLevel(level);
//    }
//
//    public List<UserPrivilege> getPrivileges(String credit,Integer level ){
//        return userPrivilegeDao.getPrivileges(credit,level);
//    }
    @Override
    public UserPrivilege queryByID(Integer id) {
        return userPrivilegeDao.findById(UserPrivilege.class,id);
    }

    @Override
    public void doSave(UserPrivilege userPrivilege) {
        userPrivilegeDao.save(userPrivilege);

    }

    @Override
    public void doUpdate(UserPrivilege userPrivilege) {
         userPrivilegeDao.update(userPrivilege);
    }

    @Override
    public void doDelete(Integer id) {
        UserPrivilege userPrivilege = userPrivilegeDao.findById(UserPrivilege.class,id);
        userPrivilegeDao.delete(userPrivilege);
    }
}
