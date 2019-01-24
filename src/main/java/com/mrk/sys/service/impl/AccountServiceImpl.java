package com.mrk.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrk.sys.dao.AccountMapper;
import com.mrk.sys.entity.Account;
import com.mrk.sys.service.AccountService;

@Service
@Repository("accountService")
public class AccountServiceImpl implements AccountService{
	@Autowired
	@Qualifier("accountMapper")
	private AccountMapper accountMapper; 
	@Override
	@Transactional 
	public Account selectByPrimaryKey(Integer id) {
		return accountMapper.selectByPrimaryKey(id);
	}

}
