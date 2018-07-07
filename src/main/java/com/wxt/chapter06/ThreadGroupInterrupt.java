package com.wxt.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupInterrupt {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group = new ThreadGroup("TestGroup");
	    new Thread(group, ()->{
			while(true){
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
			System.out.println("thread1 will exit");
		},"thread1").start();
	    
	    new Thread(group, ()->{
			while(true){
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
			System.out.println("thread2 will exit");
		},"thread2").start();
		TimeUnit.SECONDS.sleep(3);
		group.interrupt();
	}
}
