package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.CreditInfoDao;
import com.peanut.p2p.code.model.entity.CreditInfo;
import com.peanut.p2p.code.service.CreditInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("creditInfoService")
public class CreditInfoServiceImpl implements CreditInfoService {

    @Resource
    private CreditInfoDao creditInfoDao;
    @Override
    public List<CreditInfo>queryAll(){return  creditInfoDao.findAll(CreditInfo.class);}
    @Override
    public CreditInfo queryByID(Integer id) {
        return creditInfoDao.findById(CreditInfo.class,id);
    }

    @Override
    public void doSave(CreditInfo szCreditInfo) {
        creditInfoDao.save(szCreditInfo);
    }

    @Override
    public void doUpdate(CreditInfo szCreditInfo) {
        creditInfoDao.update(szCreditInfo);
    }

    @Override
    public void doDelete(Integer id) {
        CreditInfo CreditInfo = creditInfoDao.findById(CreditInfo.class,id);
        creditInfoDao.delete(CreditInfo);
    }

    @Override
    public void doUpdate(Integer id) {
        creditInfoDao.update(id);
    }

}
