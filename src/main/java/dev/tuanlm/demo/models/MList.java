package dev.tuanlm.demo.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MList {

	private int id;
	
	
	private String title;
	
	
	private LocalDateTime create_date;
	
	
	private int creater_id;
	
	
	private String note;
	
	
	private int type;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	List<Indexing> indexings;
}
