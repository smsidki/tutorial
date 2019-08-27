package id.tutorial.tips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TipsApp {
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(TipsApp.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void showDatabaseInfo() {
		System.out.println(env.getProperty("db.username"));
		System.out.println(env.getProperty("db.password"));
	}
	
}
