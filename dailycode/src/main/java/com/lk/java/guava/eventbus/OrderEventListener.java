package com.lk.java.guava.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author:gaoguangjin
 * @date:2018/2/27
 */
@Slf4j
public class OrderEventListener {
	private final static Logger log = LoggerFactory.getLogger(OrderEventListener.class);
    @Subscribe
    public void sendMessage(OrderEvent orderEvent){
        log.info("下单成功，发送短信");
    }
    @Subscribe
    public void sendMessage(String message){
        log.info("下单成功，发送短信"+message);
    }
}
