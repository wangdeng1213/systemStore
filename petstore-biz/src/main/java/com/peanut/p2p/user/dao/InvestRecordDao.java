package com.peanut.p2p.user.dao;


import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.NativeQuery;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.ReturnType;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.user.model.entity.InvestRecord;

import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
@RepositoryProxy("investRecordDao")
public interface InvestRecordDao extends IBaseDao {
    @Update("update InvestRecord set act_status='0' where id= :id")
    public int update(@Param("id") Integer id);
    @NativeQuery("SELECT * FROM invest_record ir WHERE ir.act_status= 1 AND ir.product_id = :id")
    @ReturnType(InvestRecord.class)
    List<InvestRecord> findByPID(@Param("id") String id);
}
