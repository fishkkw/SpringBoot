package com.mrk.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrk.sys.entity.DfMoneyFile; 
@Repository("dfMoneyFileMapper")
public interface DfMoneyFileMapper {
	List<DfMoneyFile> selectByExample();
}