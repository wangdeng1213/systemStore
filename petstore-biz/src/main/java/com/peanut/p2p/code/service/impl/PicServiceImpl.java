package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.PicDao;
import com.peanut.p2p.code.model.entity.Pic;
import com.peanut.p2p.code.service.PicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my on 2014/12/12.
 */
@Service("picService")
public class PicServiceImpl implements PicService {

    @Resource
    private PicDao picDao;
    @Override
    public List<Pic>queryAll(){return
            picDao.findAll(Pic.class);}
    @Override
    public Pic queryByID(Integer id) {
        return picDao.findById(Pic.class,id);
    }

    @Override
    public void doSave(Pic szPic) {
        picDao.save(szPic);
    }

    @Override
    public void doUpdate(Pic szPic) {
        picDao.update(szPic);
    }

    @Override
    public void doDelete(Integer id) {
        Pic Pic = picDao.findById(Pic.class,id);
        picDao.delete(Pic);
    }

}
