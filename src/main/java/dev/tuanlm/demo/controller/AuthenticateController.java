package dev.tuanlm.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.tuanlm.demo.request.LoginRequest;
import dev.tuanlm.demo.response.LoginResponse;
import dev.tuanlm.demo.service.AccountService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticateController {
	
	private AccountService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> getJwtToken(@RequestBody @Valid LoginRequest request) {
		LoginResponse response = service.getTokenByUsernameAndPassword(request);
		return response != null 
						? new ResponseEntity<LoginResponse>(response , HttpStatus.OK) 
						: new ResponseEntity<LoginResponse>(HttpStatus.FORBIDDEN);
	}
}
