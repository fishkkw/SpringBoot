package com.mrk.sys.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Msg getAccountName(@PathVariable("id")  Integer id,HttpServletRequest request) { 
		logger.info("\naaa\r\t13002963275");
		return Msg.success().add("account",accountService.selectByPrimaryKey(id));
	}

}
