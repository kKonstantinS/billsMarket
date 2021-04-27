package com.socnetwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:properties/messages_en.properties", "classpath:properties/application.properties"})
public class SocNetworkApplication {

	private static final Logger logger = LoggerFactory.getLogger(SocNetworkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SocNetworkApplication.class, args);
	}

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 42;
	}
}

