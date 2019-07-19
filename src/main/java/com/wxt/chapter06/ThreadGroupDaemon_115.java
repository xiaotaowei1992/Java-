package com.wxt.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDaemon_115 {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group = new ThreadGroup("group01");
		new Thread(group, ()->{
				while(true){
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			},"thread1").start();
		
		ThreadGroup group2 = new ThreadGroup("group02");
		new Thread(group2, ()->{
				while(true){
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			},"thread2").start();
		
		group2.setDaemon(true);
		TimeUnit.SECONDS.sleep(5);
		System.out.println(group.isDestroyed());
		System.out.println(group2.isDestroyed());
	}
}
