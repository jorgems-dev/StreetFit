package com.streetfit.apiFitServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = "com.streetfit.apiFitServer")
@EntityScan("com.streetfit.apiFitServer.modelos")
public class ApiFitServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFitServerApplication.class, args);
	}


}
