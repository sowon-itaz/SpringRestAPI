package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class putDTO {
	private String name;
	private int age;
	private List<Car> carList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Car> getCarList() {
		return carList;
	}
	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	@Override
	public String toString() {
		return "putDTO [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}
}
/*
{
  "name":"스티브",
  "age":20,
  "car_list":[
    {
    "car_name":"BMW",
    "car_number":1234
    },
    {
    "car_name":"BMW2",
    "car_number":4321
    }
  ]
}
 */
