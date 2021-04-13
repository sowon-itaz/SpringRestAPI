package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userRequest;

@RestController // 의미: 해당 class는 REST API 처리하는 Controller다.
@RequestMapping("/api/get") // URI를 지정해주는 어노테이션이다. get/post/put/delete다 작동함 
public class GetAPIController {
	
	// @RequestMapping를 사용하면 get/post/put/delete 다 작동가능
	// method속성을 이용하여 한 가지방식을 선택할 수 있음  => 옛날방식으로 요즘은 GetMapping을 사용함
	@RequestMapping(path="/hi", method= RequestMethod.GET) 
	public String getHi() {
		return "하이 getHi @RequestMapping사용";
	}

	// http://localhost:9090/api/get/hello
	@GetMapping(path="/hello") 
	public String getHello() {
		return "헬로 getHello @GetMapping사용";
	}
	
	// PathVariable
	// http://localhost:9090/api/get/path-variable/{name}
	@GetMapping("/path-variable1/{name}")
	public String pathVariable1(@PathVariable String name) {
		System.out.println("pathVariable1: "+name);
		return name;
	}
	
	// PathVariable 이용시 이름 매칭이 어려울시 // PathVariable(name="")속성을 이용하면 된다.
	// 기존에 받아와야할 인수명이 name인경우 PathVariable 이름과도 중복이 된다.
	// 이때  PathVariable(name="name")속성을 이용하여  @GetMapping의 {name}과 동일하게 처리해준다.
	@GetMapping("/path-variable2/{name}")
	public String pathVariable2(@PathVariable(name="name") String pathName, String name) {
		System.out.println("pathVariable2: "+pathName);
		return pathName;
	}
	
	// Query parameter
	// 주로 검색할때 사용하는 인자로 URL의 물음표(?)의 뒷부분으로 &연산자를 기준으로 키=밸류 값이 이어진다.
	// @RequestParam을 꼭 붙여줘야한다.	
	// http://localhost:9090/api/get/query-param?user=소원데브&email=sowon-dev@이메일.com&age=77
	@GetMapping("/query-param")
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		StringBuilder sb = new StringBuilder();
		
		// @RequestParam인자를 Map을 사용한 경우 아무 인자 다 받을 수 있어서 key값이 명시적인경우 get으로 이름을 지정해서 사용해야한다.
		// 이메일을 불러오는 경우
		// queryParam.get("email");
		// 명시적인 인자의 경우 아래 queryParam2를 사용하는 것이 좋다
		
		queryParam.entrySet().forEach( entry -> {			
			sb.append(entry.getKey() + " : " + entry.getValue()+"\n");
			System.out.println(sb.toString());
		});
		return sb.toString();
	}
	
	// @RequestParam인자를 Map을 사용한 경우 아무 인자 다 받을 수 있어서 key값이 명시적인경우 
	// 받을 수 있는 인자가 명확하다면 아래처럼 명시적으로 인자를 받는 것이 좋다.
	// 명시적인 경우 int형에 문자열을 넣으면 에러 발생 -> 클라이언트 에러인것을 확인할 수 있다.
	// 파람이 3개이상되면 너무 많아지므로 DTO를 만들어서 처리하는 것이 좋다.
	@GetMapping("/query-param2")
	public String queryParam2(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age
			) {
		return name+" / "+email+" / "+age;
	}
	
	// 가장 추천하는 방법
	// 중요한 점은 @RequestParam를 붙이지 않는다
	// http://localhost:9090/api/get/query-param3?name=소원데브&email=sowon-dev@이메일.com&age=77
	@GetMapping("/query-param3")
	public String queryParam2(userRequest user) {
		return user.toString();
	}
	
}
