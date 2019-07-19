package com.mrk.assist.util.excal;

import java.util.List; 
public class PoiExcel {  
	// 表头
    private List<String> columnS;
    
    private String title;
    // 数据
    private List<?> rows;

    // 页签名称
    private String name;

	/**
	 * @return the columnS
	 */
	public List<String> getColumnS() {
		return columnS;
	}

	/**
	 * @param columnS the columnS to set
	 */
	public void setColumnS(List<String> columnS) {
		this.columnS = columnS;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the rows
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
    
    
}
