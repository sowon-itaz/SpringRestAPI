package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) //null값은 빼고 body에 담는다.
public class Car {
	private String carName;
	private int carNumber;
	private Integer price; //int는 default값이 0이고 Integer는 null이다.
	
	//디폴트 생성자
	public Car() {
		this.carName = null;
		this.carNumber = 0;
		this.price = null;
	}
	
	public Car(String carName, int carNumber, Integer price) {
		super();
		this.carName = carName;
		this.carNumber = carNumber;
		this.price = price;
	}
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carNumber=" + carNumber + ", price=" + price + "]";
	}
}
