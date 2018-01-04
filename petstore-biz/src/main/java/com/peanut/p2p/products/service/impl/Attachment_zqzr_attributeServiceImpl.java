package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.Attachment_zqzr_attributeDao;
import com.peanut.p2p.products.model.entity.Attachment_zqzr_attribute;
import com.peanut.p2p.products.service.Attachment_zqzr_attributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("attachment_zqzr_attributeService")
public class Attachment_zqzr_attributeServiceImpl implements Attachment_zqzr_attributeService {

    @Resource
    private Attachment_zqzr_attributeDao attachment_zqzr_attributeDao;

    @Override
    public Attachment_zqzr_attribute queryByID(String id) {
        return attachment_zqzr_attributeDao.findById(Attachment_zqzr_attribute.class,id);
    }

    @Override
    public void doSave(Attachment_zqzr_attribute szproduct) {
        attachment_zqzr_attributeDao.save(szproduct);
    }

    @Override
    public void doUpdate(Attachment_zqzr_attribute szproduct) {
        attachment_zqzr_attributeDao.update(szproduct);
    }

    @Override
    public void doDelete(Integer id) {
        attachment_zqzr_attributeDao.delete(id);
    }

}
