package com.mrk.sys.dao.pre;
 
public interface BaseDaoPre<T,PK> { 

	int deleteByPrimaryKey(PK key);

	int insert(T record);

	int insertSelective(T record);
 
	T selectByPrimaryKey(PK key);
 
	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);
}
