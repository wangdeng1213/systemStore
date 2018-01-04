package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.ActualRepaymentPlan;

/**
 * Created by my on 2015/4/11.
 */
public interface ActualRepaymentPlanService {

    ActualRepaymentPlan queryByID(Integer id);

    void doSave(ActualRepaymentPlan actualRepayment);

    void doUpdate(ActualRepaymentPlan actualRepayment);

    void doUpdate(Integer id);
    void doDelete(Integer id);
}
