package com.wxt.chapter03;

import java.util.stream.IntStream;

public class ThreadYield_37 {
	public static void main(String[] args) {
		IntStream.range(0, 2).mapToObj(ThreadYield_37::create)
				.forEach(Thread::start);

	}

	private static Thread create(int index) {
		return new Thread(() -> {
			//此处被注释：则有时候1先打印，有时候0先打印。被放开则每次都是0.1
			/*if (index == 0) {
				Thread.yield();
			}*/
			System.out.println(index);
		});
	}
}
