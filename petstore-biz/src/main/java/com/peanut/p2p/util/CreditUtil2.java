package com.peanut.p2p.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ln on 2015/5/20.
 */
public class CreditUtil2 {
    public  double payPerMonth(double payment, double ret, int num){
        double pay;
        double date = ret / 12 ;
        pay = (payment *date *Math.pow(1 + date, num) ) / (Math.pow(1 + date, num) -1);
        return pay;
    }
    public double payOverdue(double pay,double overdue){
        double payAmount;
        payAmount=(pay/30)*4*overdue;
        return payAmount;
    }
    //每月应还总额 金额，月综合费率，借款期数
    public BigDecimal payPerMonth(BigDecimal payment,BigDecimal ret,int num){
        BigDecimal pay;
        BigDecimal pay1=payment.multiply(ret);
        BigDecimal pay2=ret.add(new BigDecimal(1));
        BigDecimal pay3=pay2.pow(num);
        //分子
        BigDecimal pay4=pay1.multiply(pay3);
        //分母
        BigDecimal pay5=pay3.subtract(new BigDecimal(1));
        pay=pay4.divide(pay5,2, RoundingMode.HALF_DOWN);
        return pay;
    }
    public BigDecimal payOverdue(BigDecimal pay,Long overdue){
        BigDecimal payAmount;
        BigDecimal pay1=pay.divide(new BigDecimal(30),2,RoundingMode.HALF_DOWN);
        payAmount=pay1.multiply(new BigDecimal(4)).multiply(new BigDecimal(overdue));
        return payAmount;
    }
    public BigDecimal payFirstMonth(BigDecimal payment,BigDecimal ret,int num,BigDecimal manageFee){
        BigDecimal pay;
        BigDecimal pay1=payment.multiply(ret);
        BigDecimal pay2=ret.add(new BigDecimal(1));
        BigDecimal pay3=pay2.pow(num);
        //分子
        BigDecimal pay4=pay1.multiply(pay3);
        //分母
        BigDecimal pay5=pay3.subtract(new BigDecimal(1));
        pay=pay4.divide(pay5,2, RoundingMode.HALF_DOWN);
        BigDecimal pay6=new BigDecimal(num).divide(new BigDecimal(12),2,RoundingMode.HALF_DOWN);
        BigDecimal pay7=payment.multiply(manageFee);
                pay=pay.add(pay7);
        return pay;
    }
    //每个月的本金跟利息详情
    public Map<String,List<BigDecimal>> detail(BigDecimal payment,BigDecimal monthRate,BigDecimal payPerMonth,int term){
        BigDecimal principalFee= new BigDecimal(0);
        BigDecimal interestFee= new BigDecimal(0);
        List<BigDecimal> principalFees=new ArrayList<BigDecimal>();
        List<BigDecimal> interestFees=new ArrayList<BigDecimal>();
        for(int i=0;i<term;i++){
            interestFee=payment.multiply(monthRate);
            principalFee=payPerMonth.subtract(interestFee);
            payment=payment.subtract(principalFee);
            principalFees.add(principalFee);
            interestFees.add(interestFee);
        }
        Map<String,List<BigDecimal>> map=new HashMap<String, List<BigDecimal>>();
        map.put("principalFees",principalFees);
        map.put("interestFees",interestFees);
        return map;
    }
    //计算收益总额公式（标的总额*年化收益率）/12*锁标期
    public BigDecimal getProfitMoney(BigDecimal totalMoney,BigDecimal yearRate,Integer overTerm){
        BigDecimal profitMoney = new BigDecimal(0);
        profitMoney = ((totalMoney.multiply(yearRate.divide(BigDecimal.valueOf(100), 4, BigDecimal.ROUND_HALF_EVEN))).divide(BigDecimal.valueOf(12), 4, BigDecimal.ROUND_HALF_EVEN)).multiply(BigDecimal.valueOf(overTerm).divide(BigDecimal.valueOf(30), 1, BigDecimal.ROUND_HALF_EVEN));
        return profitMoney;
    }
    //计算待还本息 标的总额*月综合费率*借款期限+标的总额（本金）+平台服务费（管理费和手续费）+违约金
    public BigDecimal getToPay(BigDecimal totalMoney,BigDecimal monthRate,Integer overTerm,BigDecimal manage_fee,BigDecimal transfer_fee,BigDecimal odd){
        BigDecimal toPay = new BigDecimal(0);
        toPay = totalMoney.add(totalMoney.multiply(monthRate.divide(BigDecimal.valueOf(100),4,BigDecimal.ROUND_HALF_EVEN)).multiply(BigDecimal.valueOf(overTerm).divide(BigDecimal.valueOf(30),1,BigDecimal.ROUND_HALF_EVEN))).add(manage_fee.divide(BigDecimal.valueOf(100),4).multiply(totalMoney)).add(transfer_fee.divide(BigDecimal.valueOf(100), 4).multiply(totalMoney)).add(odd.divide(BigDecimal.valueOf(100),4).multiply(totalMoney));
        return toPay;
    }

}
