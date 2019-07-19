package com.wxt.chapter06;

public class ThreadGroupCreator_106 {
	public static void main(String[] args) {
		//1.获取当前线程的group
		ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
		//2.定义一个新的group
		ThreadGroup group = new ThreadGroup("Group01");
		//3. -> true
		System.out.println(group.getParent() == currentGroup );
		
		//4.定义group2，指定group1为其父group
		ThreadGroup group2 = new ThreadGroup(group, "Group02");
		//5.-> true
		System.out.println(group2.getParent() == group);
	}
}
