package com.peanut.p2p.security.service.impl;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.p2p.security.dao.SysLogDao;
import com.peanut.p2p.security.model.entity.SysLog;
import com.peanut.p2p.security.service.SysLogService;
import com.peanut.p2p.util.JDBC;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by my
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    private static final Log logger = LogFactory.getLog(SysLogServiceImpl.class);
    @Resource
    private SysLogDao sysLogDao;
    @Override
    public List<SysLog>queryAll(){return  sysLogDao.findAll(SysLog.class);}
    @Override
    public SysLog queryByID(Long id) {
        return sysLogDao.findById(SysLog.class,id);
    }

    @Override
    @Transactional
    public void doSave(SysLog sysLog) {
       // sysLogDao.save(sysLog);
        Connection conn  = JDBC.getConn();
        String sql = "insert into syslog(user,source,target,type,result,content,ip,loginid) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,sysLog.getUser());
            st.setString(2,sysLog.getSource());
            st.setString(3,sysLog.getTarget());
            st.setString(4,sysLog.getType());
            st.setString(5,sysLog.getResult());
            st.setString(6,sysLog.getContent());
            st.setString(7,sysLog.getIp());
            st.setInt(8,sysLog.getLoginid());
            int bo = st.executeUpdate();
            if(bo==1){
                logger.info(bo + "syslog save success ------");
            }else{
                logger.error(bo+"syslog save failure -------");
            }
            JDBC.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doUpdate(Integer id) {
        sysLogDao.update(id);
    }


}
