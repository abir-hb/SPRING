package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);

	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);

}
