package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import antlr.collections.List;

@Service
@Transactional
public class AccountServiceImp implements AccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AppUser saveUser(AppUser user) {
		String HashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(HashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {

		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);

	}

	@Override
	public AppUser findUserByUsername(String username) {

		return userRepository.findByUsername(username);
	}

//	@Transactional
//	@Override
//	public void affecterUserRole(Long id, Long idRole) {
//		AppRole appRole = roleRepository.findById(idRole).get();
//		AppUser appUser = userRepository.findById(idRole).get();
//		if (appRole.getAppUser() == null) {
//			java.util.List<AppUser> users = new ArrayList<>();
//
//			users.add(appUser);
//			appRole.setAppUser(users);
//		} else {
//			appRole.getAppUser().add(appUser);
//		}
//
//	}

	@Override
	public java.util.List<AppUser> getAllUsers() {
		return (java.util.List<AppUser>)userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
		 userRepository.deleteById(id);
		
	}

	@Override
	public AppUser updateUser(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUSer(long id, String firstName) {
		AppUser user1=userRepository.findById(id).get();
		user1.setFirstName(firstName);
		userRepository.save(user1);
	}

	@Override
	public void affecterUserRole(Long id, Long idRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mettreAjourEmailUse(String email, Long id) {
	AppUser appUser =userRepository.findById(id).get();
	appUser.setEmail(email);
	userRepository.save(appUser);
		
	}

}
