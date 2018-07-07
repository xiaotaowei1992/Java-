package com.wxt.chapter01;

public class TicketWindow extends Thread {
	// 柜台名称
	private String name;
	// 最多受理50个业务
	private static final int MAX = 50;
	private static int index = 1;
	public TicketWindow(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		while(index <= MAX){
			System.out.println("柜台："+ name + " 当前的号码是："+ (index++));
		}
	}
}
