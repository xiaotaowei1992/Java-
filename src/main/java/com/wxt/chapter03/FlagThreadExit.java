package com.wxt.chapter03;

import java.util.concurrent.TimeUnit;

public class FlagThreadExit {
    public static void main(String[] args) throws InterruptedException {
		 MyTask task = new MyTask();
		 task.start();
		 TimeUnit.SECONDS.sleep(10);
		 System.out.println("system will be shutdown....");
		 task.close();
	}
    
    static class MyTask extends Thread{
    	private volatile boolean closed = false;
    	@Override
    	public void run() {
    		System.out.println("I will be working...");
    		while(!closed && !isInterrupted()){
    			//working...
    		}
    		System.out.println("I will be exiting");
    	}
    	public void close(){
    		this.closed = true;
    		this.interrupt();
    	}
    	
    }
    
}
