package com.wxt.chapter04;

public class DeadLock {
	private final Object MUTEX_READ = new Object();
	private final Object MUTEX_WRITE = new Object();

	public void read() {
		synchronized (MUTEX_READ) {
			System.out.println(Thread.currentThread().getName()
					+ " get read lock");
			synchronized (MUTEX_WRITE) {
				System.out.println(Thread.currentThread().getName()
						+ " get write lock");
			}
			System.out.println(Thread.currentThread().getName()
					+ " release write lock");
		}
		System.out.println(Thread.currentThread().getName()
				+ " release read lock");
	}
	
	public void write() {
		synchronized (MUTEX_WRITE) {
			System.out.println(Thread.currentThread().getName()
					+ " get write lock");
			synchronized (MUTEX_READ) {
				System.out.println(Thread.currentThread().getName()
						+ " get read lock");
			}
			System.out.println(Thread.currentThread().getName()
					+ " release read lock");
		}
		System.out.println(Thread.currentThread().getName()
				+ " release write lock");
	}
	
	public static void main(String[] args) {
		final DeadLock deadLock = new DeadLock();
		new Thread(()->{
			while(true){
			  deadLock.read();	
			}
		},"read-thread").start();
		
		new Thread(()->{
			while(true){
			  deadLock.write();	
			}
		},"write-thread").start();
	}
}
