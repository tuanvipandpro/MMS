package dev.tuanlm.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.tuanlm.demo.mapper.DocumentMapper;
import dev.tuanlm.demo.models.Document;
import dev.tuanlm.demo.repository.AccountRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DocumentServiceImp implements DocumentService {
	
	private DocumentMapper mapper;
	
	private AccountRepository repository;
	
	@Override
	public List<Document> getDocumentsByTypeAndYear(int type, int year, int user_id) {	
		
		
		return mapper.getDocumentsByTypeAndYear(
				type, 
				LocalDate.of(year, 1, 1), 
				LocalDate.of(year, 12, 31), 
				repository.getReferenceById(user_id).getArea().getId());
	}
	
}
