package dev.tuanlm.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	private int id;
	private String code; // 0 đến 1 đi
	private int type;
	private Date date;
	private String title;
	private int pages;
	private int copies;
	private boolean secret;
	private String recipients; // only 1
	private String notes;
	private int user_id;
	private int area_id;
	private String area_details;
	private Date create_date;
	private boolean active;
	private String agency_issued; // only 0
	private boolean signed; //only 0
	private int receive_num; // only 0	
}
