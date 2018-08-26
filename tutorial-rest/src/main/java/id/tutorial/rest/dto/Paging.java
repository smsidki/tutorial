package id.tutorial.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Paging {

	@JsonProperty("page")
	private Integer page;

	@JsonProperty("totalPage")
	private Integer totalPage;

	@JsonProperty("itemPerPage")
	private Integer itemPerPage;

	@JsonProperty("totalItem")
	private Long totalItem;


}
