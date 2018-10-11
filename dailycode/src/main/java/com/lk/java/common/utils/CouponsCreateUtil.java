package com.lk.java.common.utils;

import java.util.LinkedList;
import java.util.List;
/**
 * 生成优惠具体金额的优惠券
 * @author liukun
 *
 */
public class CouponsCreateUtil {
	private int min_money;
	
	private int max_money;
	
	
    public int getMin_money() {
		return min_money;
	}

	public int getMax_money() {
		return max_money;
	}

	public void setMin_money(int min_money) {
		this.min_money = min_money;
	}

	public void setMax_money(int max_money) {
		this.max_money = max_money;
	}

	/**
     * 生成最大值 10人民币
     */
    public CouponsCreateUtil() {
	}
    
	public CouponsCreateUtil(int min_money, int max_money) {
		super();
		this.min_money = min_money;
		this.max_money = max_money;
	}

	/**
     * 生成红包最小值 4元
     */
    private static final int MIN_MONEY = 1;
    /**
     * 生成最大值 10人民币
     */
    private static final int MAX_MONEY = 8 * 100;
    /**
     * 小于最小值
     */
    private static final int ERROR = -1 ;
    /**
     * 正常值
     */
    private static final int OK = 1 ;
    /**
     * 最大的红包是平均值的 TIMES 倍，防止某一次分配金额较大
     */
    private static final double TIMES = 1.3F ;

    private static int recursiveCount = 0 ;

    public static List<Integer> typeOfCoupons2(int money, int count){
        List<Integer> moneys = new LinkedList<>() ;
        //计算出最大优惠券
        int max = (int) ((money / count) * TIMES) ;
//	        if(max > 1000) {
//	        	System.out.println("----------平均值超过了10元----请重新输入总金额和优惠券数量-----");
//	        	return null;
//	        }
        max = max > MAX_MONEY ? MAX_MONEY : max ;
        for (int i = 0 ; i< count ; i++){
            //随机获取优惠券
            int redPacket = randomRedPacket(money, MIN_MONEY, max, count - i);
            if(redPacket < 0) {
            	break;
            }
            moneys.add(redPacket);
            //总金额每次减少
            money -= redPacket ;
        }
        return moneys ;
    }

    private static int randomRedPacket(int totalMoney, int minMoney, int maxMoney, int count) {
        if (minMoney == maxMoney){
            return minMoney ;
        }
        //如果最大金额大于了剩余金额 则用剩余金额 因为这个 money 每分配一次都会减小
        maxMoney = maxMoney > totalMoney ? totalMoney : maxMoney ;
        //在 minMoney到maxMoney 生成一个随机红包
        int redPacket = (int) (Math.random() * (maxMoney - minMoney) + minMoney) ;
        System.out.println(redPacket);
        int lastMoney = totalMoney - redPacket ;
        int status = checkMoney(lastMoney, count - 1) ;
        //正常金额
        if (ERROR == status){
            return -1 ;
        }
        return redPacket ;
    }

    /**
     * 校验剩余的金额的平均值是否在 最小值和最大值这个范围内
     * @param lastMoney
     * @param count
     * @return
     * 
     * 随机值都在最大和最小值之间，不需要担心金额，剩余的金额如果小于最小值就停止，或者剩余的数量为0，也停止
     */
    private static int checkMoney(int lastMoney, int count) {
    	if(lastMoney < MIN_MONEY || count < 1) {
    		return ERROR;
    	}
        return OK ;
    }
  public static void main(String[] args) {
    	CouponsCreateUtil redPacket = new CouponsCreateUtil() ;
        List<Integer> redPackets = redPacket.typeOfCoupons2(100, 20);
        System.out.println(redPackets) ;

        int sum = 0 ;
        for (Integer red : redPackets) {
            sum += red ;
        }
        System.out.println(sum);
    }

}
