package com.example.demo.contoller;

import java.util.Collection;
import java.util.List;

import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.AccountService;



@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	private RoleRepository roleRepository;
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
		accountService.addRoleToUser(userForum.getUsername(), "USER");

		return appUser;
	}

	@RequestMapping("/")
	@ResponseWrapper
	public String welcome() {
		return "Hello;welcome to our kindergarten";
	}

	@PostMapping("/add-user")
	@ResponseBody
	public AppUser addUser(@RequestBody AppUser u) {
		AppUser user = accountService.saveUser(u);
		return user;
	}

	@PutMapping(value = "/addRoleUser/{name}/{role}")
	@ResponseBody
	public void addRoleToUser(@PathVariable("name") String username, @PathVariable("role") String roleName) {
		accountService.addRoleToUser(username, roleName);
	}

	@PutMapping(value = "/affecter/{idUser}/{roleid}")
	@ResponseBody
	public void affecterUserRole(@PathVariable("idUser") Long id, @PathVariable("roleid") Long idRole) {
		accountService.affecterUserRole(id, idRole);
	}

	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<AppUser> getAllUsers() {
		List<AppUser> list = accountService.getAllUsers();
		return list;
	}
	// @GetMapping(value = "/image")
	// public @ResponseBody byte[] getImage() throws IOException {
	// InputStream in = getClass()
	// .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
	// return IOUtils.toByteArray(in);
	//
	// }@RequestMapping(value = "/image-manual-response", method =
	// RequestMethod.GET)
	// public void getImageAsByteArray(HttpServletResponse response) throws
	// IOException {
	// InputStream in =
	// servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
	// response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	// IOUtils.copy(in, response.getOutputStream());
	// }
	@DeleteMapping("/delete-user/{user-id}")
	@ResponseBody
	public void deleteUser(@PathVariable("user-id") long id) {
		accountService.deleteUser(id);
	}
	@PutMapping("/modify-user")
	@ResponseBody
	public AppUser updateUser(@RequestBody AppUser user) {
	 AppUser user1 = accountService.updateUser(user);

	return user1; }
	@PutMapping(value = "/modifyEmail/{id}/{newemail}") 
	@ResponseBody
	public void mettreAjourEmailUse(@PathVariable("email1")String email,@PathVariable("userId")Long id) {
	accountService.mettreAjourEmailUse(email, id);}
	

}
