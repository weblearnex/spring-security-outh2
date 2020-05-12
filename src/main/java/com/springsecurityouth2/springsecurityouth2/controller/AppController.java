package com.springsecurityouth2.springsecurityouth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
public class AppController extends  WebSecurityConfigurerAdapter  {
	
	@GetMapping("/")
	public String getWelcome(){
		return "<h1>Welcome for All</h1>";
	}
	
	@GetMapping("/admin")
	public String getAdmin(){
		return "<h1>Welcome admin Api</h1>";
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
       .antMatchers("/")
       .permitAll()
       .anyRequest()
       .authenticated();
    }
	
	
	
	@Autowired
	private OAuth2ClientContext oAuth2ClientContext;
	
	@GetMapping("/getToken")
	public String getTocken(){
		System.out.println("Token is:"+oAuth2ClientContext.getAccessToken().getValue());
		return oAuth2ClientContext.getAccessToken().getValue();
	}
	
}
