package com.wxt.chapter07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class PreventDuplicated_123 {
	private final static String LOCK_PATH="D:/study/code/locks";
	private final static String LOCK_FILE=".lock";
	private final static String PERMISSIONS = "rw-------";
	
	
	public static void main(String[] args) throws IOException {
		//1.注入Hook线程，在程序退出时候删除lock文件
		Runtime.getRuntime().addShutdownHook(new Thread(()->{
			System.out.println("the program received kill signal...");
			getLockFile().toFile().delete();
		}));
		
		//2.检测是否存在lock文件
		checkRunning();
		
		//3.简单模拟当前程序正在运行
		for (;;) {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("program is running...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private static void checkRunning() throws IOException {
		Path path = getLockFile();
		if (path.toFile().exists()) {
			throw new RuntimeException("The program already running..");
		}
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
		Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
		
	}


	private static Path getLockFile() {
		// TODO Auto-generated method stub
		return Paths.get(LOCK_PATH, LOCK_FILE);
	}
}
