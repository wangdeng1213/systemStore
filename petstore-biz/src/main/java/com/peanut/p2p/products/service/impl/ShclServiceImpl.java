package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.ShclDao;
import com.peanut.p2p.products.model.entity.Shcl;
import com.peanut.p2p.products.service.ShclService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("shclService")
public class ShclServiceImpl implements ShclService {

    @Resource
    private ShclDao shclDao;
    @Override
    public List<Shcl>queryAll(){return  shclDao.findAll(Shcl.class);}
    @Override
    public Shcl queryByID(Long id) {
        return shclDao.findById(Shcl.class,id);
    }

    @Override
    public void doSave(Shcl szShcl) {
        shclDao.save(szShcl);
    }

    @Override
    public void doUpdate(Shcl szShcl) {
        shclDao.update(szShcl);
    }

    @Override
    public void doDelete(Integer id) {
        Shcl Shcl = shclDao.findById(Shcl.class,id);
        shclDao.delete(Shcl);
    }

    @Override
    public Shcl queryByPicId(Long picId) {
        Shcl shcl =  shclDao.findByPicId(picId);
        if(null == shcl || ("").equals(shcl)){
            return null;
        }
        return shcl;
    }

}
