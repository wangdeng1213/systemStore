package com.peanut.p2p.customer.lender_info.service.impl;

import com.peanut.p2p.customer.lender_info.dao.Lender_infoDao;
import com.peanut.p2p.customer.lender_info.model.entity.Lender_info;
import com.peanut.p2p.customer.lender_info.service.Lender_infoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("lender_infoService")
public class Lender_infoServiceImpl implements Lender_infoService {

    @Resource
    private Lender_infoDao lender_infoDao;

    @Override
    public Lender_info queryByID(Integer id) {
        return lender_infoDao.findById(Lender_info.class,id);
    }

    @Override
    public void doSave(Lender_info szproduct) {
        lender_infoDao.save(szproduct);
    }

    @Override
    public void doUpdate(Lender_info szproduct) {
        lender_infoDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        lender_infoDao.delete(id);
    }

}
