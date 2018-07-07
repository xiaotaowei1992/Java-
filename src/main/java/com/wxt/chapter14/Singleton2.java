package com.wxt.chapter14;

/**
 * @author Administrator
 * 懒汉式
 */
//final 不允许被继承
public class Singleton2 {
	//实例变量
	private byte[] data = new byte[1024];
	
	//定义实例，但是不直接初始化
	private static Singleton2 instance = null;
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getInstance() {
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}
