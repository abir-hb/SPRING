package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.AppUser;



public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);

	@Query("SELECT count(*) FROM AppUser")
	public int countuser();
	@Modifying
	@Transactional
	@Query("UPDATE AppUser e SET e.email=:email1 where e.id=:userId")
	public void mettreAjourEmailUse(@Param("email1")String email,@Param("userId")Long id);
}

