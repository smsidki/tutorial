package id.tutorial.event;

import java.time.format.DateTimeFormatter;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemoListener {
	
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("hh:mm a");
	
	@Async
	@EventListener
	public void showMemo(Memo memo) throws InterruptedException {
		Thread.sleep(3000L);
		
		log.info("Hi {}, please meet me at {} on {}.", memo.getPerson(), DTF.format(memo.getTime()), memo.getLocation());
		log.info("We will discuss about {}.", memo.getTopic());
		log.info("Thank you.");
	}

}
