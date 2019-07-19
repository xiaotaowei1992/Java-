package com.wxt.chapter10;

public class BootStrapClassLoader_160 {
	public static void main(String[] args) {
		System.out.println("BootStrap:" + String.class.getClassLoader());
		//根加载器所在的加载路径
		System.out.println(System.getProperty("sun.boot.class.path"));
		//拓展类加载器所在的类库
		System.out.println(System.getProperty("java.ext.dirs"));
	}
}
