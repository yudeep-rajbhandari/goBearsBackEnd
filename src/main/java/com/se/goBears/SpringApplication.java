package com.se.goBears;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication app = new org.springframework.boot.SpringApplication(SpringApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
