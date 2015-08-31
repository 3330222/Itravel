package com.myrent.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_hostel")
@PrimaryKeyJoinColumn(name="user_id")
public class TbCsmHostelBO extends TbCsmUserBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2317119214082007903L;

	@Column(name="manager_name",length=50)
	private String manager;
	
	@Column(name="manager_phone",length=20)
	private String managerPhone;
	
	@Column(name="register_num",length=30)
	private String registerNum;
	
	@Column(name="business_license_num",length=30)
	private String businessLicenseNum;
	
	@OneToMany(mappedBy="hostel", cascade=CascadeType.REFRESH)
	private Set<TbBizRouteBO> routes;

	
	
	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public String getBusinessLicenseNum() {
		return businessLicenseNum;
	}

	public void setBusinessLicenseNum(String businessLicenseNum) {
		this.businessLicenseNum = businessLicenseNum;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public Set<TbBizRouteBO> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<TbBizRouteBO> routes) {
		this.routes = routes;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbCsmHostelBO))
			return false;
		TbCsmHostelBO other = (TbCsmHostelBO) obj;
		if (this.getUserId() == null) {
			if (other.getUserId() != null)
				return false;
		} else if (!this.getUserId().equals(other.getUserId()))
			return false;
		return true;
	}
}
