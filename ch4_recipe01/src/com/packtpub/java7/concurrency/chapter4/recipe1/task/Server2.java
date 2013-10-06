package com.packtpub.java7.concurrency.chapter4.recipe1.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server2 {

	private static String ServerName="Server2";
	private ThreadPoolExecutor executor;
	
	public Server2(){
		executor =  (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task2 task) {
		showMessage("A new task has arrived");
		executor.execute(task);
		
		showMessage(String.format("Pool Size: %d",executor.getPoolSize()));
		showMessage(String.format("Active Count: %d",executor.getActiveCount()));
		showMessage(String.format("Completed Tasks: %d",executor.getCompletedTaskCount()));
		
	}
	
	
	private void showMessage(String content){
		StringBuilder message = new StringBuilder();
		message.append(ServerName);
		message.append(": ");
		message.append(content);
		System.out.println(message.toString());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}
