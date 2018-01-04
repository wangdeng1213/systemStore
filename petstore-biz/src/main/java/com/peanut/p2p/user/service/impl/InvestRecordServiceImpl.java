package com.peanut.p2p.user.service.impl;

import com.peanut.p2p.user.dao.VInvestRecordDao;
import com.peanut.p2p.user.model.entity.InvestRecord;
import com.peanut.p2p.user.model.entity.VInvestRecord;
import com.peanut.p2p.user.service.InvestRecordService;
import com.peanut.p2p.user.dao.InvestRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my on 2015/2/6.
 */
@Service("investRecordService")
public class InvestRecordServiceImpl implements InvestRecordService {
    @Resource
    private InvestRecordDao investRecordDao;
    @Resource
    private VInvestRecordDao vInvestRecordDao;

    @Override
    public InvestRecord queryByID(Integer id) {
        return
                investRecordDao.findById(InvestRecord.class, id);
    }

    @Override
    public void doSave(InvestRecord investRecord) {
        investRecordDao.save(investRecord);
    }

    @Override
    public void doUpdate(InvestRecord investRecord) {
        investRecordDao.update(investRecord);
    }

    @Override
    public void doUpdate(Integer id) {
        investRecordDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {

        InvestRecord investRecord = investRecordDao.findById(InvestRecord.class,id);
        investRecordDao.delete(investRecord);
    }

    @Override
    public List<VInvestRecord> query() {
        return vInvestRecordDao.findAll(VInvestRecord.class);
    }

    @Override
    public List<InvestRecord> queryByPID(String id) {
        return investRecordDao.findByPID(id);
    }


}
