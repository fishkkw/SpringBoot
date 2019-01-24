package com.mrk.webassist.interceptor;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		LOGGER.info("[" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "]{" + request.getRemoteAddr()
				+ "} 执行" + getClassMethod(handler) + "[" + request.getMethod() + "]");

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	protected String getClassMethod(Object object) {
		if (object instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) object;
			Class<?> clazz = handlerMethod.getBeanType();
			Method method = handlerMethod.getMethod();

			return clazz.getName() + "." + method.getName();
		} else if(object instanceof ResourceHttpRequestHandler){
			return  object.getClass().getName();
		}
		return "执行未知操作:" + object.getClass();
	}

}
