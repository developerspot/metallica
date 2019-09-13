package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyBlockingQueue {

	public static void main(String[] args) {

		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);
		Producer producer = new Producer(queue, threadLocal);
		Consumer consumer = new Consumer(queue, threadLocal);

		new Thread(consumer).start();
		new Thread(producer).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Array Blocking Queue Completed !!");
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
		Producer producer2 = new Producer(blockingQueue, threadLocal);
		Consumer consumer2 = new Consumer(blockingQueue, threadLocal);

		new Thread(producer2).start();
		new Thread(consumer2).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Linked Blocking Queue Completed !!");
	}
}

class Consumer implements Runnable {

	private BlockingQueue<String> blockingQueue;
	private ThreadLocal<String> threadLocal;

	public Consumer(BlockingQueue<String> blockingQueue, ThreadLocal<String> threadLocal) {
		this.blockingQueue = blockingQueue;
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 12; i++) {
				System.out.println(blockingQueue.take() + ", " + threadLocal.get());
			}
		} catch (InterruptedException e) {

		}
	}
}

class Producer implements Runnable {

	private BlockingQueue<String> blockingQueue;
	private ThreadLocal<String> threadLocal;

	public Producer(BlockingQueue<String> blockingQueue, ThreadLocal<String> threadLocal) {
		this.blockingQueue = blockingQueue;
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 12; i++) {
				blockingQueue.put("Pankaj" + i );
				threadLocal.set("ThreadLocal"+i);
				
			}
		} catch (InterruptedException e) {
		}
	}
}
