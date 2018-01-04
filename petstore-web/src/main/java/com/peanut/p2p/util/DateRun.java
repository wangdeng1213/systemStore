package com.peanut.p2p.util;

import com.peanut.p2p.products.TransferController;
import com.peanut.p2p.products.dao.TransferDao;
import com.peanut.p2p.products.model.entity.Transfer;
import com.peanut.p2p.products.service.ProductService;
import com.peanut.p2p.products.service.TransferService;
import com.peanut.p2p.products.service.impl.TransferServiceImpl;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * Created by my on 2015/4/13.
 */
public class DateRun implements ServletContextListener {

    private Timer timer = null;

    private TransferController transferController = new TransferController();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

          /*  List<Transfer> transfers = transferController.queryAll();
            for(int i=0;i<transfers.size();i++){
                Integer id = Integer.valueOf(transfers.get(i).getProductId());
                Timestamp startDate = transfers.get(i).getStartTime();
                MyDateTask.get(id, startDate);
            }*/



    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
       // new MyDateTask().destroy();
    }
}
