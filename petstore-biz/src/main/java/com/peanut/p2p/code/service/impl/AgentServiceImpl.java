package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.AgentDao;
import com.peanut.p2p.code.model.entity.Agent;
import com.peanut.p2p.code.service.AgentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("agentService")
public class AgentServiceImpl implements AgentService {

    @Resource
    private AgentDao agentDao;
    @Override
    public List<Agent>queryAll(){
        return  agentDao.findAll();
    }
    @Override
    public Agent queryByID(Integer id) {
        return agentDao.findById(Agent.class,id);
    }

    @Override
    public Agent queryByUserID(Integer id) {
        return agentDao.findByUserId(id);
    }

    @Override
    public void doSave(Agent szagent) {
        agentDao.save(szagent);
    }

    @Override
    public void doUpdate(Agent szagent) {
        agentDao.update(szagent);
    }

    @Override
    public void doUpdate(Integer id) {
        agentDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {
        Agent agent = agentDao.findById(Agent.class,id);
        agentDao.delete(agent);
    }

}
