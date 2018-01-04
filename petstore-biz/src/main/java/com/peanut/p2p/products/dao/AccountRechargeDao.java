package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.ReturnType;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.products.model.entity.Product;

import java.util.List;

/**
 * Created by my on 2014/12/12.
 */
@RepositoryProxy("accountRechargeDao")
public interface AccountRechargeDao extends IBaseDao {

}
