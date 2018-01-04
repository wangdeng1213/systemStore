package com.peanut.p2p.transaction.service.impl;

import com.peanut.p2p.transaction.dao.Order_infoDao;
import com.peanut.p2p.transaction.model.entity.Order_info;
import com.peanut.p2p.transaction.service.Order_infoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("order_infoService")
public class Order_infoServiceImpl implements Order_infoService {

    @Resource
    private Order_infoDao order_infoDao;

    @Override
    public Order_info queryByID(Integer id) {
        return order_infoDao.findById(Order_info.class,id);
    }

    @Override
    public void doSave(Order_info order_info) {
        order_infoDao.save(order_info);
    }

    @Override
    public void doUpdate(Order_info order_info) {
        order_infoDao.update(order_info);
    }

    @Override
    public void doDelete(Integer id) {
        Order_info oi = queryByID(id);
        order_infoDao.delete(oi);
    }


}
