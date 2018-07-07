package com.wxt.chapter14;

import java.net.Socket;
import java.sql.Connection;

/**
 * @author Administrator
 * volatile +　Double-Check
 */
//final 不允许被继承
public class Singleton5 {
	//实例变量
	private byte[] data = new byte[1024];
	
	private volatile static Singleton5 instance = null;
	
	Connection connection;
	Socket socket;
	
	private Singleton5() {
		//this.connection = connection; //初始化
		//this.socket = socket;//初始化
	}
	
	public static Singleton5 getInstance() {
		//当instance为null时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
		if (null == instance) {
			synchronized (Singleton5.class) {
				//判断如果instance 为null则创建
				if (null == instance) {
					instance = new Singleton5();
				}
			}
		}
		return instance;
		
	}
	
}
