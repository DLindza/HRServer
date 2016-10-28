package com.example;

import com.example.model.TimeCard;
import com.example.repository.TimeCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class HrClientPortalApplication implements CommandLineRunner{

	@Autowired
	TimeCardRepository timeCardRepository;

	private static final Logger log = LoggerFactory.getLogger(HrClientPortalApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(HrClientPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TimeCard timeCard1 = new TimeCard("Sujatha", "9:00am", "9:00pm", "2016-10-26");
		TimeCard timeCard2 = new TimeCard("Devon", "10:00am", "7:00pm", "2016-10-27");
		timeCardRepository.save(timeCard1);
		timeCardRepository.save(timeCard2);

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (TimeCard timeCard : timeCardRepository.findAll()) {
			log.info(timeCard.toString());
		}
	}
}
