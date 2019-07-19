package com.wxt.chapter05;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class BooleadLockTest {
	//定义BooleanLock
	private final Lock_96 lock = new BooleadLock_96();
	//使用try...finally..语句块确保lock的每次都能被正确释放
	public void syncMethod() {
		try {
			lock.lock();
			int randomInt = ThreadLocalRandom.current().nextInt(10);
			System.out.println(Thread.currentThread() + "  get the lock...");
			TimeUnit.SECONDS.sleep(randomInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
		}
	}
	
	public static void main(String[] args) {
		/*BooleadLockTest test = new BooleadLockTest();
		IntStream.range(0, 10).mapToObj(i-> new Thread(test::syncMethod)).forEach(Thread::start);;
	    */
		try {
			test();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void test() throws InterruptedException{
		BooleadLockTest test = new BooleadLockTest();
		new Thread(test::syncMethod,"t1").start();
		TimeUnit.SECONDS.sleep(1);
		Thread t2 = new Thread(test::syncMethod,"t2");
		t2.start();
		TimeUnit.SECONDS.sleep(10);
		t2.interrupt();
		
	}
}
