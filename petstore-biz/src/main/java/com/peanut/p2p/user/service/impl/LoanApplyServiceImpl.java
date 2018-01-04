package com.peanut.p2p.user.service.impl;

import com.peanut.p2p.user.dao.LoanApplyDao;
import com.peanut.p2p.user.model.entity.LoanApply;
import com.peanut.p2p.user.service.LoanApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by my on 2015/7/6.
 */
@Service("loanApplyService")
public class LoanApplyServiceImpl implements LoanApplyService{

    @Resource
    private LoanApplyDao loanApplyDao;
    @Override
    public LoanApply queryById(Integer id) {
        return loanApplyDao.findById(LoanApply.class,id);
    }

    @Override
    public void doUpdate(Integer id) {
        //loanApplyDao.u
    }
}
