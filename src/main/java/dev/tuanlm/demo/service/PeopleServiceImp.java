package dev.tuanlm.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.tuanlm.demo.mapper.PeopleMapper;
import dev.tuanlm.demo.models.Area;
import dev.tuanlm.demo.models.People;
import dev.tuanlm.demo.models.PeopleAreaModel;
import dev.tuanlm.demo.repository.PeopleRepository;
import dev.tuanlm.demo.request.CreatePeopleRequest;
import dev.tuanlm.demo.response.GetPeopleResponse;
import dev.tuanlm.demo.utils.JasperUtils;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@Service
@Transactional
@AllArgsConstructor
public class PeopleServiceImp implements PeopleService {
	
	private PeopleRepository peopleRepository;
	private PeopleMapper peopleMapper;

	@Deprecated
	public GetPeopleResponse getByAreaPaging(int area_id, int pageNum, int pageNo) {		
		List<PeopleAreaModel> peopleAreas = new ArrayList<>();
			
		peopleRepository.findAllByAreaId(area_id, PageRequest.of(pageNo, pageNum, Sort.by("quarter").ascending()))
		.forEach(p -> {
			PeopleAreaModel model = new PeopleAreaModel();
			BeanUtils.copyProperties(p, model);
			model.setArea_id(area_id);
			model.setArea_name(p.getArea().getName());
			peopleAreas.add(model);
		});
		
		GetPeopleResponse response = new GetPeopleResponse(peopleAreas, peopleRepository.countByAreaId(area_id), pageNum, pageNo);
		
		return response;
	}

	@Override
	public PeopleAreaModel createPeople(CreatePeopleRequest request) {
		People p = new People();
		BeanUtils.copyProperties(request, p);
		p.setArea(new Area(request.getArea_id(), null, null, false, null, null));
		p.setActive(true);
		
		PeopleAreaModel model = new PeopleAreaModel();
		People addP = peopleRepository.save(p);
		BeanUtils.copyProperties(addP, model);
		model.setArea_id(addP.getArea().getId());
		
		return model;
	}

	@Override
	public GetPeopleResponse getPeople(int area_id, int pageNum, int pageNo, String fullname, String quarter, Date from,
			Date to) {
		
		if (fullname != null && !fullname.isBlank()) {
			fullname = "%" + fullname + "%";
		}
		return new GetPeopleResponse(
				peopleMapper.getPeople(area_id, pageNum*pageNo, pageNum, fullname, quarter, from, to), 
				peopleMapper.countPeople(area_id, fullname, quarter, from, to), 
				pageNum, 
				pageNo);
	}

	@Override
	public int updatePeople(PeopleAreaModel p) {
		return peopleMapper.updatePeople(p);
	}

	@Override
	public int deletePeople(int people_id) {
		return peopleMapper.deletePeople(people_id);
	}

	@Override
	public int insertPeople(PeopleAreaModel p) {
		return peopleMapper.insertPeople(p);
	}

	@Override
	public byte[] getPeopleReport(int people_id) throws JRException, IOException {
		String reportUrlFile = JasperUtils.REPORT_PATH + "PeopleReport.jrxml";
		
		People people = peopleRepository.getReferenceById(people_id);
		
		if (people == null) {
			throw new JRException("Data is empty to export report !!!");
		}
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nowTime", LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
//		return JasperUtils.generateDocxReport(reportUrlFile, List.of(people), parameters);
		return JasperUtils.generatePDFReport(reportUrlFile, List.of(people), parameters);
	}

}
