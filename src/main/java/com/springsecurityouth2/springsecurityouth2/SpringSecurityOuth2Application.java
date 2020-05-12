package com.springsecurityouth2.springsecurityouth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
public class SpringSecurityOuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOuth2Application.class, args);
	}

}
