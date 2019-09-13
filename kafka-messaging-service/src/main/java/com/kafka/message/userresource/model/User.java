package com.kafka.message.userresource.model;

import java.io.Serializable;

public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504332947380859836L;
	private String firstName;
	private String lastName;
	private Long salary;

	public User(String firstName, String lastName, Long salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
