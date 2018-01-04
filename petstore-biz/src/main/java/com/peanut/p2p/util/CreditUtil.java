package com.peanut.p2p.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ln on 2015/5/20.
 */
public class CreditUtil {

    //银行基准利率
    private static BigDecimal bankRate=new BigDecimal(5.1);
    //利率倍数
    private static BigDecimal multiple=new BigDecimal(3.5);
    //罚息 日还款额的倍数
    private static int over=4;
    //小数点后精确的位数
    private static int digit=4;

    private static BigDecimal monthRate;

    public CreditUtil(){
        BigDecimal a=bankRate.multiply(multiple);
        BigDecimal b=a.divide(new BigDecimal(1200),digit,BigDecimal.ROUND_HALF_UP);
        monthRate=b;
    }
    /**
     * @param payment 借款总额
     * @param num     借款期限
     * @return        每月应还款额
     */
    public BigDecimal payPerMonth(BigDecimal payment,int num){
        BigDecimal pay;
        BigDecimal pay1=payment.multiply(monthRate);
        BigDecimal pay2=monthRate.add(new BigDecimal(1));
        BigDecimal pay3=pay2.pow(num);
        //分子
        BigDecimal pay4=pay1.multiply(pay3);
        //分母
        BigDecimal pay5=pay3.subtract(new BigDecimal(1));
        pay=pay4.divide(pay5,digit, BigDecimal.ROUND_HALF_UP);
        return pay;
    }

    /**
     * @param pay         逾期借款
     * @param overdue     逾期天数
     * @return             罚息金额
     */
    public BigDecimal payOverdue(BigDecimal pay,Long overdue){
        BigDecimal payAmount;
        BigDecimal pay1=pay.divide(new BigDecimal(30),digit,BigDecimal.ROUND_HALF_UP);
        payAmount=pay1.multiply(new BigDecimal(over)).multiply(new BigDecimal(overdue));
        return payAmount;
    }

    /**
     * @param payment    借款总额
     * @param num         借款期限
     * @param manageFee   管理费--期初服务费
     * @return             第一个月还款总额
     */
    public BigDecimal payFirstMonth(BigDecimal payment,int num,BigDecimal manageFee){
        BigDecimal pay;
        BigDecimal pay1=payment.multiply(monthRate);
        BigDecimal pay2=monthRate.add(new BigDecimal(1));
        BigDecimal pay3=pay2.pow(num);
        //分子
        BigDecimal pay4=pay1.multiply(pay3);
        //分母
        BigDecimal pay5=pay3.subtract(new BigDecimal(1));
        pay=pay4.divide(pay5,2, BigDecimal.ROUND_HALF_UP);
        BigDecimal pay6=new BigDecimal(num).divide(new BigDecimal(12),digit,BigDecimal.ROUND_HALF_UP);
        BigDecimal pay7=payment.multiply(manageFee);
                pay=pay.add(pay7);
        return pay;
    }
    //每个月的本金跟利息详情

    /**
     * @param payment        借款总额
     * @param payPerMonth    每月还款总额
     * @param term            借款期限
     * @return                每月还款详细
     */
    public Map<String,List<BigDecimal>> detail(BigDecimal payment,BigDecimal payPerMonth,int term){

        //应还本金
        BigDecimal principalFee= new BigDecimal(0);
        //应还利息
        BigDecimal interestFee= new BigDecimal(0);
        //应还管理费
        BigDecimal management=new BigDecimal(0);
        List<BigDecimal> principalFees=new ArrayList<BigDecimal>();
        List<BigDecimal> interestFees=new ArrayList<BigDecimal>();
        List<BigDecimal> managements=new ArrayList<BigDecimal>();
        for(int i=0;i<term;i++){
            interestFee=payment.multiply(monthRate);
            principalFee=payPerMonth.subtract(interestFee);

            principalFee=principalFee.divide(new BigDecimal(1), digit, BigDecimal.ROUND_HALF_UP);
            interestFee=interestFee.divide(new BigDecimal(1),digit, BigDecimal.ROUND_HALF_UP);
            management=payPerMonth.multiply(new BigDecimal(0.0085));
            interestFee=interestFee.subtract(management).divide(new BigDecimal(1), digit, BigDecimal.ROUND_HALF_UP);
            management=management.divide(new BigDecimal(1),digit, BigDecimal.ROUND_HALF_UP);
            managements.add(management);
            principalFees.add(principalFee);
            interestFees.add(interestFee);
            payment=payment.subtract(principalFee);
        }
        Map<String,List<BigDecimal>> map=new HashMap<String, List<BigDecimal>>();
        map.put("principalFees",principalFees);
        map.put("interestFees",interestFees);
        map.put("managements",managements);
        return map;
    }
    //计算收益总额公式（标的总额*年化收益率）/12*锁标期
    public BigDecimal getProfitMoney(BigDecimal totalMoney,BigDecimal yearRate,Integer overTerm){
        BigDecimal profitMoney = new BigDecimal(0);
        profitMoney = ((totalMoney.multiply(yearRate.divide(BigDecimal.valueOf(100), digit, BigDecimal.ROUND_HALF_UP))).divide(BigDecimal.valueOf(12), 4, BigDecimal.ROUND_HALF_UP)).multiply(BigDecimal.valueOf(overTerm).divide(BigDecimal.valueOf(30), 1, BigDecimal.ROUND_HALF_UP));
        return profitMoney;
    }
    //计算待还本息 标的总额*月综合费率*借款期限+标的总额（本金）+平台服务费（管理费和手续费）+违约金
    public BigDecimal getToPay(BigDecimal totalMoney,BigDecimal monthRate,Integer overTerm,BigDecimal manage_fee,BigDecimal transfer_fee,BigDecimal odd){
        BigDecimal toPay = new BigDecimal(0);
        toPay = totalMoney.add(totalMoney.multiply(monthRate.divide(BigDecimal.valueOf(100),digit,BigDecimal.ROUND_HALF_UP)).multiply(BigDecimal.valueOf(overTerm).divide(BigDecimal.valueOf(30),1,BigDecimal.ROUND_HALF_UP))).add(manage_fee.divide(BigDecimal.valueOf(100),4).multiply(totalMoney)).add(transfer_fee.divide(BigDecimal.valueOf(100), 4).multiply(totalMoney)).add(odd.divide(BigDecimal.valueOf(100),4).multiply(totalMoney));
        return toPay;
    }
}
