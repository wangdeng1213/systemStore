/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.code.service;

import com.peanut.p2p.code.model.entity.Agent;

import java.util.List;

/**
 * Created by weizhenkun.awt on 2014/11/30.
 */
public interface AgentService {
    List<Agent> queryAll();
    Agent queryByID(Integer id);

    Agent queryByUserID(Integer id);

    void doSave(Agent agent);

    void doUpdate(Agent agent);

    void doUpdate(Integer id);

    void doDelete(Integer id);

}
