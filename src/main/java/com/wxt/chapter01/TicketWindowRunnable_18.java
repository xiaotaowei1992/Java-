package com.wxt.chapter01;

public class TicketWindowRunnable_18 implements Runnable {
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

	public static void main(String[] args) {

		final TicketWindowRunnable_18 task = new TicketWindowRunnable_18();
		Thread window1 = new Thread(task,"one");
		Thread window2 = new Thread(task,"two");
		Thread window3 = new Thread(task,"three");
		window1.start();
		window2.start();
		window3.start();
	}
   
}
