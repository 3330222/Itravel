package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_driver")
public class TbCsmDriverBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668903995164212857L;

	@Id
	@Column(name="driver_id",length=32)
	private String driverId;
	
	@Column(name="driver_name", length=50)
	private String driverName;
	
	@Column(name="driving_licence",length=30)
	private String drivingLicence;
	
	@Column(name="licence_issue_time")
	private Timestamp licenceIssueTime;
	
	@Column(name="licence_expiring_time")
	private Timestamp licenceExpringTime;
	
	@Column(name="experience_years")
	private String experienceYears;
	
	@Column(name="driver_status_cd",length=5)
	private String driverStatusCd;
	
	@Column(name="phone_num",length=20)
	private String phoneNum;
	
	@Column(length=80)
	private String address;
	
	@Column(length=80)
	private String email;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public Timestamp getLicenceIssueTime() {
		return licenceIssueTime;
	}

	public void setLicenceIssueTime(Timestamp licenceIssueTime) {
		this.licenceIssueTime = licenceIssueTime;
	}

	public Timestamp getLicenceExpringTime() {
		return licenceExpringTime;
	}

	public void setLicenceExpringTime(Timestamp licenceExpringTime) {
		this.licenceExpringTime = licenceExpringTime;
	}

	public String getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(String experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getDriverStatusCd() {
		return driverStatusCd;
	}

	public void setDriverStatusCd(String driverStatusCd) {
		this.driverStatusCd = driverStatusCd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
