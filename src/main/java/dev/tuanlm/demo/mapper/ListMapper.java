package dev.tuanlm.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dev.tuanlm.demo.models.Indexing;
import dev.tuanlm.demo.models.MIDetails;
import dev.tuanlm.demo.models.MList;

@Mapper
public interface ListMapper {
	
	@Select("<script>"
			+ "SELECT "
			+ "		L.id				AS id, "
			+ "		L.title				AS title, "
			+ "		L.note				AS note, "
			+ "		L.type				AS type, "
			+ "		L.creater			AS creater_id, "
			+ "		L.create_date		AS create_date "
			+ "FROM "
			+ "		list 				AS 	L "
			+ "WHERE "
			+ "		L.title LIKE #{year} "
			+ "		AND L.type = #{type} "
			+ "ORDER BY "
			+ "		L.id "
			+ "</script>")
	MList getListByTypeAndYear(@Param("type") int type, @Param("year") String year);
	
	@Select("<script>"
			+ "SELECT "
			+ "		I.id				AS id, "
			+ "		I.list_id			AS list_id, "
			+ "		I.value				AS value, "
			+ "		I.title				AS title "
			+ "FROM "
			+ "		indexing 			AS 	I "
			+ "WHERE "
			+ "		I.list_id = #{list_id} "
			+ "ORDER BY "
			+ "		I.id "
			+ "</script>")
	List<Indexing> getIndexingsByList(@Param("list_id") int list_id);
	
	@Select("<script>"
			+ "SELECT "
			+ "		D.id					AS id, "
			+ "		D.indexing_id			AS indexing_id, "
			+ "		D.people_id				AS people_id, "
			+ "		D.note					AS note, "
			+ "		P.fullname					AS name, "
			+ "		P.birthdate				AS birthdate, "
			+ "		P.address				AS address, "
			+ "		P.quarter				AS quarter, "
			+ "		A.name					AS area, "
			+ "		P.career				AS career, "
			+ "		P.workplace				AS workplace, "
			+ "		P.ethnic				AS ethnic, "
			+ "		P.organization			AS organization, "
			+ "		P.family				AS family, "
			+ "		P.self					AS self, "
			+ "		P.level					AS level, "
			+ "		P.education				AS education, "
			+ "		P.education_details		AS education_details, "
			+ "		P.m_fullname			AS m_fullname, "
			+ "		P.m_birthdate			AS m_birthdate, "
			+ "		P.m_career				AS m_career, "
			+ "		P.d_fullname			AS d_fullname, "
			+ "		P.d_birthdate			AS d_birthdate, "
			+ "		P.d_career				AS d_career "
			+ "FROM "
			+ "		details 				AS 	D, "
			+ "		people					AS	P, "
			+ "		area					AS	A "
			+ "WHERE "
			+ "		D.indexing_id = #{indexing_id} "
			+ "		AND D.people_id = P.id "
			+ "		AND P.area_id = A.id "
			+ "ORDER BY "
			+ "		D.id "
			+ "</script>")
	List<MIDetails> getDetailsByIndexing(@Param("indexing_id") int indexing_id);
}
