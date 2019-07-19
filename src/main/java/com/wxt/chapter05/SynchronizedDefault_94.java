package com.wxt.chapter05;

import java.util.concurrent.TimeUnit;

public class SynchronizedDefault_94 {
	public synchronized void syncMethod(){
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		SynchronizedDefault_94 defect = new SynchronizedDefault_94();
		Thread t1 = new Thread(defect::syncMethod,"t1");
		//make sure the t1 start
		t1.start();
		TimeUnit.MILLISECONDS.sleep(100);
		Thread t2 = new Thread(defect::syncMethod,"t2");
		t2.start();
		//make sure the t2 start
		TimeUnit.MILLISECONDS.sleep(10);
		t2.interrupt();
		System.out.println(t2.isInterrupted());
		System.out.println(t2.getState());
	}
}
