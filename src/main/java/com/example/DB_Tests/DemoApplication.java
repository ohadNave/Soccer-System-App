package com.example.DB_Tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static Logger eventLogger = LogManager.getLogger("eventLogger");
	public static Logger errorLogger = LogManager.getLogger("errorLogger");

	public static Logger getInstance() { return eventLogger; }

	public static void main(String[] args) throws Exception
	{
		eventLogger.info("Starting spring boot application");
		SpringApplication.run(DemoApplication.class, args);
	}

}
