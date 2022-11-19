package dev.tuanlm.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/people")
public class PeopleController {
	
	@GetMapping("/check")
	public ResponseEntity<String> getJwtToken() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
