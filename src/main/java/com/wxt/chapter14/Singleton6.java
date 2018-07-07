package com.wxt.chapter14;

/**
 * @author Administrator
 * Holder方式
 */
//final 不允许被继承
public class Singleton6 {
	//实例变量
	private byte[] data = new byte[1024];
	
	private Singleton6() {
		
	}
	
	//在静态内部类中持有Singleton6的实例，并且可以被直接初始化
	private static class Holder {
		private static Singleton6 instance = new Singleton6();
	}
	
	//调用getInstance方法，事实上是获得Holder的instance静态属性
	public static Singleton6 getInstance() {
		return Holder.instance;
	}
}
