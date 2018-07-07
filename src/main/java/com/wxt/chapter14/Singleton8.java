package com.wxt.chapter14;

/**
 * @author Administrator
 * 枚举方式
 */
//final 不允许被继承
public class Singleton8 {
	//实例变量
	private byte[] data = new byte[1024];
	
    private Singleton8() {
	}
    
    private enum EnumHolder{
    	INSTANCE;
    	private Singleton8 instance;
        EnumHolder() {
			this.instance = new Singleton8();
		}
        
        private Singleton8 getSingleton8() {
        	return instance;
        }
    }
    
    
    public static Singleton8 getInstance() {
    	return EnumHolder.INSTANCE.getSingleton8();
    }

}
