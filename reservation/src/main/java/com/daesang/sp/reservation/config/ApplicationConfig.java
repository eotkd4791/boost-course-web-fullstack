package com.daesang.sp.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
	"com.daesang.sp.reservation.dao",
	"com.daesang.sp.reservation.service"
})
@Import({ DBConfig.class })
public class ApplicationConfig {}
