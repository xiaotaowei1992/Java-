package com.wxt.chapter04;

import java.util.concurrent.TimeUnit;

public class ClassMonitor {
	public static synchronized void method01() {
		System.out.println(Thread.currentThread().getName()
				+ " enter to method01");
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public static synchronized void method02() {
		System.out.println(Thread.currentThread().getName()
				+ " enter to method02");
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public static  void method02() {
		synchronized(ClassMonitor.class){
			System.out.println(Thread.currentThread().getName()
					+ " enter to method02");
			try {
				TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		new Thread(ClassMonitor::method01,"t1").start();
		new Thread(ClassMonitor::method02,"t2").start();

	}
}
