package id.tutorial.rest.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Response<T> {

	@JsonProperty("code")
	private Integer code;

	@JsonProperty("status")
	private String status;

	@JsonProperty("data")
	private T data;

	@JsonProperty("paging")
	private Paging paging;

	@JsonProperty("errors")
	private Map<String, List<String>> errors;

}
