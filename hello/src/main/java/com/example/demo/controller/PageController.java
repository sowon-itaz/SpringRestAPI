package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Car;

@Controller //html 리소스파일을 찾는 컨트롤러
public class PageController {
	
	@RequestMapping("/main")
	public String main() {
		return "main.html"; //@Controller을 사용하면 text가 아닌 해당 String값의 html파일을 찾아서 리턴한다.
	}
	
	//ResponseEntity
	@ResponseBody
	@GetMapping("/car")
	public Car car() {
		Car car = new Car();
		car.setCarName("마티즈");
		car.setCarNumber(123456);
		return car;
	}
	
}
