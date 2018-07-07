package com.wxt.chapter01;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TryConcurrency {
	public static void main(String[] args) {
		/*browseNews();
		enjoyMusic();*/
		
		//匿名内部类创建的方式创建线程，并且重写run方法
		new Thread(){
			@Override
			public void run() {
				enjoyMusic();
			};
		}.start();
		browseNews();
		
		/*//1.8 Lambda方式
		new Thread(TryConcurrency::enjoyMusic).start();
		browseNews();*/
	}

	/**
	 * Browse the latest news
	 */
	private static void browseNews() {
		for (;;) {
			System.out.println("browse the news....");
			sleep(1);
		}
	}

	/**
	 * Listening and enjoy the music
	 */
	private static void enjoyMusic() {
		for (;;) {
			System.out.println("enjoy the music....");
			sleep(1);
		}
	}

	/**
	 * Simulate the wait and ignore the exception
	 * 
	 * @param seconds
	 */
	private static void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStart() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		thread.start();
		//TimeUnit.SECONDS.sleep(2);
		thread.start();
	}
}
