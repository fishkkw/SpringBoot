package com.mrk.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.mrk.sys.dao.DfMoneyFileMapper; 
import com.mrk.sys.entity.DfMoneyFile; 
import com.mrk.sys.service.DfMoneyFileService;

@Service
@Repository("dfMoneyFileService")
public class DfMoneyFileServiceImpl implements DfMoneyFileService{
	@Autowired
	@Qualifier("dfMoneyFileMapper")
	private DfMoneyFileMapper dfMoneyFileMapper; 
	@Override
	@Transactional 
	public List<DfMoneyFile> selectByExample() {
		return dfMoneyFileMapper.selectByExample();
	} 

}
