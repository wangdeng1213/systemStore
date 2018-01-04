package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.ReturnType;
import com.peanut.p2p.products.model.entity.Shcl;

/**
 * Created by my
 */
@RepositoryProxy("shclDao")
public interface ShclDao extends IBaseDao {
    @NativeQuery("SELECT id,picids picId,shyj,shzt FROM shcl WHERE id IN (SELECT MAX(id) id FROM shcl GROUP BY picid) AND picId = ?")
    @ReturnType(Shcl.class)
    public Shcl findByPicId(Long picId);

}
