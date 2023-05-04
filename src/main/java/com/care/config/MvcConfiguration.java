package com.care.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.care.interceptor.AuthInterceptor;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private AuthInterceptor authInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
		.excludePathPatterns("/api/signup", "/api/login", 
				"/api/communities/**", "/api/community/{communityNum}"); 
		//interceptor가 적용되지 않을 경로 
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:5500");
		config.addAllowedOrigin("http://127.0.0.1:5500");
		config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedOrigin("http://127.0.0.1:3000");
		config.addAllowedOrigin("https://mindcare.p-e.kr/");
		config.addAllowedOrigin("https://www.mindcare.p-e.kr/");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		config.addAllowedOrigin("capacitor://localhost");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
