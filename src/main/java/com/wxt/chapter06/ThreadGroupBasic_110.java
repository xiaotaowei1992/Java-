package com.wxt.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupBasic_110 {
	public static void main(String[] args) throws InterruptedException {
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
		},"thread");
		thread.setDaemon(true);
		thread.start();
		TimeUnit.SECONDS.sleep(3);
		
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		
		System.out.println("activeCount=" + mainGroup.activeCount());
		System.out.println("activeGroupCount=" + mainGroup.activeGroupCount());
		System.out.println("getMaxPriority=" + mainGroup.getMaxPriority());
		System.out.println("getName=" + mainGroup.getName());
		System.out.println("getParent=" + mainGroup.getParent());
		mainGroup.list();
		System.out.println("-----------------------------------");
		System.out.println("parentOf=" + mainGroup.parentOf(group));
		System.out.println("parentOf=" + mainGroup.parentOf(mainGroup));
	}
}
