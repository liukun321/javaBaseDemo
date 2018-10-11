package com.lk.java.guava.ratelimit;
/**
 * 限流方案，基于Redis
 * @author liukun
 *
 */
public interface RateLimitByRedis {
	
	/*public boolean acquire(String key, Integer permits, long currMillSecond) {
	    try (Jedis jedis = JedisPoolUtil.getJedisPool().getResource()) {
	        //针对新用户创建令牌桶
	        if (!jedis.exists(key)) {
	            jedis.hset(key, "last_mill_second", String.valueOf(currMillSecond));
	            jedis.hset(key, "curr_permits", "0");
	            jedis.hset(key, "max_permits", "500");
	            jedis.hset(key, "rate", "400");
	            return true;
	        }
	        //获取令牌桶信息，上一个令牌时间，当前可用令牌数，最大令牌数，令牌消耗速率
	        List<String> limitInfo = jedis.hmget(key, "last_mill_second", "curr_permits", "max_permits", "rate");
	        long lastMillSecond = Long.parseLong(limitInfo.get(0));
	        Integer currPermits = Integer.valueOf(limitInfo.get(1));
	        Integer maxPermits = Integer.valueOf(limitInfo.get(2));
	        Double rate = Double.valueOf(limitInfo.get(3));
	        //向桶里面添加令牌
	        Double reversePermitsDouble = ((currMillSecond - lastMillSecond) / 1000) * rate;
	        Integer reversePermits = reversePermitsDouble.intValue();
	        Integer expectCurrPermits = reversePermits + currPermits;
	        Integer localCurrPermits = Math.min(expectCurrPermits, maxPermits);
	        //添加令牌之后更新时间
	        if (reversePermits > 0) {
	            jedis.hset(key, "last_mill_second", String.valueOf(currMillSecond));
	        }
	        //判断桶里面剩余的令牌数目
	        if (localCurrPermits - permits >= 0) {
	            jedis.hset(key, "curr_permits", String.valueOf(localCurrPermits - permits));
	            return true;
	        } else {
	            jedis.hset(key, "curr_permits", String.valueOf(localCurrPermits));
	            return false;
	        }
	    } catch (Exception e) {
	        return false;
	    }
	}*/
}
