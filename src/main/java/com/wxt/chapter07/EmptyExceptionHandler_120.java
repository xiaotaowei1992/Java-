package com.wxt.chapter07;

import java.util.concurrent.TimeUnit;

public class EmptyExceptionHandler_120 {
	public static void main(String[] args) {
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println(mainGroup.getName());
		System.out.println(mainGroup.getParent());
		System.out.println(mainGroup.getParent().getParent());
		final Thread thread = new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//2.抛出异常
			System.out.println(1/0);
		},"Test-Thread");
		thread.start();
	}
}
