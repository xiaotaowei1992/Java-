package com.wxt.chapter03;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadisInterrupted_43 {
    public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(){
			@Override
			public void run() {
              while(true){
            	  //do no thing,just empty loop
              }
			}
		};
		thread.start();
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.printf("Thread is interrupt? %s\n",thread.isInterrupted());
		thread.interrupt();
		System.out.printf("Thread is interrupt? %s\n",thread.isInterrupted());
	}
    
    @Test
    public void test() throws InterruptedException{
    	Thread thread = new Thread(){
    		@Override
    		public void run() {
    			while(true){
    				try {
						TimeUnit.MINUTES.sleep(1);
					} catch (InterruptedException e) {
						//ignore the exception
						System.out.printf("Thread is interrupt1? %s\n",isInterrupted());
					}
    			}
    		}
    	};
    	thread.setDaemon(true);
    	thread.start();
    	TimeUnit.MILLISECONDS.sleep(2);
    	System.out.printf("Thread is interrupt2? %s\n",thread.isInterrupted());
		thread.interrupt();
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.printf("Thread is interrupt3? %s\n",thread.isInterrupted());
    	
    }
}
