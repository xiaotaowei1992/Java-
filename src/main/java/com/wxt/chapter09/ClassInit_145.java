package com.wxt.chapter09;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ClassInit_145 {
	static {
		
		try {
			System.out.println("The classInit static code block will be invoke.");
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//父类中有静态变量value
	static class Parent{
		static int value = 10;
		static {
			value = 20;
		}
	}
	//子类使用父类的静态变量为自己的静态变量复制
	static class Child extends Parent {
		static int i = value;
	}
	
	public static void main(String[] args) {
		System.out.println(Child.i);
		IntStream.range(0, 5).forEach(i->new Thread(ClassInit_145::new));
	}
}
