package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.EnsureTypeDao;
import com.peanut.p2p.code.model.entity.EnsureType;
import com.peanut.p2p.code.service.EnsureTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("ensureTypeService")
public class EnsureTypeServiceImpl implements EnsureTypeService {

    @Resource
    private EnsureTypeDao ensureTypeDao;
    @Override
    public List<EnsureType>queryAll(){return  ensureTypeDao.findAll();}
    @Override
    public EnsureType queryByID(Integer id) {
        return ensureTypeDao.findById(EnsureType.class,id);
    }

    @Override
    public void doSave(EnsureType ensureType) {
        ensureTypeDao.save(ensureType);
    }

    @Override
    public void doUpdate(EnsureType ensureType) {
        ensureTypeDao.update(ensureType);
    }

    @Override
    public void doDelete(Integer id) {
        EnsureType ensureType = ensureTypeDao.findById(EnsureType.class,id);
        ensureTypeDao.delete(ensureType);
    }

    @Override
    public void doUpdate(Integer id) {
        ensureTypeDao.update(id);
    }

}
