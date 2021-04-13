package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class postDTO {
	private String accout;
	private String email;
	private String pw;
	@JsonProperty("phone_number")
	private String phoneNumber; //Json에서 카멜케이스가 아닌 스네이크케이스로 보내는 경우 @JsonProperty("phone_number")를 이용하여 스네이크케이스를 받을 수 있다. 하지만 카멜케이스로는 받을 수 없다.
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "postDTO [accout=" + accout + ", email=" + email + ", pw=" + pw + ", phoneNumber=" + phoneNumber + "]";
	}

}
