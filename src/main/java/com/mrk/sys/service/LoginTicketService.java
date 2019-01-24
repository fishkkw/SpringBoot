package com.mrk.sys.service;
 
import java.util.List;

import com.mrk.sys.entity.LoginTicket;
import com.mrk.sys.entity.LoginTicketExample;

public interface LoginTicketService {

	public int deleteByPrimaryKey(Integer key) ;

	public int insert(LoginTicket record);
	public int insertSelective(LoginTicket record) ;

	public LoginTicket selectByPrimaryKey(Integer key) ;

	public int updateByPrimaryKeySelective(LoginTicket record) ;

	public int updateByPrimaryKey(LoginTicket record) ;

	public long countByExample(LoginTicketExample example);
	public LoginTicket setlecByTicket(String ticket);

	public int deleteByExample(LoginTicketExample example) ;
	
	public List<LoginTicket> selectByExample(LoginTicketExample example);
	
	public int updateByExampleSelective(LoginTicket record, LoginTicketExample example);
	
	public int updateByExample(LoginTicket record, LoginTicketExample example);
	 
}
