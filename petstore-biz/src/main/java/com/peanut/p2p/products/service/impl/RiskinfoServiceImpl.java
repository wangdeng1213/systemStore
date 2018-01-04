package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.RiskinfoDao;
import com.peanut.p2p.products.model.entity.Riskinfo;
import com.peanut.p2p.products.service.RiskinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("riskinfoService")
public class RiskinfoServiceImpl implements RiskinfoService {

    @Resource
    private RiskinfoDao riskinfoDao;
    @Override
    public List<Riskinfo>queryAll(){return  riskinfoDao.findAll();}
    @Override
    public Riskinfo queryByID(Long id) {
        return riskinfoDao.findById(Riskinfo.class,id);
    }

    @Override
    public void doSave(Riskinfo szriskinfo) {
        riskinfoDao.save(szriskinfo);
    }

    @Override
    public void doUpdate(Riskinfo szriskinfo) {
        riskinfoDao.update(szriskinfo);
    }

    @Override
    public void doUpdate(Long id) {
        riskinfoDao.update(id);
    }

    @Override
    public void doDelete(Long id) {
        Riskinfo riskinfo = riskinfoDao.findById(Riskinfo.class,id);
        riskinfoDao.delete(riskinfo);
    }

}
