package com.peanut.p2p.util;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2015/5/20.
 */
@SuppressWarnings("serial")
public class HelloInterfaceImpl extends UnicastRemoteObject implements HelloInterface{
    //HelloInterfaceImpl的构造方法 用于抛出UnicastRemoteObject 远程对象里的异常
     public HelloInterfaceImpl() throws RemoteException {
     }
     public String sayHello(String name) throws RemoteException {
    // 该信息 在客户端上发出
       String strHello = "你好! " + name+" 欢迎访问服务器!";
    // 这条信息 是在服务器上 打印出来
     System.out.println(name +" 正在 访问本服务器!");
         return strHello;
     }
}
