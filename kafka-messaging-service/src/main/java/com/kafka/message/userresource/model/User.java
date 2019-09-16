package com.kafka.message.userresource.model;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3504332947380859836L;
	@ApiModelProperty(notes = "The database generated User ID")
	private long id;
	@ApiModelProperty(notes = "The application-specific User First Name")
	private String firstName;
	@ApiModelProperty(notes = "The application-specific User First Name")
	private String lastName;
	@ApiModelProperty(notes = "The application-specific User Salary ")
	private Long salary;

	public User(long id, String firstName, String lastName, Long salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the salary
	 */
	public Long getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
