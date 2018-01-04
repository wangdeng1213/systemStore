package com.peanut.p2p.code.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.Param;
import com.peanut.data.query.anotation.Query;
import com.peanut.data.query.anotation.Update;
import com.peanut.p2p.code.model.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("agentDao")
public interface AgentDao extends IBaseDao {

    @Update("update Agent set status='0' where id= :id")
    public int update(@Param("id") Integer id);

    @Query("from Agent where status='1'")
    public List<Agent> findAll();

    @Query("from Agent where status='1' and userId = :id")
    Agent findByUserId(@Param("id") Integer id);
}
