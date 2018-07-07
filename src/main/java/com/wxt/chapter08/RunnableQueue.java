package com.wxt.chapter08;

/**
 * @author Administrator
 * 任务队列，主要用于缓存提交到线程池的任务
 */
public interface RunnableQueue {
	/**
	 * 当有新任务进来时，首先会offer到队列中
	 */
	void offer(Runnable runnable);
	
	/**
	 * 工作线程通过take方法，获取Runnable
	 */
	Runnable take();
	
	/**
	 * 获取任务队列中任务的数量
	 */
	int size();
}
