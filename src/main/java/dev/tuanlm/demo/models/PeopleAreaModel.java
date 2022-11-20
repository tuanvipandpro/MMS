package dev.tuanlm.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleAreaModel {

	private int id;
	
	private String fullname;
	
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
	
	private Date m_birthdate;
	
	private String m_career;
	
	private String d_fullname;
	
	private Date d_birthdate;
	
	private String d_career;
	
	private String note;
	
	private boolean active;
}
