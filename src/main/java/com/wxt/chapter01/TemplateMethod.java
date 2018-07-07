package com.wxt.chapter01;

/**
 * @author Administrator
 *  模板方法在Thread中的运用
 */
public class TemplateMethod {
	
	public final void print(String msg){
		System.out.println("#######################");
		wrapPrint(msg);
		System.out.println("#######################");
	}
	
	protected void wrapPrint(String msg){}
    
	
	public static void main(String[] args) {
		TemplateMethod t1 = new TemplateMethod(){
			@Override
			protected void wrapPrint(String msg) {
				System.out.println("-----" + msg + "---------");
			}
		};
		t1.print("hello");
		
		TemplateMethod t2 = new TemplateMethod(){
			@Override
			protected void wrapPrint(String msg) {
				System.out.println("========" + msg + "========");
			}
		};
		t2.print("world");
	}
}
