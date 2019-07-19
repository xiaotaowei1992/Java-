package com.wxt.chapter03;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadInterrupted_45 {
	public static void main(String[] args) {

		// 1. 判断当前线程是否被中断
		System.out.println("Main thread is interrupted? " + Thread.interrupted());
		//2.中断当前线程
		Thread.currentThread().interrupt();
		//3.判断当前线程是否已经被中断
		System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());

		try {
			//4.当前线程执行可中断方法
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			//5.捕获中断信号
			System.out.println("I will be interrupted still");
		}
	}

	@Test
	public void test() throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println(Thread.interrupted());
				}
			}
		};

		thread.setDaemon(true);
		thread.start();
		TimeUnit.MILLISECONDS.sleep(2);
		thread.interrupt();
	}
}
