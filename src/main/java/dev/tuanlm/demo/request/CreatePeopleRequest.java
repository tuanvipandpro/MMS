package dev.tuanlm.demo.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePeopleRequest {
	
	private String fullname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthdate;
	
	private String address;
	
	private String quarter;
	
	private String area_name;
	
	private int area_id;
	
	private String career;
	
	private String workplace;
	
	private String ethnic;
	
	private String religion;
	
	private String organization;
	
	private String family;
	
	private String self;
	
	private String language;
	
	private int level;
	
	private String education;
	
	private String education_details;
	
	private String phone;
	
	private String m_fullname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date m_birthdate;
	
	private String m_career;
	
	private String d_fullname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date d_birthdate;
	
	private String d_career;
	
	private String note;

}
