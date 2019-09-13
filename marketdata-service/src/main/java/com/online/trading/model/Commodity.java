package com.online.trading.model;

public class Commodity {

	private String cCode;
	private String cValue;

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getcValue() {
		return cValue;
	}

	public void setcValue(String cValue) {
		this.cValue = cValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cCode == null) ? 0 : cCode.hashCode());
		result = prime * result + ((cValue == null) ? 0 : cValue.hashCode());
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
		Commodity other = (Commodity) obj;
		if (cCode == null) {
			if (other.cCode != null)
				return false;
		} else if (!cCode.equals(other.cCode))
			return false;
		if (cValue == null) {
			if (other.cValue != null)
				return false;
		} else if (!cValue.equals(other.cValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commodity [cCode=" + cCode + ", cValue=" + cValue + "]";
	}

}
