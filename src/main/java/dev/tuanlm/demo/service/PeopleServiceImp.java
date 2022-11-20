package dev.tuanlm.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.tuanlm.demo.models.Area;
import dev.tuanlm.demo.models.People;
import dev.tuanlm.demo.models.PeopleAreaModel;
import dev.tuanlm.demo.repository.PeopleRepository;
import dev.tuanlm.demo.request.CreatePeopleRequest;
import dev.tuanlm.demo.response.GetPeopleResponse;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PeopleServiceImp implements PeopleService {
	
	private PeopleRepository peopleRepository;

	@Override
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

}
