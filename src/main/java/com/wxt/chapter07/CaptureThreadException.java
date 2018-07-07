package com.wxt.chapter07;

import java.util.concurrent.TimeUnit;

public class CaptureThreadException {
	public static void main(String[] args) {
		//1.设置会掉接口
		Thread.setDefaultUncaughtExceptionHandler((t,e)->{
			System.out.println(t.getName() + " occer exception..");
			e.printStackTrace();
		});
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
