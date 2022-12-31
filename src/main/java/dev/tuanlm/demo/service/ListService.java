package dev.tuanlm.demo.service;

import dev.tuanlm.demo.models.MList;

public interface ListService {
	MList getListByYearAndType(int type, String year);
}
