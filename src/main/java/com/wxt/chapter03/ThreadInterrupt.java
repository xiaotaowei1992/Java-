package com.wxt.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
   public static void main(String[] args) throws InterruptedException {
	  Thread thread = new Thread(()->{
		  try {
			TimeUnit.MINUTES.sleep(1);
		} catch (Exception e) {
			System.out.println("thread is interrupted");
		} 
	  });
     thread.start();
     TimeUnit.MILLISECONDS.sleep(20);
     thread.interrupt();
   }
}
