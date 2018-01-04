package com.peanut.p2p.user.service;

import com.peanut.p2p.user.model.entity.LoanApply;

/**
 * Created by my on 2015/7/6.
 */
public interface LoanApplyService {
    LoanApply queryById(Integer id);

    void doUpdate(Integer id);
}
