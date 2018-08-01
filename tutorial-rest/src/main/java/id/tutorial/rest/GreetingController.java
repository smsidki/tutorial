package id.tutorial.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

}
