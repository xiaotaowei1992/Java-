package com.wxt.chapter14;

/**
 * @author Administrator
 * 枚举方式
 */
//final 不允许被继承
public enum Singleton7 {
	INSTANCE;
	//实例变量
	private byte[] data = new byte[1024];
	
    Singleton7() {
    	System.out.println("INSTANCE will be initialized immediately");
	}
    
    public void method() {
    	//调用该方法则会主动使用Singleton7,INSTANCE将会被实例化
    }
    
    public static Singleton7 getInstance() {
    	return INSTANCE;
    }

}
