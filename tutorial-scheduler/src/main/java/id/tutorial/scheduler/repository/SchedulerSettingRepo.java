package id.tutorial.scheduler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tutorial.scheduler.entity.SchedulerSetting;

public interface SchedulerSettingRepo extends JpaRepository<SchedulerSetting, Long> {
	
	Optional<SchedulerSetting> findByServiceName(String servicename);

}
