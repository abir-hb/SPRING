package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);

}
