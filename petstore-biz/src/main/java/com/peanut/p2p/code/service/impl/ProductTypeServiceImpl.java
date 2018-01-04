package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.PeriodDao;
import com.peanut.p2p.code.dao.ProductTypeDao;
import com.peanut.p2p.code.model.entity.Period;
import com.peanut.p2p.code.model.entity.ProductType;
import com.peanut.p2p.code.service.PeriodService;
import com.peanut.p2p.code.service.ProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by my
 */
@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

   @Resource
   private ProductTypeDao productTypeDao;
    @Override
    public List<ProductType> queryAll() {
        return productTypeDao.findAll(ProductType.class);
    }

    @Override
    public ProductType queryByID(Integer id) {
        return productTypeDao.findById(ProductType.class,id);
    }

    @Override
    public void doSave(ProductType productType) {
        productTypeDao.save(productType);
    }

    @Override
    public void doUpdate(ProductType productType) {
        productTypeDao.update(productType);
    }

    @Override
    public void doDelete(Integer id) {
        ProductType productType = productTypeDao.findById(ProductType.class,id);
        productTypeDao.delete(productType);
    }

    @Override
    public void doUpdate(Integer id) {
        productTypeDao.update(id);
    }
}
