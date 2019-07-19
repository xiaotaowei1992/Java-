package com.wxt.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreadGroups_109 {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group1 = new ThreadGroup("group1");
		ThreadGroup group2 = new ThreadGroup(group1, "group2");
		
		TimeUnit.SECONDS.sleep(5);
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		
		ThreadGroup[] list = new ThreadGroup[mainGroup.activeGroupCount()];
		
		int recurseSize = mainGroup.enumerate(list);
		System.out.println(recurseSize);
		
		recurseSize = mainGroup.enumerate(list, false);
		System.out.println(recurseSize);
	}
}
