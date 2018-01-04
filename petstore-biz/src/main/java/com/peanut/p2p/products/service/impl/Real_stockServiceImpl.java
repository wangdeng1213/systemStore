package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.Real_stockDao;
import com.peanut.p2p.products.model.entity.Real_stock;
import com.peanut.p2p.products.service.Real_stockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("real_stockService")
public class Real_stockServiceImpl implements Real_stockService {

    @Resource
    private Real_stockDao real_stockDao;

    @Override
    public Real_stock queryByPID(String id) {
        return real_stockDao.findByPId(id);
    }

    @Override
    public void doSave(Real_stock szproduct) {
        real_stockDao.save(szproduct);
    }

    @Override
    public void doUpdate(Real_stock szproduct) {
        real_stockDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        real_stockDao.delete(id);
    }

}
