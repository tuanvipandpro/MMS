package dev.tuanlm.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.tuanlm.demo.mapper.AreaMapper;
import dev.tuanlm.demo.models.Quarter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class AreaServiceImp implements AreaService {
	
	private AreaMapper mapper;

	@Override
	public List<Quarter> getQuarters(int area_id) {
		return mapper.getQuarters(area_id);
	}
}
