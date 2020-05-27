package com.example.demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static Logger LOG = LogManager.getLogger(DemoApplication.class);
	public static Logger getInstance() { return LOG; }

	public static void main(String[] args) throws Exception
	{
		LOG.info("Starting spring boot application");
		SpringApplication.run(DemoApplication.class, args);
	}

}
