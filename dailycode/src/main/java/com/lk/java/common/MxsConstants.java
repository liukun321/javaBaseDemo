package com.lk.java.common;

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
	 * 好享卡  机器端APP APPKEY
	 */
	public static final String MACHINE_APPKEY_TEST = "4d730bd3f5d5b5000f638408";
	/**
	 * 好享卡  机器端APP MASTERSECRET
	 */
	public static final String MACHINE_MASTERSECRET_TEST = "314a397f29d25aea2ceda6f1";
    /**
	 * 运维端 APP APPKEY
	 */
	public static final String WORKER_APPKEY = "159b0042e6d74f2c363b6447";
	/**
	 * 运维端 APP MASTERSECRET
	 */
	public static final String WORKER_MASTERSECRET = "79c84a3aa54b1f7e84b739a4";
}
