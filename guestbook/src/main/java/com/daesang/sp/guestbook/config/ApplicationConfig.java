package com.daesang.sp.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.daesang.sp.guestbook.dao", "com.daesang.sp.guestbook.service" }) // 명시한 것들이 실행될때 DB가 필요해서 아래 임포트를 해줌
@Import({ DBConfig.class })
public class ApplicationConfig {}
