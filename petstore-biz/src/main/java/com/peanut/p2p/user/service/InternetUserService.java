package com.peanut.p2p.user.service;

import com.peanut.p2p.user.model.entity.InternetUser;
import com.peanut.p2p.user.model.entity.UserInfo;


/**
 * Created by my on 2015/2/5.
 */
public interface InternetUserService {
  //  InternetUser queryByID(Integer id);

 //   void doSave(InternetUser internetUser);

    void doUpdate(InternetUser internetUser);
    void doUpdate(UserInfo userInfo);

    void doUpdate(Integer id);

    InternetUser queryByID(Integer id);
}
