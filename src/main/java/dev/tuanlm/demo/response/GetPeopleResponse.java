package dev.tuanlm.demo.response;

import java.util.List;

import dev.tuanlm.demo.models.PeopleAreaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPeopleResponse{
	private List<PeopleAreaModel> peoples;
	private int total;
	private int pageNum;
	private int pageNo;
}
