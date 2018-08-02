package id.tutorial.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("id.tutorial.entity")
@EnableJpaRepositories("id.tutorial.repo")
public class DataSourceConfiguration {

}
