package com.wxt.chapter04;

import java.util.concurrent.TimeUnit;

public class Mutex_65 {
    private final static Object MUTEX = new Object();
    public void accessResource(){
    	synchronized (MUTEX) {
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
    public static void main(String[] args) {
    	{
    		final Mutex_65 mutex = new Mutex_65();
    		for (int i = 0; i < 10; i++) {
				new Thread(mutex::accessResource).start();
			}
    	}
	}
}
