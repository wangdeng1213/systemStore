package com.peanut.p2p.user.service;


import com.peanut.p2p.user.model.entity.UserRepayment;

/**
 * Created by my on 2015/2/5.
 */
public interface UserRepaymentService{
    UserRepayment queryByID(Integer id);

    void doSave(UserRepayment userRepayment);

    void doUpdate(UserRepayment userRepayment);

    void doDelete(Integer id);
}
