package com.packtpub.java7.concurrency.chapter4.recipe3.task;

import java.util.concurrent.Callable;

public class SummationCalculator implements Callable<Integer> {

	private Integer number ;
	
	
	public SummationCalculator(Integer number) {
		this.number= number;
	}
	
	@Override
	public Integer call() throws Exception {
		int num,result;
		
		num = number.intValue();
		result = 0;
		
		
		for (int i=1; i<=num; i++) {
				result+=i;
				Thread.sleep(20);
		}
		
		System.out.printf("%s: %d\n",Thread.currentThread().getName(),result);
		return result;
	}	
}
