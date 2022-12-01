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
public class Document {
	private int id;
	@NotBlank
	private String code; // 0 đến 1 đi
	@NotNull
	private int type;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
	@NotBlank
	private String title;
	@NotNull
	private int pages;
	@NotNull
	private int copies;
	@NotNull
	private boolean secret;
	private String recipients; // only 1
	private String notes;
	@NotNull
	private int user_id;
	private int area_id;
	private String area_details;
	private Date create_date;
	private boolean active;
	private Date return_date;
	private String agency_issued; // only 0
	private boolean signed; //only 0
	private int receive_num; // only 0	
}
