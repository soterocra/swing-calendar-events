package dev.soterocra.lab.calendarevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.soterocra.lab.calendarevents.view.CalendarFrame;

@SpringBootApplication
public class CalendarEventsApplication {

	public static void main(String[] args) {		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(CalendarEventsApplication.class).headless(false).run(args);
		
		CalendarFrame app = context.getBean(CalendarFrame.class);
		app.setVisible(true);
	}
}
