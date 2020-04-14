package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AppUser;
import com.example.demo.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	/*
	 * @PostMapping("/register") public AppUser register (@RequestBody AppUser user)
	 * { return accountService.saveUser(user); }
	 */

	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForum) {
		if (!userForum.getPassword().equals(userForum.getRepassword()))
			throw new RuntimeException("you must confrim your password");
		AppUser user = accountService.findUserByUsername(userForum.getUsername());
		// si user exit
		if (user != null)
			throw new RuntimeException("this user already exists");
		AppUser appUser = new AppUser();
		appUser.setUsername(userForum.getUsername());
		appUser.setPassword(userForum.getPassword());

		accountService.saveUser(appUser);
		// accountService.addRoleToUser(userForum.getUsername(),appUser.getRoles());
		accountService.addRoleToUser(userForum.getUsername(),"USER");
		 
		 return appUser ;
	}
}
