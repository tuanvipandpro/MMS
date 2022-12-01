package dev.tuanlm.demo.models;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleAreaModel {

	private int id;
	
	@NotBlank
	private String fullname;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date birthdate;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String quarter;
	
	private String area_name;
	
	@NotNull
	private Integer area_id;
	
	@NotBlank
	private String career;
	
	private String workplace;
	
	@NotBlank
	private String ethnic;
	
	private String religion;
	
	private String organization;
	
	private String family;
	
	private String self;
	
	private String language;
	
	@NotNull
	private Integer level;
	
	private String education;
	
	private String education_details;
	
	private String phone;
	
	private String m_fullname;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date m_birthdate;
	
	private String m_career;
	
	private String d_fullname;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date d_birthdate;
	
	private String d_career;
	
	private String note;
	
	private boolean active;
}
