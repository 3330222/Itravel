package com.myrent.vo;


import java.sql.Timestamp;

import com.myrent.data.model.vo.BaseVO;
import com.myrent.vo.user.UserVO;

@SuppressWarnings("serial")
public class PlanVO extends BaseVO {
	private String planid;
	private int adult;
	private int child;
	private String daysupplement;
	private String destination;
	private String personsupplement;
	private String stauts;
	private Timestamp traveldate;
	private String traveldays;
	private UserVO user;

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public String getDaysupplement() {
		return daysupplement;
	}

	public void setDaysupplement(String daysupplement) {
		this.daysupplement = daysupplement;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPersonsupplement() {
		return personsupplement;
	}

	public void setPersonsupplement(String personsupplement) {
		this.personsupplement = personsupplement;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public Timestamp getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(Timestamp traveldate) {
		this.traveldate = traveldate;
	}

	public String getTraveldays() {
		return traveldays;
	}

	public void setTraveldays(String traveldays) {
		this.traveldays = traveldays;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

}
