package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.Few_zqzr_attributeDao;
import com.peanut.p2p.products.model.entity.Few_zqzr_attribute;
import com.peanut.p2p.products.service.Few_zqzr_attributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("few_zqzr_attributeService")
public class Few_zqzr_attributeServiceImpl implements Few_zqzr_attributeService {

    @Resource
    private Few_zqzr_attributeDao few_zqzr_attributeDao;

    @Override
    public Few_zqzr_attribute queryByID(String id) {
        return few_zqzr_attributeDao.findById(Few_zqzr_attribute.class,id);
    }

    @Override
    public void doSave(Few_zqzr_attribute szproduct) {
        few_zqzr_attributeDao.save(szproduct);
    }

    @Override
    public void doUpdate(Few_zqzr_attribute szproduct) {
        few_zqzr_attributeDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        few_zqzr_attributeDao.delete(id);
    }

}
