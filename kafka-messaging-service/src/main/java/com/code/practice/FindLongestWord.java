package com.code.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class FindLongestWord {

	static String[] word = { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book2", "banana" };
	static int maxLength = 0;
	static String longString = null;

	public static void main(String[] args) {
		for (String str : word) {
			if (str.length() > maxLength) {
				maxLength = str.length();
				longString = str;
			}
		}

		System.out.println(longString);
		// longest String
		Optional<String> max = Arrays.asList(word).stream().min(Comparator.comparingInt(String::length));

		System.out.println(max.get());

		// smallest string

		Optional<String> min = Arrays.asList(word).stream().min(Comparator.comparingInt(String::length));

		System.out.println(min.get());

		// count array size
		long value = Arrays.asList(word).stream().count();

		System.out.println(value);
	}
}
