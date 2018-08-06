package id.tutorial.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("id.tutorial.entity")
@EnableJpaRepositories("id.tutorial.repo")
@EnableJpaAuditing(auditorAwareRef = "currentAuditor")
public class DataSourceConfiguration {
	
	@Bean
	public AuditorAware<String> currentAuditor() {
		return new AuditorAware<String>() {
			
			@Override
			public Optional<String> getCurrentAuditor() {
				return Optional.of("SYSTEM");
			}
			
		};
	}

}
