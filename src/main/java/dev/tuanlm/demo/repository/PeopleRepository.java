package dev.tuanlm.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.tuanlm.demo.models.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
	List<People> findAllByAreaId(int area_id, Pageable pageable);
	int countByAreaId(int area_id);
}
