package com.mrk.sys.web;
 

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrk.assist.util.conf.MyProperties;
import com.mrk.sys.entity.Account;
import com.mrk.sys.entity.LoginTicket;
import com.mrk.sys.service.AccountService;
import com.mrk.sys.service.LoginTicketService;

@Controller
@RequestMapping("/login") 
@EnableConfigurationProperties({MyProperties.class})
public class MainJsp {
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Autowired
	private MyProperties myProperties;
	
	@Autowired
	@Qualifier("loginTicketService")
	private LoginTicketService loginTicketService;
	@RequestMapping(value="/a")
	public String hello(Model model){  
		Account account=new Account();
		model.addAttribute("account", account);
		return "list";
	}
	@RequestMapping(value="/b",method= {RequestMethod.POST})
	public String login(Account account,Model model,HttpServletResponse response,HttpServletRequest request){  
		account=accountService.selectByPrimaryKey(account.getId());
		if(account!=null) {    
			Cookie cookie = new Cookie("ticket",this.addLoginTicket(account.getId()).toString());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
             response.addCookie(cookie); 
		}else {
			model.addAttribute("msg", "账户不存在");
		}
		return "list";
	}
	
	public String addLoginTicket(int user_id){
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(user_id);
        Date nowDate = new Date(); 
        nowDate.setTime(myProperties.getTicketTime() + nowDate.getTime());
        ticket.setExpired(nowDate);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("_",""));
        loginTicketService.insert(ticket);
        return ticket.getTicket();

    }

}
