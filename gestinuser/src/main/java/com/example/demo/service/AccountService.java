package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);

	public AppRole saveRole(AppRole role);

	public void addRoleToUser(String username, String roleName);

	public AppUser findUserByUsername(String username);

	public void affecterUserRole(Long id, Long idRole);
	 public List<AppUser>getAllUsers();
	void deleteUser(long id);
	 public AppUser updateUser(AppUser user);
	public void updateUSer(long id,String firstName);
	public void mettreAjourEmailUse(String email,Long id);

}
