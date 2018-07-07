package com.wxt.chapter09;

import java.util.Random;

public class GlobalConstants {
	static {
		System.out.println("The GlobalConstants will be initiialized.");
	}
	
	//在其他类中使用MAX不会导致GlobalConstants的初始化，静态代码块不会输出
	public final static int MAX = 100;
	
	//虽然RANDOM是静态常量，但是由于计算复杂，只有初始化之后才能得到结果，因此在其他类中使用RANDOM也会导致GlobalConstants的初始化
	private final static int RANDOM = new Random().nextInt();
}
