package dev.tuanlm.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dev.tuanlm.demo.models.Quarter;

@Mapper
public interface AreaMapper {
	@Select(""
			+ "<script> "
			+ "SELECT "
			+ "		id 					AS id, "
			+ "		name				AS name "
			+ "FROM "
			+ "		quarter "
			+ "WHERE "
			+ "		area_id = #{id} "
			+ "ORDER BY "
			+ "		id "
			+ "</script>")
	List<Quarter> getQuarters(@Param("id") int area_id);
}
