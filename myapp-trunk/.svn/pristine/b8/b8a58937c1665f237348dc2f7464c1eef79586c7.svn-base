package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_employee")
public class TbCsmEmployeeBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8452911961627142866L;

	@Id
	@Column(name="employee_id",length=32)
	private String employeeId;
	
	
	
	
	@Column(name="employee_name",length=200)
	private String employeeName;
	
	
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="address",length=200)
	private String address;
	
	

	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	
	
}
