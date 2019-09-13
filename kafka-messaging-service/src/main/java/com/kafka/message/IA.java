package com.kafka.message;

public interface IA {

	default void print() {
		System.out.println("Print IA");
	}
}
