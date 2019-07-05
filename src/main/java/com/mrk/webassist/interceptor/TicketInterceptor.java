package com.mrk.webassist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mrk.sys.service.AccountService;
import com.mrk.sys.service.LoginTicketService;
import com.mrk.webassist.HostHolder;

@Component
public class TicketInterceptor implements HandlerInterceptor {
	@Autowired
	@Qualifier("loginTicketService")
	private LoginTicketService loginTicketService;
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception { 
		if (modelAndView != null) { 
			modelAndView.addObject("user", HostHolder.getAccount());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HostHolder.clear();
	}

}
