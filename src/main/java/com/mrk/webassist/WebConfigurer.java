package com.mrk.webassist;

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

/**
 * @author mrk
 *
 */
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public FilterRegistrationBean filterRegist() { 
		FilterRegistrationBean frBean =new FilterRegistrationBean<>();
        frBean.setFilter(webFilter);
        frBean.addUrlPatterns("/*");
        frBean.setOrder(1);
        return frBean;
    }
	//拦截器注册
	@Override
	public void addInterceptors(InterceptorRegistry interceptorregistry) {
		interceptorregistry.addInterceptor(ticketInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**").excludePathPatterns("/error");
		interceptorregistry.addInterceptor(loginInterceptor).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(interceptorregistry); 
	}
	//监听器
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(httpSessionListener);
        return srb;
    }

	
}
