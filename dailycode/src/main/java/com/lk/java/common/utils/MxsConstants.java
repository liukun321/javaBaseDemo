package com.lk.java.common.utils;

public class MxsConstants {
	//发送邮件的邮箱 
	public static final String FROMMAIL = "1147420182@qq.com";
	//目标邮箱
	public static final String DESTMAIL = "jishu@mixiusi.com.cn";
	//发送邮件用的邮件服务器SMTP地址
	public static final String MAILSERVER = "smtp.qq.com";
	//邮箱名
	public static final String MAILNAME = "1147420182";
	//邮箱授权密码
	public static final String MAILPASSWORD = "eficzgzkrfrxihch";// liukun123456  eficzgzkrfrxihch
	
	//返回状态信息和状态码
	public static final String SUCCESS = "success";
	
	public static final String ERROR = "error";
	
	public static final String CODE = "10001";
	//成功的状态码
	public static final String CODE0 = "200";
	//失败状态码1， 表示代码运行发生异常
	public static final String CODE1 = "0001";
	//失败状态码2，表示电话号码格式不匹配
	public static final String CODE2 = "0002";
	//失败状态码3，表示用户码格式不匹配
	public static final String CODE3 = "0003";
	//失败状态码4， 表示邮箱格式不对查询数据失败
	public static final String CODE4 = "0004";
	//重复数据
	public static final String CODE5 = "0005";
	
	//----------------------阿里云对象存储---------------------------
	/**
	 * 阿里云对象存储杭州地区--地域节点
	 */
	public static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
	/**
	 * https://ram.console.aliyun.com 创建RAM账号,用户名：mixiusi-oss-01
	 */
	public static final String ACCESSKEYID = "LTAIu6DMZNbh7F6l";
	/**
	 * https://ram.console.aliyun.com 创建RAM账号,用户名：mixiusi-oss-01
	 */
	public static final String ACCESSKEYSECRET = "e8ZMyn0CHWMcTg9YCqOo0QXNAMn9Sr";
	/**
	 * 营销数据存储在对象存储中的bucket
	 */
	public static final String ACTIVITY_BUCKETNAME = "activity-file";
	/**
	 * 营销数据存储在对象存储中的根目录
	 */
	public static final String ACTIVITY_ROOTPATH = "activity";
	/**
	 * 咖啡配方文件存储在对象存储中的bucket
	 */
	public static final String FORMULA_BUCKETNAME = "mixiusi-oss";
	/**
	 * 咖啡配方文件存储在对象存储中的根目录
	 */
	public static final String FORMULA_ROOTPATH = "coffee/formula";
	
	//---------------极光推送----------------------------
	/**
	 * 好享卡  机器端APP APPKEY
	 */
	public static final String MACHINE_APPKEY = "eb3f6faf8ab32ccb4770bdba";
	/**
	 * 好享卡  机器端APP MASTERSECRET
	 */
	public static final String MACHINE_MASTERSECRET = "0afef46ba6b049282ad7e39e";
    /**
	 * 运维端 APP APPKEY
	 */
	public static final String WORKER_APPKEY = "159b0042e6d74f2c363b6447";
	/**
	 * 运维端 APP MASTERSECRET
	 */
	public static final String WORKER_MASTERSECRET = "79c84a3aa54b1f7e84b739a4";
	
	
	//----------------微信支付--------------------
	/**
	 * 微信APPId
	 */
	public static final String WECHAT_APP_ID = "wwace37b37861f586c";
	/**
	 * 微信商户秘钥
	 */
	public static final String WECHAT_KEY = "Mxs88888Mxs88888Mxs88888Mxs88888";
	/**
	 * 微信商户号
	 */
	public static final String WECHAT_MCHID = "1503728561";
	/**
	 * 预支付回调接口
	 */
	public static final String CALLBACK_URL = "http://mixiusi.com.cn:8070";
	/**
	 * 小程序应用的APPLYID
	 */
	public static final String WECHAT_APPLYID = "wx309d3d8b6ac05301";
	
	public static final String WECHAT_SECRET = "79955074e16bfbc772a92b52d2151d4e";
	/**
	 * 小程序端预支付调用的url
	 */
	public static final String PREPAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	//------------------支付宝------------------------
		
	public static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";
	public static final String ALIPAY_APP_ID = "2018022802289573";
	public static final String ALIPAY_APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCXP/1UO5/CcmmrSu4SDeOilNVTypiHrdF+QGX2Vkv4gvnvHwXu1utoXXOp/YVVW8XgCHz3oO1b9WDVCMA9kiU2uum4chOkPOAUOS3apvZkv+pUWarNpBGArBwWNSNkRrRnBQFabnylvgWh8BQGftx6X3hl3ejUnmJ19e3TAyOhHMc0i2CSXz34m2RwHoik9nJ20gAhlCzToQNqVRSbHOD2lZlYDGP7e2NoVDQ6HJFxM3u09qGLm34ZijX9j5/NHEwWZSQi3iz7gT2iqc8fRXFIMiLpPrn37nCJm/eIWOo6nxnJzoDWjkghF6xejiMnigGxo5Ari36lB3XfOS8V6reFAgMBAAECggEAEt+nSwWNsAP676cQAiy9hSIxZJ1ZX0TvaWO71Xt7S218prwmT2F+Sq2uqz25j6c+D/C/N19bfyglhy/qXUSJZET6uUty7AG0rJFeCXTgNj5EjXYK/FJG5NmVP6gt3Gt+Q4S6YIB9CWmm5khBF3ZpKNQVABEq5q1E+BdSMAyqO4ZcfjoC6hb7sIlRvhO9JOYfInGxOL55sZRhi87oG7xoSoE7xsZ2mKigG3kkjMV/4ziVfxA4cgQmVZ9EkMneTTvQi4kqCXrPDaAdrsgl16l6WhNWHdJ5EPSo04hv9u+oBAEfsddCJvYff+1eEeYzu/peV2ua9eP/1aJVDwwOqFWFgQKBgQDXVB0Vdd0YxCItjXCigQWUewTM/gCnXdK8XTkZuO5IUm29dYiYPQTBkMwRPxL8xhHYIv9CvjnLiuJkMWcBNnF0Hamr0upb16Dmz1/dnk3I5FxZQZu6LJlOzY/D6YEAa+Lfj3VB91I8A4Clv9e5YlXBnoW8abS3gfbH+DI6pk1ZcQKBgQCz0XO0Wb3BDH+neMO16b1HJUi72+aWTLu17BnqpfAdFs3SPjoAfJAG0uweiceii3AAHUaVY16OYKbf4d6lgOBhKfNUKvzg10V4muKfTocHAMz0QQFh+tweiRvOd5nHAjmjgLBlDi5icvVv8qj20XjLgc6uFWOm9+x4hKL7D2HVVQKBgDbzo1x3sM4CN8qyPt1p2dezsVzzMY2E1yP1En5rAHx6dMEV/p8Da3ROlJWOKDVUAvfKrqQE0dENB4uUQ/o+P6PncgaElASOOeTNZWS0YptzE9I/eROBEDrZIOhZbe+CmOp+vOjxyg3AwxMJq28HFmWMJAsaWuE+DJGp2H+5MyIxAoGBALPAmCJcZ1SY0u8tyK6LtrttKPUqEKqEkEx+dTXcpVfe2Obnb4HXAv7fUEwCvT7elpp2qX1idT5sncRF/RSC7UoT7ntf8aQtbfPvGMXZcR9uDHPKm8A/TlV0CAjwBBgtQEMSvMJ4V6PweStsbr00jsUYwOvC0/gv9AJRzL6eFNV1AoGAdMBi/JRird3JYHZtX31Q0dwTaNU6ObrbLlDVBCINZ77XXYSg9gBMSBy/FNGU1OphG7Ojb4S4hfQamnNL17YTnqipxVpMPdiGrDLlh9AvlIkjGrrwEBlHHLAJAAUaT90IhJnP/rBHgbcix0xEI1kpKEfqoe2MiH6XZQ9C16GtKJ0=";
	public static final String CHARSET = "utf-8";
	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqUnBQDVeBdV47W2BGzpy0kiMXb1ahYEXWSLUs+r/XmCLc9mEXVUfA8/3Ob/NfdopW/BDCqvNiSnIWx2wj9+7gqXnzAtn3C77govHv5vHU5EU1pUB67VVJk2mMx2SngVmezryNg8OOa4E1mVLT+AfJkO2q93mL5YU2RtldTq5iblvOb+yq+sGLSh0Qbi2a+nD2U+NFpeROAcH2p5mMY/rYWQPyyxIWX+xEF2Ap8gzvvxCYUP3QCs0sIiUyNfcNlSk7w+n2ViO3ZgHkXfOZnSNvV/L2fLHOzjbFasl7IChl+DA5Q2oYi237iOhVi2siKPvjsblyzjzaYar8D98kFRniQIDAQAB";
	public static final String ALIPAY_SHOWURL = "192.168.0.101:8888";	
}
