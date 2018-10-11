package com.lk.java.guava.ratelimit;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaUtils {
	public static void main(String[] args) throws InterruptedException {
		//每秒允许5个请求，表示每秒中产生5个令牌
//		RateLimiter rate = RateLimiter.create(5);
//		System.out.println(rate.acquire(10));//等待2秒
//		System.out.println(rate.acquire(5));//等待1秒
//		System.out.println(rate.acquire(1));//等待1/5秒
//		System.out.println(rate.acquire(1));
//		System.out.println(rate.acquire(1));
//		System.out.println(rate.acquire(1));
//		System.out.println(rate.acquire(1));
//		//平滑预热限流
//		System.out.println("-----------------------------------");
//		RateLimiter rate2 = RateLimiter.create(10, 1000, TimeUnit.MILLISECONDS);
//		for (int i = 0; i < 10; i++) {
//			System.out.println(rate2.acquire(1));
//		}
		System.out.println("---------------------------");
        //限流，每秒允许10个请求进入秒杀
		RateLimiter rate1 = RateLimiter.create(10);
		for (int i = 0; i < 100; i++) {
            //100个线程同时抢购
			new Thread(() -> {
                //每个秒杀请求如果100ms以内得到令牌，就算是秒杀成功，否则就返回秒杀失败
				if (rate1.tryAcquire(50, TimeUnit.MILLISECONDS)) {
					System.out.println("---------成功----------");
				}else {
					System.out.println("失败");
				}
			}).start(); 
			Thread.sleep(10);
		}
	}
	
    /**
     * 平滑预热限流(SmoothWarmingUp)
     */
    public void SmoothWarmingUp (){
            //permitsPerSecond:每秒新增的令牌数  warmupPeriod:从冷启动速率过渡到平均速率的时间间隔
            //系统冷启动后慢慢的趋于平均固定速率（即刚开始速率慢一些，然后慢慢趋于我们设置的固定速率）
            RateLimiter limiter = RateLimiter.create(10, 1000, TimeUnit.MILLISECONDS);
            for(int i = 0; i < 10;i++) {
                //获取一个令牌
                System.out.println(limiter.acquire(1));
            }
    }
    
    /**
     * 平滑突发限流(smoothbursty)
     */
    public void SmoothBurstyRateLimitTest03 (){
     
            //每秒允许5个请求，表示桶容量为5且每秒新增5个令牌，即每隔0.2毫秒新增一个令牌
            RateLimiter limiter = RateLimiter.create(5);
            //第一秒突发了10个请求
            System.out.println(limiter.acquire(10));
            //limiter.acquire(1)将等待差不多2秒桶中才能有令牌
            System.out.println(limiter.acquire(1));
            //固定速率
            System.out.println(limiter.acquire(1));
            //固定速率
            System.out.println(limiter.acquire(1));
            //固定速率
            System.out.println(limiter.acquire(1));
    }
    
    /**
     * 平滑突发限流(smoothbursty)
     */
    public void SmoothBurstyRateLimitTest02 (){
     
            //每秒允许5个请求，表示桶容量为5且每秒新增5个令牌，即每隔0.2毫秒新增一个令牌
            RateLimiter limiter = RateLimiter.create(5);
            //一次性消费5个令牌
            System.out.println(limiter.acquire(5));
            //limiter.acquire(1)将等待差不多1秒桶中才能有令牌
            System.out.println(limiter.acquire(1));
            //固定速率
            System.out.println(limiter.acquire(1));
            //固定速率
            System.out.println(limiter.acquire(1));
            //固定速率
            System.out.println(limiter.acquire(1));
    }
    
    /**
     * 平滑突发限流(SmoothBursty)
     */
    public void SmoothBurstyRateLimitTest (){
            //QPS = 5，每秒允许5个请求
            RateLimiter limiter = RateLimiter.create(5);
            //limiter.acquire() 返回获取token的耗时，以秒为单位
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
            System.out.println(limiter.acquire());
    }
     
}
