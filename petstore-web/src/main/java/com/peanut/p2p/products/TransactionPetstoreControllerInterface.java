package com.peanut.p2p.products;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lenovo on 2015/5/11.
 */
public interface TransactionPetstoreControllerInterface extends Remote {

   String pay(String id) throws RemoteException;
}
