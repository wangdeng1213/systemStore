/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.company.service.impl;

import com.peanut.p2p.company.dao.CompanyDao;
import com.peanut.p2p.company.model.entity.Company;
import com.peanut.p2p.company.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wentao.awt on 2014/11/30.
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyDao companyDao;

    @Override
    public Company queryByID(long id) {
        return
                companyDao.findById(Company.class, id);
    }

    @Override
    public void doSave(Company company) {
        companyDao.save(company);
    }

    @Override
    public void doUpdate(Company company) {
        companyDao.update(company);
    }

    @Override
    public void doDelete(long id) {
        companyDao.delete(id);
    }
}