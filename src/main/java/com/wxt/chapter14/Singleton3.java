package com.wxt.chapter14;

/**
 * @author Administrator
 * 懒汉式 + 同步方法
 */
//final 不允许被继承
public class Singleton3 {
	//实例变量
	private byte[] data = new byte[1024];
	
	//定义实例，但是不直接初始化
	private static Singleton3 instance = null;
	
	private Singleton3() {
		
	}
	
	/**
	 * 向getInstance方法中接入同步控制，每次只能有一个线程能够进入
	 */
	public static synchronized Singleton3 getInstance() {
		if (null == instance) {
			instance = new Singleton3();
		}
		return instance;
	}
}
