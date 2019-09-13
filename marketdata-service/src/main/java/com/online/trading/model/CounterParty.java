package com.online.trading.model;

public class CounterParty {

	private String cPartyCode;

	private String cPartyValue;

	public String getcPartyCode() {
		return cPartyCode;
	}

	public void setcPartyCode(String cPartyCode) {
		this.cPartyCode = cPartyCode;
	}

	public String getcPartyValue() {
		return cPartyValue;
	}

	public void setcPartyValue(String cPartyValue) {
		this.cPartyValue = cPartyValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cPartyCode == null) ? 0 : cPartyCode.hashCode());
		result = prime * result + ((cPartyValue == null) ? 0 : cPartyValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CounterParty other = (CounterParty) obj;
		if (cPartyCode == null) {
			if (other.cPartyCode != null)
				return false;
		} else if (!cPartyCode.equals(other.cPartyCode))
			return false;
		if (cPartyValue == null) {
			if (other.cPartyValue != null)
				return false;
		} else if (!cPartyValue.equals(other.cPartyValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CounterParty [cPartyCode=" + cPartyCode + ", cPartyValue=" + cPartyValue + "]";
	}

}
