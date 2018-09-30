package id.tutorial.scheduler.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:scheduler.properties")
public class TimeServiceTest {
	
	@Autowired private Environment environment;
	@SpyBean private TimeService timeService; 
	
	@Test
	public void testCronExpression() {
		String expression = environment.getProperty("job.time-service.schedule");
		boolean isCronValid = CronSequenceGenerator.isValidExpression(expression);
		assertTrue(String.format("Cron expression %s is not valid", expression), isCronValid);
	}
	
	@Test
	public void testShowCurrentTime() {
		timeService.showCurrentTime();
		verify(timeService).showCurrentTime();
	}
	
	@TestConfiguration
	static class TimeServiceTestConfig {
		
		@Bean
		public TimeService timeService() {
			return new TimeService(null);
		}
		
	}

}
