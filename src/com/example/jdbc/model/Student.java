package com.example.jdbc.model;

public class Student {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone_number;

	
	public Student(String name, String email, String phone_number) {
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number + "]";
	}
	
	
}
