package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.putDTO;

@RestController
@RequestMapping("/api/put") 
public class PutAPIController {
	
	@PutMapping("/{userId}")
	public putDTO put(@RequestBody putDTO dto, @PathVariable(name="userId") String id) {
		System.out.println(id);
		return dto;
	}
	
	// Response 내려주는 3가지 방법
	// 1.text 2. json 3.ResponseEntity(권장방법)
	@PutMapping
	public ResponseEntity<putDTO> putResponse(@RequestBody putDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
