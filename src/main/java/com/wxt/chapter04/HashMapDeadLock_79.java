package com.wxt.chapter04;

import java.util.HashMap;

public class HashMapDeadLock_79 {
	private final HashMap<String, String> map = new HashMap<String, String>();
	
	private void add(String key,String value){
		this.map.put(key, value);
	}
	
	public static void main(String[] args) {
		final HashMapDeadLock_79 deadLock1 = new HashMapDeadLock_79();
		for (int i = 0; i <2; i++) {
			new Thread(()->{
				for(int j=0;j<Integer.MAX_VALUE;j++){
					deadLock1.add(String.valueOf(j),String.valueOf(j));
				}
			}).start();
			
		}
	}

}
