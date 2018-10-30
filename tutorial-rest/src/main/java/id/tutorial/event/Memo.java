package id.tutorial.event;

import java.time.LocalTime;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class Memo extends ApplicationEvent {

	private static final long serialVersionUID = 1827904868810335587L;

	private String topic;
	private String person;
	private LocalTime time;
	private String location;
	
	public Memo(Object source, String topic, String person, LocalTime time, String location) {
		super(source);
		this.topic = topic;
		this.person = person;
		this.time = time;
		this.location = location;
	}

}
