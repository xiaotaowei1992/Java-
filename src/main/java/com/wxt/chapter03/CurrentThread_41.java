package com.wxt.chapter03;

public class CurrentThread_41 {
  public static void main(String[] args) {
	 Thread thread = new Thread(){
		 @Override
		public void run() {
			System.out.println(Thread.currentThread() == this);
		}
	 };
	 thread.start();
	 String name = Thread.currentThread().getName();
	 System.out.println("main".equals(name));
			 
	  
}
}
