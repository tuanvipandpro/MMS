package dev.tuanlm.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
	private int id;
	private String token;
	private String username;
	private int area_id;
	private String area_name;
	private String area_details;
}
