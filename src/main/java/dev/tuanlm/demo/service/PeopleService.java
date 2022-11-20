package dev.tuanlm.demo.service;

import dev.tuanlm.demo.models.PeopleAreaModel;
import dev.tuanlm.demo.request.CreatePeopleRequest;
import dev.tuanlm.demo.response.GetPeopleResponse;

public interface PeopleService {
	GetPeopleResponse getByAreaPaging(int area_id, int pageNum, int pageNo);
	
	PeopleAreaModel createPeople(CreatePeopleRequest request);
}
