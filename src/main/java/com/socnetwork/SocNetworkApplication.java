package com.socnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:properties/messages_en.properties", "classpath:properties/application.properties"})
public class SocNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocNetworkApplication.class, args);
	}

}

