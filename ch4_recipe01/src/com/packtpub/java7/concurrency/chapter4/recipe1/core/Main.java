package com.packtpub.java7.concurrency.chapter4.recipe1.core;

import com.packtpub.java7.concurrency.chapter4.recipe1.task.Server2;
import com.packtpub.java7.concurrency.chapter4.recipe1.task.Task2;

/**
 * Main class of the example. Creates a server and 100 request of the Task class
 * that sends to the server
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the server
		Server2 server=new Server2();
		
		// Send 100 request to the server and finish
		for (int i=0; i<10; i++){
			Task2 task=new Task2("Task "+i);
			server.executeTask(task);
		}
		
		server.endServer();

	}

}
