package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class TbSysLoginToken implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8135791373018110261L;

	@Id
	@Column(length=64)
	private String series;
	
	@Column(name="username",length=100)
	private String userName;
	
	@Column(length=64)
	private String token;
	
	@Column(name="last_used",nullable=false)
	private Timestamp lastUsed;

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysLoginToken))
			return false;
		TbSysLoginToken other = (TbSysLoginToken) obj;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		return true;
	}
}
