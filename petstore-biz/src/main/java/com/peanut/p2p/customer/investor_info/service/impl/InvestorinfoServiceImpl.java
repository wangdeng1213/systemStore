package com.peanut.p2p.customer.investor_info.service.impl;

import com.peanut.p2p.customer.investor_info.dao.Investor_infoDao;
import com.peanut.p2p.customer.investor_info.model.entity.Investor_info;
import com.peanut.p2p.customer.investor_info.service.Investor_infoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("investor_infoService")
public class InvestorinfoServiceImpl implements Investor_infoService {

    @Resource
    private Investor_infoDao investor_infoDao;

    @Override
    public Investor_info queryByID(Integer id) {
        return investor_infoDao.findById(Investor_info.class,id);
    }

    @Override
    public void doSave(Investor_info szproduct) {
        investor_infoDao.save(szproduct);
    }

    @Override
    public void doUpdate(Investor_info szproduct) {
        investor_infoDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        investor_infoDao.delete(id);
    }

}
