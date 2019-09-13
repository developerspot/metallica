package com.online.trading;

class Test extends Thread {

	@Override
	public void run() {
		System.out.println("hello");
	}

	int add(int i, int o) {
		return i + o;
	}
}

public class ABC extends Test {
	double add(double a, double b) {
		return a;
	}

	public static void main(String[] args) {
		ABC a = new ABC();
		double n = 10;
		int m = 1;
		System.out.println(a.add(n, m));

		Test tt = new Test();
		tt.start();
	}
}
