package com.mrk.webassist;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mrk.webassist.filter.WebFilter;
import com.mrk.webassist.interceptor.LoginInterceptor;
import com.mrk.webassist.interceptor.TicketInterceptor;
import com.mrk.webassist.listener.WebHttpSessionListener;

@Configuration
public class WebConfigurer implements WebMvcConfigurer{
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Autowired
	private TicketInterceptor ticketInterceptor;
	@Autowired
	private WebFilter webFilter;
	@Autowired
	private WebHttpSessionListener httpSessionListener; 
	
	//过滤器注册 
	@Bean
    public FilterRegistrationBean<Filter> filterRegist() { 
		FilterRegistrationBean<Filter> frBean =new FilterRegistrationBean<>();
        frBean.setFilter(webFilter);
        frBean.addUrlPatterns("/*");
        frBean.setOrder(1);
        return frBean;
    }
	//拦截器注册
	@Override
	public void addInterceptors(InterceptorRegistry interceptorregistry) {
		interceptorregistry.addInterceptor(loginInterceptor).addPathPatterns("/**");
		interceptorregistry.addInterceptor(ticketInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**").excludePathPatterns("/error");
		WebMvcConfigurer.super.addInterceptors(interceptorregistry); 
	}
	//监听器
    @Bean
    public ServletListenerRegistrationBean<WebHttpSessionListener> listenerRegist() {
        ServletListenerRegistrationBean<WebHttpSessionListener> srb = new ServletListenerRegistrationBean<WebHttpSessionListener>();
        srb.setListener(httpSessionListener);
        return srb;
    }

	
}
