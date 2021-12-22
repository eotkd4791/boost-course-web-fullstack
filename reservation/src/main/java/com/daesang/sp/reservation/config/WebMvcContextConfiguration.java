package com.daesang.sp.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static com.daesang.sp.reservation.utils.Constants.CACHE_PERIOD;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { 
	"com.daesang.sp.reservation.controller"
})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCachePeriod(CACHE_PERIOD);
		registry.addResourceHandler("/img/**")
				.addResourceLocations("/img/")
				.setCachePeriod(CACHE_PERIOD);
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/css/")
				.setCachePeriod(CACHE_PERIOD);
		registry.addResourceHandler("/js/**")
				.addResourceLocations("/js/")
				.setCachePeriod(CACHE_PERIOD);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}