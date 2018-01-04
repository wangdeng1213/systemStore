/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.security.service;


import com.peanut.p2p.security.model.entity.SysLog;

import java.util.List;

/**
 * Created by my
 */
public interface SysLogService {
    List<SysLog> queryAll();

    SysLog queryByID(Long id);

    void doSave(SysLog sysLog);

    void doUpdate(Integer id);

}
