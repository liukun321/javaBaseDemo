package com.lk.java.guava.ratelimit.api;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import com.lk.java.common.ServerResponse;

@Scope
@Component
@Aspect
public class RateLimitAop {
	@Autowired
	private HttpServletResponse response;
	//限流方案 每秒钟不超过5个请求
	private RateLimiter rateLimiter = RateLimiter.create(5.0);

	// 切点
	@Pointcut("@annotation(com.lk.java.guava.ratelimit.api.RateLimitAspect)")
	public void serviceLimit() {

	}

	@Around("serviceLimit()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Boolean flag = rateLimiter.tryAcquire();
		Object obj = null;
		try {
			if (flag) {
				obj = joinPoint.proceed();
			} else {
				ServerResponse resp = ServerResponse.createByErrorMessage("failure");
				String result = "resultCode:100,msg:failure";
				output(response, result);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("flag=" + flag + ",obj=" + obj);
		return obj;
	}

	public void output(HttpServletResponse response, String msg) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		ServletOutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(msg.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outputStream.flush();
			outputStream.close();
		}
	}

}
