package dev.tuanlm.demo.service;

import java.util.Date;

import dev.tuanlm.demo.models.PeopleAreaModel;
import dev.tuanlm.demo.request.CreatePeopleRequest;
import dev.tuanlm.demo.response.GetPeopleResponse;

public interface PeopleService {
	
	GetPeopleResponse getPeople(int area_id, int pageNum, int pageNo, String fullname, String quarter, Date from, Date to);
	
	PeopleAreaModel createPeople(CreatePeopleRequest request);
}
