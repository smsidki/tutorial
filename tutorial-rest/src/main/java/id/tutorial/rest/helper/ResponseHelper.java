package id.tutorial.rest.helper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import id.tutorial.rest.dto.Paging;
import id.tutorial.rest.dto.Response;

public class ResponseHelper {
	
	public static <T> Response<T> ok(T data) {
		Response<T> response = new Response<>();
		response.setStatus(HttpStatus.OK.name());
		response.setCode(HttpStatus.OK.value());
		response.setData(data);
		return response;
	}
	
	public static <T> Response<List<T>> ok(Page<T> page) {
		Response<List<T>> response = new Response<>();
		response.setStatus(HttpStatus.OK.name());
		response.setCode(HttpStatus.OK.value());
		response.setData(page.getContent());
		
		Paging paging = new Paging();
		paging.setPage(page.getNumber());
		paging.setItemPerPage(page.getSize());
		paging.setTotalItem(page.getTotalElements());
		paging.setTotalPage(page.getTotalPages());
		response.setPaging(paging);
		return response;
	}


}
