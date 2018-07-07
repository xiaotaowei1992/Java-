package com.wxt.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreads {
	public static void main(String[] args) throws InterruptedException {
		//1.创建一个ThreadGroup
		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		//2.创建线程传入threadGroup
		Thread thread = new Thread(myGroup,()->{
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"myThread");
		thread.start();
		
		TimeUnit.SECONDS.sleep(2);
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		
		Thread[] lists = new Thread[mainGroup.activeCount()];
		int recurseSize = mainGroup.enumerate(lists);
		System.out.println(recurseSize);
		
		recurseSize = mainGroup.enumerate(lists, false);
		System.out.println(recurseSize);
	}
}
