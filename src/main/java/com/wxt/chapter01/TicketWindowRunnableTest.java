package com.wxt.chapter01;

public class TicketWindowRunnableTest {
   public static void main(String[] args) {
	
	   final TicketWindowRunnable task = new TicketWindowRunnable();
	   Thread window1 = new Thread(task,"one");
	   Thread window2 = new Thread(task,"two");
	   Thread window3 = new Thread(task,"three");
	   window1.start();
	   window2.start();
	   window3.start();
}
}
