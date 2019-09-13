package com.online.trading.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commodity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long Id;
	@Column(name = "cCode")
	private String cCode;
	@Column(name = "cValue")
	private String cValue;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

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
		result = prime * result + (int) (Id ^ (Id >>> 32));
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
		if (Id != other.Id)
			return false;
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
		return "Commodity [Id=" + Id + ", cCode=" + cCode + ", cValue=" + cValue + "]";
	}

}
