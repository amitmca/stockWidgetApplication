package com.stockwidget.web.stockdetailservice.dao;

import org.springframework.data.annotation.Id;

public class Stock {

	@Id
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String name;
	private String unitValue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
	}
}
