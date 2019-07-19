package com.wxt.chapter04;

public class TicketWindowRunnable_64 implements Runnable {
		private static final int MAX = 500;
		private int index = 1;//不做static修飾
		
		private static final Object MUTEX = new Object();
		@Override
		public void run() {
			synchronized (MUTEX) {
				while(index <= MAX){
					System.out.println(Thread.currentThread().getName()+ " 当前的号码是："+ (index++));
				    try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
   
		public static void main(String[] args) {
		   final TicketWindowRunnable_64 task = new TicketWindowRunnable_64();
		   Thread window1 = new Thread(task,"one");
		   Thread window2 = new Thread(task,"two");
		   Thread window3 = new Thread(task,"three");
		   window1.start();
		   window2.start();
		   window3.start();
		}
}
