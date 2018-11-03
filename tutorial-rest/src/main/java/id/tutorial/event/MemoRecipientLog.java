package id.tutorial.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MemoRecipientLog {
	
	@EventListener
	public void showLog(Memo memo) throws InterruptedException {
		log.info("{} - {}", this.getClass().getSimpleName(), Thread.currentThread().getName());
		Thread.sleep(7000L);
		log.info("A memo just sent to {}", memo.getPerson());
	}

}
