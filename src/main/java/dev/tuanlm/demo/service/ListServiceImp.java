package dev.tuanlm.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.tuanlm.demo.mapper.ListMapper;
import dev.tuanlm.demo.models.Indexing;
import dev.tuanlm.demo.models.MList;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ListServiceImp implements ListService {

	private ListMapper mapper;
	
	@Override
	public MList getListByYearAndType(int type, String year) {
		MList list = Optional.of(mapper.getListByTypeAndYear(type, "%" + year))
				.orElseThrow(() -> new NullPointerException("Danh sách không tồn tại"));
		
		List<Indexing> indexs = mapper.getIndexingsByList(list.getId());
		
		indexs.forEach(i -> i.setDetails(mapper.getDetailsByIndexing(i.getId())));
		
		list.setIndexings(indexs);
		return list;
	}

}
