package com.wxt.chapter05;

import java.util.LinkedList;

public class EventQueue {
	private final int max;
	static class Event {
		
	}
	private final LinkedList<Event> eventQueue = new LinkedList<Event>();
	private final static int DEFAULT_MAX_EVENT=10;
	
	public EventQueue(){
		this(DEFAULT_MAX_EVENT);
	}
	private EventQueue(int max){
		this.max = max;
	}
	/*public void offer(Event event){
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
	}*/
	
	//改进版
	public void offer(Event event){
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
	
	public Event take(){
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
}
