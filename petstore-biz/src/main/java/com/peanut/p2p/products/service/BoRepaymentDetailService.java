/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.products.service;


import com.peanut.p2p.products.model.entity.BoRepaymentDetail;

import java.util.List;

/**
 * Created by my
 */
public interface BoRepaymentDetailService {
    BoRepaymentDetail queryByID(Integer id);

    void doSave(BoRepaymentDetail investorinfo);

    void doUpdate(BoRepaymentDetail investorinfo);

    void doUpdate(Integer id);

    void doDelete(Integer id);

    List<BoRepaymentDetail> findByProductId(Integer id);
}
