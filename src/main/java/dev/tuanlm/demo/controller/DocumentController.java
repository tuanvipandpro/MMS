package dev.tuanlm.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.tuanlm.demo.models.Document;
import dev.tuanlm.demo.service.DocumentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/document")
@CrossOrigin(origins = "http://localhost:8081")
public class DocumentController {
	
	private DocumentService service;
	
	@GetMapping("/get-by-year")
	public ResponseEntity<List<Document>> getDocumentsByYearAndType(
			@RequestParam int type, @RequestParam int year,@RequestParam int user_id) {
		return new ResponseEntity<List<Document>>(service.getDocumentsByTypeAndYear(type, year, user_id), HttpStatus.OK);
	}
}
