package com.peanut.p2p.util;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by my on 2015/6/16.
 */
public class ExcelToXml {
    private  OutputStream out;

    private  String encoding;

    public ExcelToXml(OutputStream out, String enc) {
        encoding = enc;
        this.out = out;
        if (encoding == null || !encoding.equals("UnicodeBig"))
        {
            encoding = "UTF-8";
        }
    }

    public  void generateXML(List<Map> filmList) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(out,encoding);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        bw.newLine();
        bw.write("<request platformNo=\"10040011137\">");
        bw.newLine();
        bw.write("<requestNo>req1234567</requestNo>");
        bw.newLine();
        bw.write("<platformUserNo>bhatest0004</platformUserNo>");
        bw.newLine();
        bw.write("<userType>MERCHANT</userType>");
        bw.newLine();
        bw.write("<bizType>TRANSFER</bizType>");
        bw.newLine();
        bw.write("<details>");
        bw.newLine();
        for(int i = 0;i< filmList.size();i++){
            bw.write("<detail>");
            bw.newLine();
            bw.write("<targetUserType>"+filmList.get(i).get("id")+"</targetUserType>");
            bw.newLine();
            bw.write("<targetPlatformUserNo>"+filmList.get(i).get("name")+"</targetPlatformUserNo>");
            bw.newLine();
            bw.write("<amount>"+filmList.get(i).get("amount")+"</amount>");
            bw.newLine();
            bw.write("<bizType>"+filmList.get(i).get("idCardNo")+"</bizType>");
            bw.newLine();
            bw.write("</detail>");
            bw.newLine();
        }
        bw.write("</details>");
        bw.newLine();
        bw.write("<notifyUrl>http://www.xxx.com/notify</notifyUrl>");
        bw.newLine();
        bw.write("</request>");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
