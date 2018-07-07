package com.wxt.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FightQueryExample {
	// 1.合作的各大航空公司
	private static List<String> fightCompany = Arrays.asList("CSA", "CEA",
			"HNA");

	public static void main(String[] args) {
		List<String> results = search("SH", "BJ");
		System.out.println("============= result ===============");
		results.forEach(System.out::println);
	}

	private static List<String> search(String origin, String dest) {
		final List<String> result = new ArrayList<String>();
		// 2. 创建查询航班信息的线程列表
		List<FightQueryTask> tasks = fightCompany.stream()
				.map(f -> createSearchTask(f, origin, dest))
				.collect(java.util.stream.Collectors.toList());
		//3.分别启动这几个线程
		tasks.forEach(Thread::start);
		//4.分别调用每一个线程的join方法，阻塞当前进程
		tasks.forEach(t->{
			try {
				t.join();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//5.在此之前，当前线程会阻塞，获取每一个查询线程的结果，并且加入到result中
		tasks.stream().map(FightQuery::get).forEach(result::addAll);
		return result;
	}

	private static FightQueryTask createSearchTask(String flight,
			String origin, String dest) {
		return new FightQueryTask(flight, origin, dest);
	}
}
