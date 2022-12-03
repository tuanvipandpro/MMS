package dev.tuanlm.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
			+ "		D.return_date					AS return_date, "
			+ "		D.receive_num					AS receive_num "
			+ "FROM "
			+ "		document 						AS D,  "
			+ "		\"user\"						AS US, "
			+ "		area							AS A   	"
			+ "WHERE "
			+ "		D.user_id = US.id "
			+ "		AND D.active = true "
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
	
	@Select("<script> "
			+ "INSERT INTO "
			+ "			document("
			+ "					code, "
			+ "					type, "
			+ "					date, "
			+ "					title, "
			+ "					pages, "
			+ "					copies, "
			+ "					secret, "
			+ "					recipients, "
			+ "					notes, "
			+ "					user_id, "
			+ "					create_date, "
			+ "					agency_issued,"
			+ "					return_date, "
			+ "					signed, "
			+ "					receive_num)"
			+ "VALUES ( "
			+ "					#{document.code}, "
			+ "					#{document.type}, "
			+ "					#{document.date}, "
			+ "					#{document.title}, "
			+ "					#{document.pages}, "
			+ "					#{document.copies}, "
			+ "					#{document.secret}, "
			+ "					#{document.recipients}, "
			+ "					#{document.notes}, "
			+ "					#{document.user_id}, "
			+ "					#{document.create_date}, "
			+ "					#{document.agency_issued},"
			+ "					#{document.return_date}, "
			+ "					#{document.signed}, "
			+ "					#{document.receive_num} "
			+ ") "
			+ "RETURNING id "
			+ "</script>")
	@Options(flushCache = Options.FlushCachePolicy.TRUE)
	int insertDocument(@Param("document") Document document);
	
	@Update("<script> "
			+ "UPDATE "
			+ "					document "
			+ "SET "
			+ "					code = #{doc.code}, "
			+ "					date = #{doc.date}, "
			+ "					title = #{doc.title}, "
			+ "					pages = #{doc.pages}, "
			+ "					copies = #{doc.copies}, "
			+ "					secret = #{doc.secret}, "
			+ "<if test=\"doc.recipients != null \"> "
			+ "					recipients = #{doc.recipients}, "
			+ "</if> "
			+ "<if test=\"doc.notes != null \"> "
			+ "					notes = #{doc.notes}, "
			+ "</if> "
			+ "<if test=\"doc.agency_issued != null \"> "
			+ "					agency_issued = #{doc.agency_issued}, "
			+ "</if> "
			+ "<if test=\"doc.return_date != null \"> "
			+ "					return_date = #{doc.return_date}, "
			+ "</if> "
			+ "<if test=\"doc.signed != null \"> "
			+ "					signed = #{doc.signed}, "
			+ "</if> "
			+ "<if test=\"doc.receive_num != null \"> "
			+ "					receive_num = #{doc.receive_num} "
			+ "</if> "
			+ "WHERE "
			+ "			id = #{doc.id}"
			+ "</script>")
	int updateDocument(@Param("doc") Document doc);
	
	@Update("<script> "
			+ "UPDATE "
			+ "			document "
			+ "SET "
			+ "			active = false "
			+ "WHERE "
			+ "			id = #{id} "
			+ "</script>")
	int disableDocument(int id);
}
