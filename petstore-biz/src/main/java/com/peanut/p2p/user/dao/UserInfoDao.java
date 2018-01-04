package com.peanut.p2p.user.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.*;
import com.peanut.p2p.user.model.entity.UserInfo;

import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
@RepositoryProxy("UserInfoDao")
public interface UserInfoDao extends IBaseDao {
    @Update("update UserInfo set act_status='0' where id= :id")
    public int doUpdate(@Param("id") Integer id);

    @Query("from UserInfo u ")
    @ReturnType(UserInfo.class)
    public List<UserInfo> findUserName();
}
