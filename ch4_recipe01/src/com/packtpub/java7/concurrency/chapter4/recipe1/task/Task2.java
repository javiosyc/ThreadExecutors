package com.packtpub.java7.concurrency.chapter4.recipe1.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task2 implements Runnable {

	private Date initDate;
	private String name;
	
	public Task2(String name){
		this.name=name;
		this.initDate = new Date();
	}
	@Override
	public void run() {
				
		showLog("Created on",name,initDate);
		showLog("Started on",name,new Date());
				
		try {
			sleepRandomSeconds(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		showLog("Finished on",name,new Date());
	}

	private  void sleepRandomSeconds(int maxSecond) throws InterruptedException {
		Long duration=(long)(Math.random()*maxSecond);
		
		System.out.printf("%s: Task %s: Doing a task during %dseconds\n"
				,Thread.currentThread().getName(),name,duration);
		TimeUnit.SECONDS.sleep(duration);
	}
	
	private void showLog(String msg ,String name ,Date date){
		System.out.printf
		("%s: Task %s: %s:%s\n",Thread.currentThread().getName(),name,msg,date);
	}
}
