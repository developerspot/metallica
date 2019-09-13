package com.kafka.message;

public class ImplAB implements IA, IB {

	@Override
	public void print() {
		IB.super.print(); // Diamond problem resolved
		System.out.println("print ImplAB");
	}

	public static void main(String[] args) {
		ImplAB ab = new ImplAB();
		ab.print();
	}
}
