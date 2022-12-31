package dev.tuanlm.demo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Indexing {
	private int id;
	private int list_id;
	private int value;
	private String title;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	List<MIDetails> details;
}
