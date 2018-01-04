package com.peanut.p2p.user.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Update;


/**
 * Created by my on 2015/2/5.
 */
@RepositoryProxy("userPrivilegeDao")
public interface UserPrivilegeDao extends IBaseDao {
//    @NativeQuery("SELECT * FROM user_privilege up WHERE (up.privilege_id = ? and) up.level_no = ? ")
//    @ReturnType(UserPrivilege.class)
//    List<UserPrivilege> getPrivilegeByLevel(Integer level);
//    @NativeQuery("select * from user_privilege up where up.level_no = ? and up.credit = ?")
//    @ReturnType(UserPrivilege.class)
//    List<UserPrivilege> getPrivileges(@Position(2) String credit,
//                                      @Position(1) Integer level);
    @Update("delete from UserPrivilege where id = :id")
    public int delete(@Param("id") Integer id);
}
