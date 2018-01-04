package com.peanut.p2p.transaction.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.ReturnType;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.transaction.model.entity.Order_info;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("order_infoDao")
public interface Order_infoDao extends IBaseDao {

}
