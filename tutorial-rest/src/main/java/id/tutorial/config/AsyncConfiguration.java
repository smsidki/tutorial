package id.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfiguration {
	
	@Bean
	public TaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor("defaultTaskExecutor-");
	}
	
	@Bean
	public TaskExecutor poolTaskExecutor() {
		ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
		poolTaskExecutor.initialize();
		return poolTaskExecutor;
	}
	
	@Bean
	public TaskExecutor concurrentTaskExecutor() {
		return new ConcurrentTaskExecutor();
	}

}
