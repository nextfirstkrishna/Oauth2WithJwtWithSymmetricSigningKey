package com.example.client.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.client.model.User;



@Repository
public interface UserRepositoryBean extends JpaRepository<User, Integer> {
	
	User findByUsername(String name);

}

