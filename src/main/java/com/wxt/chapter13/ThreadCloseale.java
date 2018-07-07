package com.wxt.chapter13;

public class ThreadCloseale extends Thread{
	//volatile 关键字保证了started线程的可见性
	private volatile boolean started = true;
	@Override
	public void run() {
		while (started) {
			//do work
			System.out.println("do working...");
		}
	}
	
	public void shutdown() {
		this.started = false;
	}
}
