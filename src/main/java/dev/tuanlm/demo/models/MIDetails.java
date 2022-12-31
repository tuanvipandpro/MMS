package dev.tuanlm.demo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MIDetails {
	private int id;
	private int indexing_id;
	private int people_id;
	private String note;
	
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date birthdate;
	
	private String address;
	
	private String quarter;
	
	private String area;
	
	private String career;
	
	private String workplace;
	
	private String ethnic;
	
	private String religion;
	
	private String organization;
	
	private String family;
	
	private String self;
	
	private Integer level;
	
	private String education;
	
	private String education_details;
	
	private String m_fullname;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date m_birthdate;
	
	private String m_career;
	
	private String d_fullname;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date d_birthdate;
	
	private String d_career;
}
