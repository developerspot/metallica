package com.thread;

public class MyRunnable implements Runnable {

	private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	private InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
	@Override
	public void run() {

		threadLocal.set( (int) (Math.random() * 100D) );
		local.set(new Object().toString());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		System.out.println(threadLocal.get());
		System.out.println(local.get());
	}

	public static void main(String[] args) {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread t1 = new Thread(sharedRunnableInstance);
		Thread t2 = new Thread(sharedRunnableInstance);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
