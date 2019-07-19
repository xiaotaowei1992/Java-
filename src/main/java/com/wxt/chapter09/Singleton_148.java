package com.wxt.chapter09;

public class Singleton_148 {
	private static int x = 0;
	private static int y;
	private static Singleton_148 instance = new Singleton_148();
	
	
	/*private static Singleton_148 instance = new Singleton_148();
	private static int x = 0;
	private static int y;*/
	
	private Singleton_148(){
		x++;
		y++;
	}
	public static Singleton_148 getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton_148 singleton = Singleton_148.getInstance();
		System.out.println(singleton.x);
		System.out.println(singleton.y);
	}
	
	
}
