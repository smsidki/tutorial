package id.tutorial.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("id.tutorial")
public class RestApplication {
	
	public static void main(String...args) {
		SpringApplication app = new SpringApplication(RestApplication.class);
		app.run(args);
	}

}
