package com.mrk.sys.dao.pre;

import java.util.List;

import org.apache.ibatis.annotations.Param; 

public interface BaseDao<T, M, PK> extends BaseDaoPre<T, PK>{
	long countByExample(M example);

	int deleteByExample(M example);
 
	List<T> selectByExample(M example);
 
	int updateByExampleSelective(@Param("record") T record,
			@Param("example") M example);

	int updateByExample(@Param("record") T record,
			@Param("example") M example);
 
}
