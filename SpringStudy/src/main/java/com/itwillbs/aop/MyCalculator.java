package com.itwillbs.aop;

/**
 *   target  클래스  
 */
public class MyCalculator {

	public void add(int a,int b) {
		System.out.println("11111111111111"); // 보조기능
		System.out.println("a+b :"+(a+b) ); // 주기능
		System.out.println("22222222222222"); // 보조기능
	}
	public void sub(int a,int b) {
		System.out.println("a-b :"+(a-b) );
	}
	public void mul(int a,int b) {
		System.out.println("a*b :"+(a*b) );
	}
	public void div(int a,int b) {
		System.out.println("a/b :"+(a/b) );
	}
	
}
