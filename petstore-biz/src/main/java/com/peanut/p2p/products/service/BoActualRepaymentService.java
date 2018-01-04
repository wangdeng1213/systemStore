package com.peanut.p2p.products.service;

import com.peanut.p2p.products.model.entity.BoActualRepayment;

/**
 * Created by Administrator on 2015/4/11.
 */
public interface BoActualRepaymentService {

    BoActualRepayment queryByID(Integer actual_repayment_id);

    void doSave(BoActualRepayment actualRepayment);

    void doUpdate(BoActualRepayment actualRepayment);


    void doDelete(Integer actual_repayment_id);
}
