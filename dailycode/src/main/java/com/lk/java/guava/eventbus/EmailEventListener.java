package com.lk.java.guava.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;
import com.lk.java.comparable.TestComparator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author:gaoguangjin
 * @date:2018/2/27
 */
@Slf4j
public class EmailEventListener {
	private final static Logger log = LoggerFactory.getLogger(EmailEventListener.class);
    @Subscribe
    public void sendMessage(String message){
        log.info("下单成功，发送邮件"+message);
    }
}
