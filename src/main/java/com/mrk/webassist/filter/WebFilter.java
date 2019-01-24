package com.mrk.webassist.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebFilter implements Filter{
	private static final Logger LOGGER = LoggerFactory.getLogger(WebFilter.class);
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("WebFilter-init");
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	//跨域设置
    	if(response instanceof HttpServletResponse){
    		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
    		//通过在响应 header 中设置 ‘*’ 来允许来自所有域的跨域请求访问。
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
    		//通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie
            //设置了Allow-Credentials，Allow-Origin就不能为*,需要指明具体的url域
            //httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            //请求方式
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
            //（预检请求）的返回结果（即 Access-Control-Allow-Methods 和Access-Control-Allow-Headers 提供的信息） 可以被缓存多久
            httpServletResponse.setHeader("Access-Control-Max-Age", "86400");
            //首部字段用于预检请求的响应。其指明了实际请求中允许携带的首部字段
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
    	}
    	//sql,xss过滤
    	//ObjectMapper mapper=new ObjectMapper();
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        //LOGGER.info("CrosXssFilter.......orignal url:{},ParameterMap:{}",httpServletRequest.getRequestURI(),mapper.writeValueAsString(httpServletRequest.getParameterMap()));
        XssHttpServletRequestWrapper xssHttpServletRequestWrapper=new XssHttpServletRequestWrapper(
                httpServletRequest);
        filterChain.doFilter(xssHttpServletRequestWrapper, response);
        //xssHttpServletRequestWrapper.getParameterMap();
        //LOGGER.info("CrosXssFilter..........doFilter url:{},ParameterMap:{}",xssHttpServletRequestWrapper.getRequestURI(), mapper.writeValueAsString(xssHttpServletRequestWrapper.getParameterMap()));
 	}
	@Override
    public void destroy() {

    }

}
