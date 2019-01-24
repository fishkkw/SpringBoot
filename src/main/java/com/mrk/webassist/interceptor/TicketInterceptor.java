package com.mrk.webassist.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mrk.assist.util.conf.MyProperties;
import com.mrk.sys.entity.Account;
import com.mrk.sys.entity.LoginTicket;
import com.mrk.sys.service.AccountService;
import com.mrk.sys.service.LoginTicketService;
import com.mrk.webassist.HostHolder;

@Component
@EnableConfigurationProperties({ MyProperties.class })
public class TicketInterceptor implements HandlerInterceptor {
	@Autowired
	@Qualifier("loginTicketService")
	private LoginTicketService loginTicketService;
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketInterceptor.class);
	@Autowired
	private MyProperties myProperties;
	@Autowired
	private HostHolder hostHolder;
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String tickets = null;
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("ticket")) {
					tickets = cookie.getValue();
					break;
				}
			}
		}
		if (myProperties.getTicket().equals("true") & tickets != null) {
			LoginTicket loginTicket = loginTicketService.setlecByTicket(tickets);
			if (loginTicket == null || loginTicket.getExpired().before(new Date()) || loginTicket.getStatus() != 0) {
				response.sendRedirect(myProperties.getTicketURL());
				LOGGER.info("--------登陆过期--------");
				return false;
			}
			Account account = accountService.selectByPrimaryKey(loginTicket.getUserId());
			hostHolder.setAccount(account);
			Date date = new Date();
			date.setTime(loginTicket.getExpired().getTime() - 1000 * 60 * 3);
			if (new Date().after(date)) {
				date.setTime(loginTicket.getExpired().getTime() + myProperties.getTicketTime());
				loginTicket.setExpired(date);
				loginTicketService.updateByPrimaryKey(loginTicket);
			}

		} else if (myProperties.getTicket().equals("true")) {
			response.sendRedirect(myProperties.getTicketURL());
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 就是为了能够在渲染之前所有的freemaker模板能够访问这个对象user，就是在所有的controller渲染之前将这个user加进去
		if (modelAndView != null) {
			// 这个其实就和model.addAttribute一样的功能，就是把这个变量与前端视图进行交互 //就是与header.html页面的user对应
			modelAndView.addObject("user", hostHolder.getAccount());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		hostHolder.clear(); // 当执行完成之后呢需要将变量清空
	}

}
