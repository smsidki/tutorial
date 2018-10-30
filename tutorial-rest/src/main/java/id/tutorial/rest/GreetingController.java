package id.tutorial.rest;

import java.time.LocalTime;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tutorial.event.Memo;
import id.tutorial.rest.dto.Response;
import id.tutorial.rest.helper.ResponseHelper;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/greeting")
@SuppressWarnings("rawtypes")
public class GreetingController {
	
	private final ApplicationEventPublisher publisher;
	
	@GetMapping("/hello")
	public Response hello() {
		return ResponseHelper.ok("Hello World");
	}
	
	@GetMapping("/memo")
	public Response memo(@RequestParam String topic, @RequestParam String person, @RequestParam long minutes, @RequestParam String location) {
		Memo memo = new Memo(this, topic, person, LocalTime.now().plusMinutes(minutes), location);
		publisher.publishEvent(memo);
		return ResponseHelper.ok();
	}
	

}
