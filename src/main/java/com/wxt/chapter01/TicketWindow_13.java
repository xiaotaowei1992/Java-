package com.wxt.chapter01;

public class TicketWindow_13 extends Thread {
	// 柜台名称
	private String name;
	// 最多受理50个业务
	private static final int MAX = 50;
	private static int index = 1;
	//private  int index = 1;
	public TicketWindow_13(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		while(index <= MAX){
			System.out.println("柜台："+ name + " 当前的号码是："+ (index++));
		}
	}

	public static void main(String[] args) {
		TicketWindow_13 t1 = new TicketWindow_13("one");
		t1.start();
		TicketWindow_13 t2 = new TicketWindow_13("two");
		t2.start();
		TicketWindow_13 t3 = new TicketWindow_13("three");
		t3.start();
	}
}
