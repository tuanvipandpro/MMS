package dev.tuanlm.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.tuanlm.demo.models.MList;
import dev.tuanlm.demo.service.ListService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/list")
@CrossOrigin(origins = "http://localhost:8081")
public class ListController {
	
	private ListService service;
	
	@GetMapping("/get-by-type-year")
	public ResponseEntity<MList> getByYearAndType(@Valid @RequestParam int type, @RequestParam String year) {
		return new ResponseEntity<MList>(service.getListByYearAndType(type, year), HttpStatus.OK);
	}
}
