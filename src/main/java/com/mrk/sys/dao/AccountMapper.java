package com.mrk.sys.dao;

import org.springframework.stereotype.Repository;

import com.mrk.sys.dao.pre.BaseDaoPre;
import com.mrk.sys.entity.Account;
@Repository("accountMapper")
public interface AccountMapper extends BaseDaoPre<Account, Integer> {
}