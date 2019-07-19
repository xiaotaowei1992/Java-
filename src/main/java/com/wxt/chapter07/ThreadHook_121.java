package com.wxt.chapter07;

import java.util.concurrent.TimeUnit;

public class ThreadHook_121 {
	public static void main(String[] args) {
		//为应用程序注入钩子线程
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("The hook thread1 is running...");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("The hook thread1 will exit...");
			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("The hook thread2 is running...");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("The hook thread2 will exit...");
			}
		});
		
		System.out.println("The main Thread will stopping...");
	}
}
