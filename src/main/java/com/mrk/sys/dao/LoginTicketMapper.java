package com.mrk.sys.dao;

import com.mrk.sys.dao.pre.BaseDao;
import com.mrk.sys.entity.LoginTicket;
import com.mrk.sys.entity.LoginTicketExample;

public interface LoginTicketMapper extends BaseDao<LoginTicket, LoginTicketExample, Integer> {
	public LoginTicket setlecByTicket(String ticket);
}