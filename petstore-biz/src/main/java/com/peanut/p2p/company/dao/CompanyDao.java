/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.company.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.orm.jpql.expression.atomic.enums.OrderType;
import com.peanut.data.query.anotation.*;
import com.peanut.data.query.enums.GenericOperator;
import com.peanut.data.query.enums.LogicType;
import com.peanut.p2p.company.model.entity.Company;
import com.peanut.pagination.page.Page;

import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@RepositoryProxy("companyDao")
public interface CompanyDao extends IBaseDao {
    @NativeQuery("select * from test_company com where {com.id = ? and} com.name = ?")
    @ReturnType(Company.class)
    List<Company> getCompaniesByName(String name);

    @NativeQuery("select * from company com where com.email = ? and com.name = ?")
    @ReturnType(Company.class)
    List<Company> getCompanies(@Position(2) String name,
                               @Position(1) String email);

    @Query("from Company com where com.name =:name")
    Company getCompanyByName(@Param("name") String name);

    @Query("from Company com where com.name =:name")
    Page<Company> getCompanyPageByName(@Param("name") String name,
                                       @PageSize int pageSize, @PageNum int pageNum);

    @QueryEntity(entityClazz = Company.class, alias = "com")
    @Sort(fields = "name", orderTypes = OrderType.desc)
    List<Company> getCompaniesByNameAndEmail(
            @QueryField(name = "name", logicType = LogicType.and, genericOperator = GenericOperator.LIKE) String name,
            @QueryField(name = "email", logicType = LogicType.and, genericOperator = GenericOperator.LIKE) String email);

    @Query("from Company")
    List<Company> getAllCompanies();
}