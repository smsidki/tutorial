package id.tutorial.scheduler.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import id.tutorial.scheduler.repository.SchedulerSettingRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimeService {
	
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss");
	private static final String TIME_SERVICE = "time_service";
	
	private final SchedulerSettingRepo schedulerSettingRepo;
	
	@Scheduled(cron = "${job.time-service.schedule}")
	@Scheduled(cron = "#{timeService.getTimeServiceSchedule()}")
	public void showCurrentTime() {
		log.info("Current time is {}", LocalTime.now().format(DTF));
	}
	
	public String getTimeServiceSchedule() {
		log.info("Searching schedule setting for {}", TIME_SERVICE);
		return schedulerSettingRepo.findByServiceName(TIME_SERVICE)
			.orElseThrow(() -> new RuntimeException(String.format("Scheduler setting %s is not found!", TIME_SERVICE)))
		.getCronExpression();
	}

}
