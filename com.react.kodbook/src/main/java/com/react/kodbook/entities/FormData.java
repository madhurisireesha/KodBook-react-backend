package com.react.kodbook.entities;

public class FormData {
	String username;
	String email;
	String password;
	String dob;
	String gender;
	public FormData(String username, String email, String password, String dob, String gender) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
	}
	public FormData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "FormData [username=" + username + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ ", gender=" + gender + "]";
	}
	
}
