package dev.tuanlm.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.tuanlm.demo.models.PeopleAreaModel;
import dev.tuanlm.demo.request.CreatePeopleRequest;
import dev.tuanlm.demo.response.GetPeopleResponse;
import dev.tuanlm.demo.service.PeopleService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/people")
public class PeopleController {
	
	private PeopleService service;
	
	@GetMapping("/getByArea")
	public ResponseEntity<GetPeopleResponse> getPeople(@RequestParam int areaId, @RequestParam int pageNum, @RequestParam int pageNo) {
		return new ResponseEntity<>(service.getByAreaPaging(areaId, pageNum, pageNo), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<PeopleAreaModel> addPeople(@RequestBody CreatePeopleRequest request) {
		return new ResponseEntity<PeopleAreaModel>(service.createPeople(request), HttpStatus.OK);
	}
}
