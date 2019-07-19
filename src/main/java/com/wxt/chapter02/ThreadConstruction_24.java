package com.wxt.chapter02;

import java.util.stream.IntStream;

public class ThreadConstruction_24 {
	public static void main(String[] args) {

		IntStream.range(0,5).boxed().map(i->
				new Thread(()-> System.out.println(Thread.currentThread().getName()))).forEach(Thread::start);
		Thread t1 = new Thread("t1");
		ThreadGroup group = new ThreadGroup("TestGroup");
		Thread t2 = new Thread(group, "t2");
		ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
		System.out.println("Main thread belong group:" + mainThreadGroup.getName());
		System.out.println("t1 and main belong the same group:" + (mainThreadGroup == t1.getThreadGroup()));
		System.out.println("t2 thread group not belong main group:" + (mainThreadGroup == t2.getThreadGroup()));
		System.out.println("t2 thread group belong TestGroup:" + (group== t2.getThreadGroup()));
		
	}

}
