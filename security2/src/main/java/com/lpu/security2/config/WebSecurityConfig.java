package com.lpu.security2.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableMethodSecurity  //for pre/post authorize
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http.cors(c->{}); 
		//http.csrf((csrf)->csrf.disable()); 
	
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/add").permitAll()
		.requestMatchers("/delete","/findAll").hasRole("ADMIN")  

		.requestMatchers("/update").hasAnyRole("ADMIN","USER")
		 .anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.headers(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults()); 
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();  //can pass number of rounds we wants to encrypt it, by default it is 10 means converting pwd to hash then hash->hash.... 10 times
	}
	
	
	//cors- giving rules for frontend
	@Bean
	public CorsConfigurationSource corsConfigurationSOurce() {
		CorsConfiguration config=new CorsConfiguration();
		config.setAllowedOrigins(List.of("http://localhost:3000"));
		config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
				
		source.registerCorsConfiguration("/**", config); //we are allowing all apis to follow rules in config
		return source;
		
		
	}
}


