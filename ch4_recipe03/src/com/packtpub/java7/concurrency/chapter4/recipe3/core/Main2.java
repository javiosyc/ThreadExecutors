package com.packtpub.java7.concurrency.chapter4.recipe3.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.packtpub.java7.concurrency.chapter4.recipe3.task.SummationCalculator;

public class Main2 {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor)  Executors.newFixedThreadPool(2); 

		
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		
		Random random = new Random();
		
		
		SummationCalculator calculator1=new SummationCalculator(100);
		
		Future<Integer> result1=executor.submit(calculator1);
		resultList.add(result1);
		// Create and send to the executor the ten tasks
		for (int i=1; i<10; i++){
			Integer number=new Integer(random.nextInt(10));
			SummationCalculator calculator=new SummationCalculator(number);
			
			Future<Integer> result=executor.submit(calculator);
			resultList.add(result);
			
		}
		
		// Write the results
		System.out.printf("Main: Results\n");
		for (int i=0; i<resultList.size(); i++) {
			Future<Integer> result=resultList.get(i);
			Integer number=null;
			try {
				number=result.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.printf("Core: Task %d: %d\n",i,number);
		}
		
		// Shutdown the executor
		executor.shutdown();

	}

}
