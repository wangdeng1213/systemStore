package com.peanut.p2p.util;

/**
 * Created by my on 2015/6/15.
 */
public class XmlUtil {
    public static String registerXml(String platformUserNo,String nickName,String realName,String idCardNo,String mobile,String email,String notifyUrl,String callbackUrl){
     String req = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <request platformNo=\"10040011137\"> <platformUserNo>"+platformUserNo+"</platformUserNo> <nickName>"+nickName+"</nickName> <realName>"+realName+"</realName> <idCardType>G2_IDCARD</idCardType> <idCardNo>"+idCardNo+"</idCardNo> <mobile>"+mobile+"</mobile> <email>"+email+"</email> <notifyUrl>"+notifyUrl+"</notifyUrl> <callbackUrl>"+callbackUrl+"</callbackUrl> </request>";
        return req;
    }
}
