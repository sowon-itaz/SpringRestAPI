package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		
		//Object -> text(json형태)로 바꿀때는 ObjectMapper가 getter를 활용한다.
		// ObjectMapper를 사용한다면 참조클래스에 변수명/함수명지을때 get으로 시작하면 안된다.
		ObjectMapper om = new ObjectMapper();
		Car car = new Car("SM", 1234, 3500); //getter가 필수적으로 있어야함
		String text = om.writeValueAsString(car);
		System.out.println(text);
		
		//text(json형태) -> Object로 바꿀때는 디폴트 생성자필요
		Car ou = om.readValue(text, Car.class);
		System.out.println(ou);
		
		
	}

}
