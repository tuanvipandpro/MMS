package dev.tuanlm.demo.service;

import java.util.List;

import dev.tuanlm.demo.models.Quarter;

public interface AreaService {
	List<Quarter> getQuarters(int area_id);
}
