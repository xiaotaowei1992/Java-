package com.wxt.chapter02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter_30 extends Thread {
	final static AtomicInteger COUNTER = new AtomicInteger(0);
	
    @Override
    public void run() {
    	try {
    		System.out.println("The " + COUNTER.getAndIncrement() + " thread be created.");
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		try {
			while(true){
				new ThreadCounter_30().start();
			}
		} catch (Exception e) {
			System.out.println("failed at:" + COUNTER.get());
		}
	}
}
