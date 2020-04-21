package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.config.FileStorageProperties;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.service.AccountService;
@EnableConfigurationProperties({
    FileStorageProperties.class
})
@SpringBootApplication
public class GestinuserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestinuserApplication.class, args);
	}

	@Autowired
	private AccountService accountService;

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		accountService.saveUser(new AppUser(null,"Admin","123",null));
		
		 accountService.saveRole(new AppRole(null,"ADMIN"));
		 * accountService.saveRole(new AppRole(null,"USER"));
		 * accountService.addRoleToUser("admin", "ADMIN");*/
		 //accountService.saveUser(new AppUser(null,"User","123",null));
		//accountService.saveRole(new AppRole(null,"USER"));
		// accountService.addRoleToUser("User", "USER");
//		accountService.saveUser(new AppUser(null,"Admin","123",null));
//		 accountService.saveRole(new AppRole(null,"ADMIN"));
//		 accountService.addRoleToUser("admin", "ADMIN");
//		accountService.saveUser(new AppUser(null,"lisa","123",null));
		//accountService.saveUser(new AppUser(null, "khaoula", "123", "khaoula", "mejri", null));

	}

}
