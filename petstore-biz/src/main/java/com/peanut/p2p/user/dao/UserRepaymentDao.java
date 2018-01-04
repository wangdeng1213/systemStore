package com.peanut.p2p.user.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import org.springframework.stereotype.Repository;

/**
 * Created by my on 2015/2/8.
 */
@RepositoryProxy("userRepaymentDao")
public interface UserRepaymentDao extends IBaseDao {
}
