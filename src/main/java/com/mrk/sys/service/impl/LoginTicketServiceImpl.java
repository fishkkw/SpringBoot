package com.mrk.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrk.sys.dao.LoginTicketMapper;
import com.mrk.sys.entity.LoginTicket;
import com.mrk.sys.entity.LoginTicketExample;
import com.mrk.sys.service.LoginTicketService;

@Service
@Repository("loginTicketService")
public class LoginTicketServiceImpl implements LoginTicketService{
	@Autowired
	@Qualifier("loginTicketMapper")
	private LoginTicketMapper loginTicketMapper; 
	@Override
	@Transactional  
	public int deleteByPrimaryKey(Integer key) {
		return loginTicketMapper.deleteByPrimaryKey(key);
	}
	@Override
	@Transactional
	public int insert(LoginTicket record) {
		return loginTicketMapper.insert(record);
	}
	@Override
	@Transactional
	public int insertSelective(LoginTicket record) {
		return loginTicketMapper.insertSelective(record);
	}
	@Override
	@Transactional
	public LoginTicket selectByPrimaryKey(Integer key) {
		return loginTicketMapper.selectByPrimaryKey(key);
	}
	@Override
	@Transactional
	public int updateByPrimaryKeySelective(LoginTicket record) {
		return loginTicketMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	@Transactional
	public int updateByPrimaryKey(LoginTicket record) {
		return loginTicketMapper.updateByPrimaryKey(record);
	}
	@Override
	public long countByExample(LoginTicketExample example) {
		return loginTicketMapper.countByExample(example);
	}
	@Override
	public int deleteByExample(LoginTicketExample example) {
		return loginTicketMapper.deleteByExample(example);
	}
	@Override
	public List<LoginTicket> selectByExample(LoginTicketExample example) {
		return loginTicketMapper.selectByExample(example);
	}
	@Override
	public int updateByExampleSelective(LoginTicket record, LoginTicketExample example) {
		return loginTicketMapper.updateByExampleSelective(record, example);
	}
	@Override
	public int updateByExample(LoginTicket record, LoginTicketExample example) {
		return loginTicketMapper.updateByExample(record, example);
	}
	@Override
	public LoginTicket setlecByTicket(String ticket) {
		return loginTicketMapper.setlecByTicket(ticket);
	}

}
