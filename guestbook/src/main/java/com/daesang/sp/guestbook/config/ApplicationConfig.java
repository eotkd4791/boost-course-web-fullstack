package com.daesang.sp.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.daesang.sp.guestbook.dao", "com.daesang.sp.guestbook.service" })
@Import({ DBConfig.class })
public class ApplicationConfig {}
