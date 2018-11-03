package id.tutorial.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GreetingService {
	
	@Async
	public void doSomeHeavyMethod() {
		log.info(Thread.currentThread().getName());
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
			Thread.currentThread().interrupt();
		}
		log.info("Execution done");
	}

}
