package com.peanut.p2p.util;

import com.peanut.p2p.products.model.entity.Product;
import com.peanut.p2p.products.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by my on 2015/4/13.
 */


public class MyDateTask  {
    /*
    记录日志
    * */
    private static Log logger = LogFactory.getLog(MyDateTask.class);
    /*创建集合*/
    private static LinkedBlockingQueue<Map> queue = new LinkedBlockingQueue<Map>();

    private Timer timer;

   /* protected TimerTask(){
       //Timestamp startDate = (Timestamp) map.get("startDate");
       //Timestamp endDate = (Timestamp) map.get("endDate");
       timer.schedule(new MyDateTask(),startDate);//安排在指定的时间执行指定的任务。
       timer.schedule(new MyDateTask(),endDate);//安排在指定的时间执行指定的任务
    }*/

    /*需要传进来的参数startDate*/
    public static void get(Integer productId,Timestamp startDate,Timestamp endDate) {

        Map m = new HashMap();
        m.put("productId",productId);
        m.put("startDate", startDate);
        m.put("endDate", endDate);
        queue.add(m);
        logger.info("MyDateTask get...+++++++++++"+queue);
    }



    public void run() {
                    logger.info("MyDateTask run...==============" + queue.size());
                    query();
                    Map map = new HashMap();
                    try {
                        for(int i=0;i<queue.size();i++){
                        map = queue.take();
                        triggerStartDate(map);
                        triggerEndDate(map);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


        }
    //查询所有的标的信息
    private void query() {
        Timestamp startDate = null;
        Timestamp endDate = null;
        String sql = "select * from transfer t where to_days(t.start_time) = to_days(now()) ";
        Connection conn = JDBC.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer productId = Integer.valueOf(rs.getString("product_id"));
                startDate = Timestamp.valueOf(rs.getString("start_time"));
                endDate = Timestamp.valueOf(rs.getString("end_time"));
                MyDateTask.get(productId, startDate, endDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*触发数据库字段*/
    private  void triggerEndDate(Map m) {
        try {
            Integer id = (Integer) m.get("productId");
             /*得到投标结束时间*/
            Timestamp endDate = (Timestamp) m.get("endDate");

            logger.info("MyDateTask trigger endTime..." + id);
            /*设置状态值为满标*/
            String sql1 = "update product p set p.status_code = 2 where p.product_id = " + id;
            Connection conn1 = JDBC.getConn();
            PreparedStatement pt1 = null;
            try {
                pt1 = conn1.prepareStatement(sql1);
                pt1.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            logger.info("MyDateTask trigger endTime failure...-------------" + id);
            }
        }finally {
            logger.info("MyDateTask trigger endTime failure...-------------" );
        }
    }
    /*触发数据库字段*/
    private  void triggerStartDate(Map m)  {
        try{
            /*得到投资开始时间*/
            Timestamp startDate = (Timestamp) m.get("startDate");
            Integer id = (Integer)m.get("productId");
            logger.info("MyDateTask trigger startTime..." + id);
             /*设置状态值为投标中*/

             /*修改*/
            String sql = "update product p set p.status_code = 1 where p.product_id = "+ id;
            Connection conn = JDBC.getConn();
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.execute();
            logger.info("MyDateTask trigger startTime success...-------------" + id);
        }catch (Throwable e){
            logger.error("MyDateTask trigger startTime failure", e);
        }
    }

}