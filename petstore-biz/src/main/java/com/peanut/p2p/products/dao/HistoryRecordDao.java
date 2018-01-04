package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.ReturnType;
import com.peanut.p2p.products.model.entity.Shcl;

/**
 * Created by my
 */
@RepositoryProxy("historyRecordDao")
public interface HistoryRecordDao extends IBaseDao {


}
