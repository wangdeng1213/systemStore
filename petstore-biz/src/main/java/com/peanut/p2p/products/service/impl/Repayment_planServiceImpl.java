package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.Repayment_planDao;
import com.peanut.p2p.products.model.entity.Repayment_plan;
import com.peanut.p2p.products.service.Repayment_planService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("repayment_planService")
public class Repayment_planServiceImpl implements Repayment_planService {

    @Resource
    private Repayment_planDao repayment_planDao;

    @Override
    public Repayment_plan queryByID(Integer id) {
        return repayment_planDao.findById(Repayment_plan.class,id);
    }

    @Override
    public void doSave(Repayment_plan szproduct) {
        repayment_planDao.save(szproduct);
    }

    @Override
    public void doUpdate(Repayment_plan szproduct) {
        repayment_planDao.update(szproduct);
    }

    @Override
    public void doUpdate(Integer id) {
        repayment_planDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {
        Repayment_plan rp =queryByID(id);
        repayment_planDao.delete(rp);
    }

}
