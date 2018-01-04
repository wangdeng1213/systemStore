package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.PeriodDao;
import com.peanut.p2p.code.model.entity.Period;
import com.peanut.p2p.code.service.PeriodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("periodService")
public class PeriodServiceImpl implements PeriodService {

    @Resource
    private PeriodDao periodDao;
    @Override
    public List<Period>queryAll(){return  periodDao.findAll(Period.class);}
    @Override
    public Period queryByID(Integer id) {
        return periodDao.findById(Period.class,id);
    }

    @Override
    public void doSave(Period period) {
        periodDao.save(period);
    }

    @Override
    public void doUpdate(Period period) {
        periodDao.update(period);
    }

    @Override
    public void doUpdate(Integer id) {
        periodDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {
        Period period = periodDao.findById(Period.class,id);
        periodDao.delete(period);
    }

}
