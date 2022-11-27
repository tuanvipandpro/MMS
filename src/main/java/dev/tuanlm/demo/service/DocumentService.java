package dev.tuanlm.demo.service;

import java.util.List;

import dev.tuanlm.demo.models.Document;

public interface DocumentService {
	List<Document> getDocumentsByTypeAndYear(int type, int year, int user_id);
}
