package com.myrent.vo;

import java.sql.Timestamp;

import com.myrent.data.model.vo.BaseVO;

@SuppressWarnings("serial")
public class DetailVO extends BaseVO{
	private String id;
	private Double price;
	private Timestamp sTimes;
	private Timestamp eTimes;
	private String vehiclename;
	private int limit;
	private String launchday;
	private RouteVO info;
	private int number;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Timestamp getsTimes() {
		return sTimes;
	}
	public void setsTimes(Timestamp sTimes) {
		this.sTimes = sTimes;
	}
	public Timestamp geteTimes() {
		return eTimes;
	}
	public void seteTimes(Timestamp eTimes) {
		this.eTimes = eTimes;
	}
	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getLaunchday() {
		return launchday;
	}
	public void setLaunchday(String launchday) {
		this.launchday = launchday;
	}
	public RouteVO getInfo() {
		return info;
	}
	public void setInfo(RouteVO info) {
		this.info = info;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
