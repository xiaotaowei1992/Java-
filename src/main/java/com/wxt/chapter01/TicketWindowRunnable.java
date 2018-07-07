package com.wxt.chapter01;

public class TicketWindowRunnable implements Runnable {
		private static final int MAX = 50;
		private  int index = 1;//不做static修飾
		@Override
		public void run() {
			while(index <= MAX){
				System.out.println(Thread.currentThread().getName()+ " 当前的号码是："+ (index++));
			    try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
   
}
