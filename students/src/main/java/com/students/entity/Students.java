package com.students.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@javax.persistence.Id
	@Column(name = "id")
	private int Id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String standard;

	private String divison;

	private String gender;

	private int age;

	public Students() {
		// TODO Auto-generated constructor stub
	}

	public Students(int id, String firstName, String lastName, String standard, String divison, String gender,
			int age) {
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.standard = standard;
		this.divison = divison;
		this.gender = gender;
		this.age = age;
	}

	
	public Students(String firstName, String lastName, String standard, String divison, String gender, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.standard = standard;
		this.divison = divison;
		this.gender = gender;
		this.age = age;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivison() {
		return divison;
	}

	public void setDivison(String divison) {
		this.divison = divison;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}