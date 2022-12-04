package dev.tuanlm.demo.service;

import java.io.IOException;
import java.util.Date;

import dev.tuanlm.demo.models.PeopleAreaModel;
import dev.tuanlm.demo.request.CreatePeopleRequest;
import dev.tuanlm.demo.response.GetPeopleResponse;
import net.sf.jasperreports.engine.JRException;

public interface PeopleService {
	
	GetPeopleResponse getPeople(int area_id, int pageNum, int pageNo, String fullname, String quarter, Date from, Date to);
	
	PeopleAreaModel createPeople(CreatePeopleRequest request);
	
	int updatePeople(PeopleAreaModel p);
	
	int deletePeople(int people_id);
	
	int insertPeople(PeopleAreaModel p);
	
	byte[] getPeopleReport(int people_id) throws JRException, IOException;
}
