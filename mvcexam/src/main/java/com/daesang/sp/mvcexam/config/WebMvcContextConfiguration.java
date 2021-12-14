package com.daesang.sp.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.daesang.sp.mvcexam.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//모든 요청을 DispatchServlet에서 받는데 정적 파일 요청 또한 받게됨.
		// 따라서 resourceHandler함수의 인자로 들어가는 경로로 들어오는 요청들은
		// 앱의 루트 디렉토리 아래의 resourceLocations 인자 정의된 경로에서 리소스를 찾도록 한다.
		// 이 부분 작성하지 않으면 컨트롤러에서만 찾으려고 하면서 에러 발생.
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 파라미터로 전달받은 객체의 메소드 호출.
		// 이를 통해 servlet default handler를 사용하게 해줌.
		// 이것은 매핑 정보가 없는 요청은 spring의 DefaultServletHttpRequestHandler가 처리하게 함.
		// DefaultServletHttpRequestHandler는 WAS의 DefaultServlet에게 해당 일을 넘기고
		// WAS는 DefaultServlet이 static한 자원을 읽어서 보여주게함.
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		// 해당 메소드는 특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있게해줌.
		// /로 들어오는 요청에는 main이라는 view를 보여줌.
		// main이라는 이름을 가지고 아래 메소드를 통해서 View 정보를 찾음
		System.out.println("addViewControllers가 호출됩니다.");
		registry.addViewController("/").setViewName("main");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;	
	}
}
