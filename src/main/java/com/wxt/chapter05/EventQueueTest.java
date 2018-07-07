package com.wxt.chapter05;
import java.util.concurrent.TimeUnit;


public class EventQueueTest {
   public static void main(String[] args) {
   final EventQueue eventQueue = new EventQueue();
   new Thread(() -> {
	   for(;;){
		   eventQueue.offer(new EventQueue.Event());
	   }
   },"producer").start();
   
   new Thread(() -> {
	   for(;;){
		   eventQueue.take();
		   try {
			TimeUnit.MILLISECONDS.sleep(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
   },"consumer").start();
}
}
