package com.mrk.sys.entity;

import java.io.Serializable;

public class Account implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6109101334104319143L;

	private Integer id;

    private String name;

    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}