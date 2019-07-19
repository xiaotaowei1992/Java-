package com.wxt.chapter03;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit_54 {
   public static void main(String[] args) throws InterruptedException {
	  Thread thread = new Thread(){
	   /* @Override
		public void run() {
			System.out.println("I will start work...");
			while(!isInterrupted()){
				//working..
			}
			System.out.println("I will be exiting....");
		}*/
		  
		  @Override
		public void run() {
			  System.out.println("I will start work...");
				for(;;){
					try {
						System.out.println("do working....");
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						break;
					}
				}
				System.out.println("I will be exiting....");
		}
	  };
	  thread.start();
	  TimeUnit.SECONDS.sleep(10);
	  System.out.println("System will be shutdown..");
	  thread.interrupt();
	   
    }

    @Test
    public void test() throws InterruptedException {
		Thread thread = new Thread(){
	   /* @Override
		public void run() {
			System.out.println("I will start work...");
			while(!isInterrupted()){
				//working..
			}
			System.out.println("I will be exiting....");
		}*/

			@Override
			public void run() {
				System.out.println("I will start work...");
				while (!isInterrupted()){
					System.out.println("do working....");
				}
				System.out.println("I will be exiting....");
			}
		};
		thread.start();
		TimeUnit.SECONDS.sleep(10);
		System.out.println("System will be shutdown..");
		thread.interrupt();
	}
}
