package com.wxt.chapter03;

import org.junit.Test;

public class ThreadPriority_38 {
    public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			while(true){
				System.out.println("t1");
			}
		});
		t1.setPriority(3);
		
		Thread t2 = new Thread(()->{
			while(true){
				System.out.println("t2");
			}
		});
		t2.setPriority(10);
		t1.start();
		t2.start();
	}
    
    @Test
    public void testPriority(){
    	ThreadGroup group = new ThreadGroup("test");
    	group.setMaxPriority(7);
    	Thread thread = new Thread(group, "t1");
    	thread.setPriority(9);
    	System.out.println(thread.getPriority());
    }
    
    @Test
    public void testPriority2(){
    	Thread.currentThread().getThreadGroup().setMaxPriority(7);
    	Thread t1 = new Thread();
    	System.out.println("t1 priority:" + t1.getPriority());
    	
    	Thread t2 = new Thread(()->{
    		Thread t3 = new Thread();
    		System.out.println("t3 priority:" + t3.getPriority());
    	});
    	t2.setPriority(6);
    	t2.start();
    	System.out.println("main priority:" + t2.getThreadGroup().getMaxPriority());
    	System.out.println("t2 priority:" + t2.getPriority());
    
    }
}
