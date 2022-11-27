package dev.tuanlm.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dev.tuanlm.demo.models.Document;

@Mapper
public interface DocumentMapper {
	
	@Select("<script> "
			+ "SELECT "
			+ "		D.id							AS id, "
			+ "		D.code							AS code, "
			+ "		D.type							AS type, "
			+ "		D.date							AS date, "
			+ "		D.title							AS title, "
			+ "		D.pages							AS pages, "
			+ "		D.copies						AS copies, "
			+ "		D.secret						AS secret, "
			+ "		D.recipients					AS recipients, "
			+ "		D.notes							AS notes, "
			+ "		D.user_id						AS user_id, "
			+ "		A.id							AS area_id, "
			+ "		A.details						AS area_details, "
			+ "		D.create_date					AS create_date, "
			+ "		D.active						AS active, "
			+ "		D.agency_issued					AS agency_issued, "
			+ "		D.signed						AS signed, "
			+ "		D.receive_num					AS receive_num "
			+ "FROM "
			+ "		document 						AS D,  "
			+ "		\"user\"						AS US, "
			+ "		area							AS A   	"
			+ "WHERE "
			+ "		D.user_id = US.id "
			+ "		AND US.area_id = A.id "
			+ "		AND D.type = #{type} "
			+ "		AND US.area_id = #{area_id} "
			+ "		AND D.date <![CDATA[>=]]> #{from} "
			+ "		AND D.date <![CDATA[<=]]> #{to} "
			+ "ORDER BY "
			+ "		D.date "
			+ "</script>")
	List<Document> getDocumentsByTypeAndYear(
			@Param("type") int type, 
			@Param("from") LocalDate from, 
			@Param("to") LocalDate to, 
			@Param("area_id") int area_id);
}
