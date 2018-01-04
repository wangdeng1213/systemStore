/**
 * Copyright com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.pagination.service.impl;

import com.peanut.data.orm.dao.impl.BaseDao;
import com.peanut.data.query.component.QueryInfo;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.pagination.page.Page;
import com.peanut.pagination.pageFactory.PageFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 安文涛
 * @version 1.0
 */
@Service("pageService")
public class PageServiceImpl implements PageService {
    @Resource
    private BaseDao baseDao;

    @Override
    public <T> Page<T> queryAll(Class<T> clazz, int pageSize, int pageNum) {
        List<T> list = baseDao.findAll(clazz);
        return getSearchedListPage(list, pageSize, pageNum);
    }

    @Override
    public <T> Page<T> queryAllUseDefaultPageSize(Class<T> clazz, int pageNum) {
        List<T> list = baseDao.findAll(clazz);
        return getDefaultPageSizeSearchedListPage(list, pageNum);
    }

    @Override
    public <T> Page<T> queryPage(QueryInfo queryInfo) {
        queryInfo.setOffSet(true);
        queryInfo.setUseCache(true);

        long totalCount = baseDao.getCountByQueryInfo(queryInfo);
        Page<T> page = PageFactory.createPage(queryInfo.getMaxResult(),
                queryInfo.getPageNum(), totalCount);

        queryInfo.setFirstResult(page.getPageContext().getFirstResult(page));

        List<T> records = baseDao.findEntitiesByQueryInfo(queryInfo);
        page.setRecords(records);

        return page;
    }

    @Override
    public <T> Page<T> queryDefaultPageSizePage(QueryInfo queryInfo) {
        queryInfo.setOffSet(true);
        queryInfo.setUseCache(true);

        long totalCount = baseDao.getCountByQueryInfo(queryInfo);
        Page<T> page = PageFactory.createPage(queryInfo.getPageNum(),
                totalCount);

        queryInfo.setFirstResult(page.getPageContext().getFirstResult(page));
        queryInfo.setMaxResult(page.getPageSize());

        List<T> records = baseDao.findEntitiesByQueryInfo(queryInfo);
        page.setRecords(records);

        return page;
    }

    @Override
    public <T> Page<T> getSearchedListPage(List<T> searchedRecords,
                                           int pageSize, int pageNum) {
        Page<T> page = PageFactory.createSearchedAllListPage(pageSize, pageNum,
                searchedRecords);
        return page;
    }

    @Override
    public <T> Page<T> getDefaultPageSizeSearchedListPage(
            List<T> searchedRecords, int pageNum) {
        Page<T> page = PageFactory.createSearchedAllListPage(pageNum,
                searchedRecords);
        return page;
    }

    @Override
    public <T> List<T> queryDefaultListSize(QueryInfo queryInfo) {
        List<T> records = baseDao.findEntitiesByQueryInfo(queryInfo);
        return records;
    }
}