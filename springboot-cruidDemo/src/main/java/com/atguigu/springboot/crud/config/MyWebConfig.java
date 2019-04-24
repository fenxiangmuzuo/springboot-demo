package com.atguigu.springboot.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.atguigu.springboot.crud.component.LoginIntercepter;
import com.atguigu.springboot.crud.component.MyLocalResolver;
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				System.out.println("intercepter=========");
				registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**")
					.excludePathPatterns("/index.html","/","/login","/**.ico");
			}

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("index").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
			
		};
	}
	@Bean
	public LocaleResolver localResolver() {
		MyLocalResolver myLocalResolver = new MyLocalResolver();
		System.out.println("mylocalresolver"+myLocalResolver);
		return myLocalResolver;
	} 
	
}
