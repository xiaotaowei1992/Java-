package com.wxt.chapter04;

import java.util.concurrent.TimeUnit;

public class ThisMonitor_72 {
	public synchronized void method01() {
		System.out.println(Thread.currentThread().getName()
				+ " enter to method01");
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void method02() {
		System.out.println(Thread.currentThread().getName()
				+ " enter to method02");
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void method03() {
		 synchronized(this){
			 System.out.println(Thread.currentThread().getName()
						+ " enter to method03");
				try {
					TimeUnit.SECONDS.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		 }
		
	}
	
	
	public static void main(String[] args) {
		ThisMonitor_72 thisMonitor = new ThisMonitor_72();
		new Thread(thisMonitor::method01).start();
		new Thread(thisMonitor::method02).start();
		ThisMonitor_72 thisMonitor2 = new ThisMonitor_72();
		new Thread(thisMonitor2::method03).start();
	}

}
