package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

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

}
