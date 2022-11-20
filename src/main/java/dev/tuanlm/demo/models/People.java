package dev.tuanlm.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "people", schema = "public")
public class People {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "birthdate")
	private Date birthdate;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "quarter")
	private String quarter;
	
	@Column(name = "career")
	private String career;
	
	@Column(name = "workplace")
	private String workplace;
	
	@Column(name = "ethnic")
	private String ethnic;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "organization")
	private String organization;
	
	@Column(name = "family")
	private String family;
	
	@Column(name = "self")
	private String self;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "level")
	private int level;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "education_details")
	private String education_details;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "m_fullname")
	private String m_fullname;
	
	@Column(name = "m_birthdate")
	private Date m_birthdate;
	
	@Column(name = "m_career")
	private String m_career;
	
	@Column(name = "d_fullname")
	private String d_fullname;
	
	@Column(name = "d_birthdate")
	private Date d_birthdate;
	
	@Column(name = "d_career")
	private String d_career;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Area area;
}
