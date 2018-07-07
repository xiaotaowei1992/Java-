package com.wxt.chapter03;

public class ThreadSleep {
    public static void main(String[] args) {
		new Thread(()->{
			long startTime = System.currentTimeMillis();
			sleep(2_000L);
			long endTime =  System.currentTimeMillis();
			System.out.println(String.format("Total spend %d ms",(endTime -startTime)));
		}).start();
		
		long start = System.currentTimeMillis();
		sleep(3_000L);
		long end = System.currentTimeMillis();
		System.out.println(String.format("main thread total spend %d ms",(end -start)));
	}
    private static void sleep(long ms){
    	try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
