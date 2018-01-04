package com.peanut.p2p.products.service.impl;

import com.peanut.p2p.products.dao.BoRepaymentDetailDao;
import com.peanut.p2p.products.model.entity.BoRepaymentDetail;
import com.peanut.p2p.products.service.BoRepaymentDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("boRepaymentDetailService")
public class BoRepaymentDetailServiceImpl implements BoRepaymentDetailService {

    @Resource
    private BoRepaymentDetailDao repayment_planDao;

    @Override
    public BoRepaymentDetail queryByID(Integer id) {
        return repayment_planDao.findById(BoRepaymentDetail.class, id);
    }

    @Override
    public void doSave(BoRepaymentDetail szproduct) {
        repayment_planDao.save(szproduct);

    }

    @Override
    public void doUpdate(BoRepaymentDetail szproduct) {
        repayment_planDao.update(szproduct);
    }

    @Override
    public void doUpdate(Integer id) {
        repayment_planDao.update(id);
    }

    @Override
    public void doDelete(Integer id) {
        repayment_planDao.delete(id);
    }

    @Override
    public List<BoRepaymentDetail> findByProductId(Integer id) {
        return repayment_planDao.findByProductId(id);
    }

}
