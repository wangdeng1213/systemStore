package com.peanut.p2p.user.service;

import com.peanut.p2p.user.model.entity.InvestRecord;
import com.peanut.p2p.user.model.entity.UserPrivilege;
import com.peanut.p2p.user.model.entity.VInvestRecord;

import java.util.List;

/**
 * Created by my on 2015/2/5.
 */
public interface InvestRecordService {
    InvestRecord queryByID(Integer id);

    void doSave(InvestRecord investRecord);

    void doUpdate(InvestRecord investRecord);

    void doUpdate(Integer id);

    void doDelete(Integer id);

    List<VInvestRecord> query();

    List<InvestRecord> queryByPID(String id);

}
