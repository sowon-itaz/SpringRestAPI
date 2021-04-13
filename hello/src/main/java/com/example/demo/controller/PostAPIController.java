package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.postDTO;

@RestController // 의미: 해당 class는 REST API 처리하는 Controller다.
@RequestMapping("/api/post") // URI를 지정해주는 어노테이션이다. get/post/put/delete다 작동함 
public class PostAPIController {
	
	// post로 보낼때는 바디에 데이터를 실어보낸다고 표현도 함
	// post로 보낼때는 @RequestBody 꼭 붙여줘야함
	
	// Map으로 받으면 어떤 데이터가 들어오는 지 한 눈에 확인이 불가능하기때문에 DTO를 사용하는 것이 좋다.
	@PostMapping("")
	public void post(@RequestBody Map<String, String> requestData) {
		requestData.entrySet().forEach( stringObjectEntry -> {
			System.out.println(stringObjectEntry.getKey() + " : "+ stringObjectEntry.getValue());
		});
	}
	
	@PostMapping("/postdto")
	public void postDTO(@RequestBody postDTO dto) {
		System.out.println(dto);
	}
}
