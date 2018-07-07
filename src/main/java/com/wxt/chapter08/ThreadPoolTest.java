package com.wxt.chapter08;
import java.util.concurrent.TimeUnit;


public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		//定义线程池，初始化线程数2，核心线程数4，最大线程数6，任务队列最多允许1000个任务
		final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);
		//定义20个任务并提交给线程池
		for (int i = 0; i < 20; i++) {
			threadPool.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName() + " is running and done..");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			});
		}
		
		for (;;) {
			//不断获取线程池的信息
			/*System.out.println("getActiveCount=" + threadPool.getActiveCount());
			System.out.println("getQueueSize=" + threadPool.getQueueSize());
			System.out.println("getCoreSize=" + threadPool.getCoreSize());
			System.out.println("getMaxSize=" + threadPool.getMaxSize());
			System.out.println("-----------------------------------------");
			TimeUnit.SECONDS.sleep(5);*/
			
			TimeUnit.SECONDS.sleep(10);
			//线程池休眠10s后将被shutdown
			threadPool.shutdown();
			//使main线层join,方便通过工具查看线程堆栈信息
			Thread.currentThread().join();
		}
	}
}
