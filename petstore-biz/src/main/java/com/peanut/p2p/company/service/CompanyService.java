/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.company.service;

import com.peanut.p2p.company.model.entity.Company;

/**
 * Created by wentao.awt on 2014/11/30.
 */
public interface CompanyService {
    Company queryByID(long id);

    void doSave(Company company);

    void doUpdate(Company company);

    void doDelete(long id);
}
