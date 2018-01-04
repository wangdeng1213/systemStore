package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.Repayment_plan_relationshipDao;
import com.peanut.p2p.products.model.entity.Repayment_plan_relationship;
import com.peanut.p2p.products.service.Repayment_plan_relationshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("repayment_plan_relationshipService")
public class Repayment_plan_relationshipServiceImpl implements Repayment_plan_relationshipService {

    @Resource
    private Repayment_plan_relationshipDao repaymentplanDao;

    @Override
    public Repayment_plan_relationship queryByID(Integer id) {
        return repaymentplanDao.findById(Repayment_plan_relationship.class,id);
    }

    @Override
    public void doSave(Repayment_plan_relationship szproduct) {
        repaymentplanDao.save(szproduct);
    }

    @Override
    public void doUpdate(Repayment_plan_relationship szproduct) {
        repaymentplanDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        repaymentplanDao.delete(id);
    }

}
