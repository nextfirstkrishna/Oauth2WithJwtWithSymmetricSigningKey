package com.example.client.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.client.repositry.UserRepositoryBean;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserRepositoryBean.class)
@ComponentScan(basePackages = { "com.example.client.*" })
@EntityScan("com.example.client.*")  
public class SpringOautWithJwtProject2020103Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringOautWithJwtProject2020103Application.class, args);
	}

}
