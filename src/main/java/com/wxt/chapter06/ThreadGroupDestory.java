package com.wxt.chapter06;

public class ThreadGroupDestory {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("TestGroup");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("mainGroup.isDestoryed=" + mainGroup.isDestroyed());
		mainGroup.list();
		
		group.destroy();
		System.out.println("group.isDestoryed=" + group.isDestroyed());
		mainGroup.list();
	}
}
