/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.pagination.service;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.pagination.page.Page;

import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
public interface PageService {
    <T> Page<T> queryAll(Class<T> clazz, int pageSize, int pageNum);

    <T> Page<T> queryAllUseDefaultPageSize(Class<T> clazz, int pageNum);

    <T> Page<T> queryPage(QueryInfo queryInfo);

    <T> Page<T> queryDefaultPageSizePage(QueryInfo queryInfo);

    <T> Page<T> getSearchedListPage(List<T> searchedRecords, int pageSize,
                                    int pageNum);

    <T> Page<T> getDefaultPageSizeSearchedListPage(List<T> searchedRecords,
                                                   int pageNum);
    <T> List<T> queryDefaultListSize(QueryInfo queryInfo);
}