package com.mrk.webassist.interceptor;

import java.lang.reflect.Method;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception { 
		LOGGER.info(request.getRequestURI()+"start....");
		//LOGGER.info("[" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "]{" + request.getRemoteAddr()
		//+ "} 执行" + getClassMethod(handler) + "[" + request.getMethod() + "] start...");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOGGER.info(request.getRequestURI()+"end...");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
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
