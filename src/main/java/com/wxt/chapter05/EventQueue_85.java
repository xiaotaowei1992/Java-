package com.wxt.chapter05;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class EventQueue_85 {
	private final int max;
	static class Event {
		
	}
	private final LinkedList<Event> eventQueue = new LinkedList<Event>();
	private final static int DEFAULT_MAX_EVENT=10;
	
	public EventQueue_85(){
		this(DEFAULT_MAX_EVENT);
	}
	private EventQueue_85(int max){
		this.max = max;
	}
	public void offer(Event event){
		synchronized (eventQueue) {
			if(eventQueue.size() >= max){
				try {
					console(" the queue is full...");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			console(" the new envent is submitted");
			eventQueue.addLast(event);
			eventQueue.notify();
		}
	}
	
	public Event take(){
		synchronized (eventQueue) {
			if(eventQueue.isEmpty()){
				try {
					console(" the queue is empty...");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Event event = eventQueue.removeFirst();
			this.eventQueue.notify();
			console(" the event " + event + " is handled...");
			return event;
		}
	}
	
	//改进版
	public void offer_up(Event event){
		synchronized (eventQueue) {
			while(eventQueue.size() >= max){
				try {
					console(" the queue is full...");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			console(" the new envent is submitted");
			eventQueue.addLast(event);
			eventQueue.notifyAll();
		}
	}
	
	public Event take_up(){
		synchronized (eventQueue) {
			while(eventQueue.isEmpty()){
				try {
					console(" the queue is empty...");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Event event = eventQueue.removeFirst();
			this.eventQueue.notifyAll();
			console(" the event " + event + " is handled...");
			return event;
		}
	}
	private void console(String message){
		System.out.printf("%s:%s\n",Thread.currentThread().getName(),message);
	}

	public static void main(String[] args) {
		final EventQueue_85 eventQueue = new EventQueue_85();
		new Thread(() -> {
			for(;;){
				eventQueue.offer(new EventQueue_85.Event());
			}
		},"producer").start();

		new Thread(() -> {
			for(;;){
				eventQueue.take();
				try {
					TimeUnit.MILLISECONDS.sleep(3);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"consumer").start();
	}

	@Test
	public void test() {
		final EventQueue_85 eventQueue = new EventQueue_85();
		new Thread(() -> {
			for(;;){
				eventQueue.offer_up(new EventQueue_85.Event());
			}
		},"producer").start();

		new Thread(() -> {
			for(;;){
				eventQueue.take_up();
				try {
					TimeUnit.MILLISECONDS.sleep(3);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"consumer").start();
	}
}
