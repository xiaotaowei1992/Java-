package com.wxt.chapter14;

/**
 * @author Administrator
 * 恶汉式:
 * 
 */
//final 不允许被继承
public final class Singleton1 {
	//实例变量
	private byte[] data = new byte[1024];
	
	//在定义实例对象的时候直接初始化
	private static Singleton1 instance = new Singleton1();
	//私有构造函数，不允许外部new
	private Singleton1(){
		
	}
	
	public static Singleton1 getInstance() {
		return instance;
	}
}
