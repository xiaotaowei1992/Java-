package com.wxt.chapter05;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Lock_96 {
	void lock() throws InterruptedException;
	void lock(long milis) throws InterruptedException,TimeoutException;
	void unLock();
	List<Thread> getBlockedThreads();
}
