package com.wxt.chapter08;

public class RunnableDenyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RunnableDenyException(String msg){
		super(msg);
	}
}
