package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.Search_stockDao;
import com.peanut.p2p.products.model.entity.Search_stock;
import com.peanut.p2p.products.service.Search_stockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("search_stockService")
public class Search_stockServiceImpl implements Search_stockService {

    @Resource
    private Search_stockDao realsearchstockDao;

    @Override
    public Search_stock queryByID(String id) {
        return realsearchstockDao.findByPId(id);
    }

    @Override
    public void doSave(Search_stock szproduct) {
        realsearchstockDao.save(szproduct);
    }

    @Override
    public void doUpdate(Search_stock szproduct) {
        realsearchstockDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        realsearchstockDao.delete(id);
    }

}
