package com.itwillbs.aop;

import javax.inject.Inject;

import org.springframework.aop.framework.ProxyFactoryBean;

public class CalTest {

	@Inject
	private ProxyFactoryBean bean;

	public static void main(String[] args) {
		
		MyCalculator cal = new MyCalculator();
		
		cal.add(100, 200);

		//System.out.println(bean);
		
		
	}

}
