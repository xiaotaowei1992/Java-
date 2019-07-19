package com.wxt.chapter02;

public class DaemonThread_33 {
   public static void main(String[] args) throws InterruptedException {
	   Thread thread = new Thread(() -> {
		   while(true){
			   try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		   }
		   
	   });
	   
	   thread.setDaemon(true);
	   thread.start();
	   Thread.sleep(5_000L);
	   System.out.println("main thread finished lifecycle.");
	   
}
}
