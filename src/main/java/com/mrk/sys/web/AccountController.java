package com.mrk.sys.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrk.sys.entity.Msg;
import com.mrk.sys.service.AccountService; 

@RestController
@RequestMapping("/account") 
public class AccountController {
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Msg getAccountName(@PathVariable("id")  Integer id,HttpServletRequest request) { 
		return Msg.success().add("account",accountService.selectByPrimaryKey(id));
	}

}
