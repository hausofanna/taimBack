package com.taimBack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Encoder {

	@Bean(name = "passwordEncoder")
	BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}