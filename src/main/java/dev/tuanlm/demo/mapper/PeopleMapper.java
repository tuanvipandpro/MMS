package dev.tuanlm.demo.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dev.tuanlm.demo.models.PeopleAreaModel;

@Mapper
public interface PeopleMapper {
	
	@Select(""
			+ "<script>"
			+ "SELECT "
			+ "		P.id 							AS id, "
			+ "		P.fullname						AS fullname, "
			+ "		P.birthdate						AS birthdate, "
			+ "		P.address						AS address, "
			+ "		P.quarter						AS quarter, "
			+ "		A.id							AS area_id, "
			+ "		A.name							AS area_name, "
			+ "		P.career						AS career, "
			+ "		P.workplace						AS workplace, "
			+ "		P.ethnic						AS ethnic, "
			+ "		P.religion						AS relegion, "
			+ "		P.organization					AS organization, "
			+ "		P.family						AS family, "
			+ "		P.self							AS self, "
			+ "		P.language						AS language, "
			+ "		P.level							AS level, "
			+ "		P.education						AS education, "
			+ "		P.education_details				AS education_details, "
			+ "		P.phone							AS phone, "
			+ "		P.m_fullname					AS m_fullname, "
			+ "		P.m_birthdate					AS m_birthdate, "
			+ "		P.m_career						AS m_career, "
			+ "		P.d_fullname					AS d_fullname, "
			+ "		P.d_birthdate					AS d_birthdate, "
			+ "		P.d_career						AS d_career, "
			+ "		P.note							AS note, "
			+ "		P.active						AS active "
			+ "FROM "
			+ "		people AS P, "
			+ "		area AS A "
			+ "WHERE "
			+ "		P.area_id = A.id "
			+ "		AND P.active = true "
			+ "		AND A.id = #{area_id} "
			+ "<if test=\"fullname != null \"> "
			+ "		AND P.fullname LIKE #{fullname} "
			+ "</if>"
			+ "<if test=\"quarter != null \"> "
			+ "		AND P.quarter LIKE #{quarter} "
			+ "</if>"
			+ "<if test=\"from != null and to != null \"> "
			+ "		AND P.birthdate <![CDATA[>]]> #{from} "
			+ "		AND P.birthdate <![CDATA[<]]> #{to} "
			+ "</if>"
			+ "ORDER BY "
			+ "		P.quarter "
			+ "OFFSET "
			+ "		#{offset} "
			+ "LIMIT "
			+ "		#{limit} "
			+ "</script>")
	List<PeopleAreaModel> getPeople(
			@Param("area_id") int area_id, 
			@Param("offset") int offset, 
			@Param("limit") int limit, 
			@Param("fullname") String fullname, 
			@Param("quarter") String quarter, 
			@Param("from") Date from, 
			@Param("to") Date to);
	
	@Select(""
			+ "<script>"
			+ "SELECT "
			+ "		COUNT(*) "
			+ "FROM "
			+ "		people AS P, "
			+ "		area AS A "
			+ "WHERE "
			+ "		P.area_id = A.id "
			+ "		AND P.active = true "
			+ "		AND A.id = #{area_id} "
			+ "<if test=\"fullname != null \"> "
			+ "		AND P.fullname LIKE #{fullname} "
			+ "</if> "
			+ "<if test=\"quarter != null  \"> "
			+ "		AND P.quarter LIKE #{quarter} "
			+ "</if> "
			+ "<if test=\"from != null and to != null \"> "
			+ "		AND P.birthdate <![CDATA[>]]> #{from} "
			+ "		AND P.birthdate <![CDATA[<]]> #{to} "
			+ "</if> "
			+ "</script>")
	int countPeople(@Param("area_id") int area_id, 
					@Param("fullname") String fullname, 
					@Param("quarter") String quarter, 
					@Param("from") Date from, 
					@Param("to") Date to);
}
