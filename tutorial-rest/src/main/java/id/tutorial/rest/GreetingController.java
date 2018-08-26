package id.tutorial.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.tutorial.rest.dto.Response;
import id.tutorial.rest.helper.ResponseHelper;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/hello")
	public Response hello() {
		return ResponseHelper.ok("Hello World");
	}

}
