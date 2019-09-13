package com.online.trading.constant;

public enum CounterParty {

	LOREM("Lorem"), LPSUM("Lpsum"), SIT("Sit"), AMET("Amet"), CONSECTITOR("Consectitor"), ADISIPING("Adisiping"),
	DOLOR("Dolor");

	private final String party;

	CounterParty(String party) {
		this.party = party;
	}

	public String getCounterParty() {
		return this.party;
	}
}
