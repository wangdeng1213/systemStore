package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.HistoryRecordDao;
import com.peanut.p2p.products.dao.ProductDao;
import com.peanut.p2p.products.model.entity.HistoryRecord;
import com.peanut.p2p.products.model.entity.Transfer;
import com.peanut.p2p.products.service.TransferService;
import com.peanut.security.realm.entity.user.User;
import com.peanut.security.springSecurity.utils.AuthUtils;
import org.springframework.stereotype.Service;
import com.peanut.p2p.products.dao.TransferDao;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {

    @Resource
    private TransferDao transfer_Dao;
    @Resource
    private HistoryRecordDao historyRecordDao;
    @Resource
    private ProductDao productDao;

    @Override
    public Transfer queryByID(Integer id) {
        return transfer_Dao.findById(Transfer.class,id);
    }
    @Override
    public Transfer queryByPID(String pid) {
        return transfer_Dao.getByPid(pid);
    }
    @Override
    public void doSave(Transfer szproduct) {
        transfer_Dao.save(szproduct);
    }

    @Override
    public void doUpdate(Transfer szproduct) {
        transfer_Dao.update(szproduct);
    }
    //修改时间前先留存记录
    @Override
    @Transactional
    public void doUpdate(Long id,Timestamp endTime) {
        Transfer transfer = queryByPID(String.valueOf(id));
        Timestamp hisEndTime = transfer.getEndTime();
        User user = AuthUtils.getCurrentUser();
        Integer userId = user.getId();
        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setHisEndTime(hisEndTime);
        historyRecord.setNowEndTime(endTime);
        historyRecord.setUserId(userId);
        historyRecord.setProductId(id);
        historyRecordDao.save(historyRecord);
        String id2 = String.valueOf(id);
        transfer_Dao.update(id2,endTime);
        String enterStatus = "4";
        productDao.updateEnterS(enterStatus,id);
    }

    @Override
    public void doDelete(Integer id) {
        transfer_Dao.delete(id);
    }

    @Override
    public List<Transfer> queryAll() {
        return transfer_Dao.findAll(Transfer.class);
    }

}
