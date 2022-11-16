package com.se.goBears;

import com.se.goBears.entity.Role;
import com.se.goBears.enums.ERole;
import com.se.goBears.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication app = new org.springframework.boot.SpringApplication(SpringApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-06:00"));
	}
	@Bean
	public CommandLineRunner dataLoader(RoleRepository roleRepository) { // user repo for ease of testing with a built-in user
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				if(roleRepository.findAll().size() ==0){
					roleRepository.save(new Role(ERole.ROLE_USER));
					roleRepository.save(new Role(ERole.ROLE_ADMIN));
				}
			}
		};
			}
}
