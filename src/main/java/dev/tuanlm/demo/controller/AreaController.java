package dev.tuanlm.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.tuanlm.demo.models.Quarter;
import dev.tuanlm.demo.service.AreaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/area")
@CrossOrigin(origins = "http://localhost:8081")
public class AreaController {
	
	private AreaService service;
	
	@GetMapping("/get-quarter")
	public ResponseEntity<List<Quarter>> getQuarterByArea(@RequestParam int areaId) {
		return new ResponseEntity<List<Quarter>>(service.getQuarters(areaId), HttpStatus.OK);
	}
}
