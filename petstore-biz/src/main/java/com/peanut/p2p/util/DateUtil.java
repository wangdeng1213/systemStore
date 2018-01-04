package com.peanut.p2p.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by my on 2015/6/10.
 * date工具类
 */
public class DateUtil {
    //时间加天数
    public static Timestamp addDate(Timestamp d,long day) throws ParseException {

        long time = d.getTime();
        day = day*24*60*60*1000;
        time+=day;
        return new Timestamp(time);
    }
    /**
     * 返回指定格式日期字符串
     * @param fmt 格式化字符串
     * @param date 日期格式字符串
     * @param num 针对系统当前月份增加或减去一个值
     * @return
     */
    public static String getMonthToStr(String fmt,String date,int num){
        String dateStr=null;
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date date2 = null;
        try {
            date2 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date2);
        cal.add(Calendar.MONTH,num);
        dateStr=sdf.format(cal.getTime());
        return dateStr;
    }
}
