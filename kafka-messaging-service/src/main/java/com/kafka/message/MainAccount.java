package com.kafka.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainAccount {

	public static void main(String[] args) {
		List<Account> accountList = new ArrayList<Account>();
		Account a = new Account("Amit");
		Account b = new Account("Sumit");
		Account c = new Account("Pankaj");
		accountList.add(a);
		accountList.add(b);
		accountList.add(c);
		accountList.forEach(ac -> {
			System.out.println(ac.getName());
		});

		accountList.sort((Account a1, Account a2) -> a1.getName().compareTo(a2.getName()));
		accountList.forEach(ac -> {
			System.out.println(ac.getName());
		});

		Map<Account, Account> maps = new HashMap<>();
		maps.put(a, a);
		maps.put(b, b);
		maps.put(c, c);

		LinkedHashMap<Account, Account> collect = maps.entrySet().stream().sorted()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		System.out.println(collect);
	}
}
