package com.wxt.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupPriority_112 {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("group01");
		Thread thread = new Thread(group, ()->{
			while(true){
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "thread");
		thread.setDaemon(true);
		thread.start();
		
		System.out.println("group.getmaxPriority=" + group.getMaxPriority());
		System.out.println("thread.getPriority=" + thread.getPriority());
		
		//改变group的最大优先级
		group.setMaxPriority(3);
		
		Thread thread2 = new Thread(group, ()->{
			while(true){
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "thread2");
		thread2.setDaemon(true);
		thread2.start();
		
		System.out.println("group.getmaxPriority=" + group.getMaxPriority());
		System.out.println("thread.getPriority=" + thread.getPriority());
		System.out.println("thread2.getPriority=" + thread2.getPriority());
		
	}
}
