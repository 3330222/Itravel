package com.myrent.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_sys_resource")
public class TbSysResourceBO implements Serializable{

	
	private static final long serialVersionUID = -8698790849806712198L;
	
	@Id
	@Column(name="resource_id", length=32)
	private String resourceId;
	
	@Column(name="resource_name", length=50)
	private String resourceName;
	
	@Column(length=200)
	private String url;
	
	@Column(name="resourceStatusCd", length=2)
	private String resourceStatusCd;
	
	
	@ManyToMany(mappedBy="resources", cascade=CascadeType.REFRESH)
	private Set<TbSysRoleBO> roles;


	public String getResourceId() {
		return resourceId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getResourceStatusCd() {
		return resourceStatusCd;
	}


	public void setResourceStatusCd(String resourceStatusCd) {
		this.resourceStatusCd = resourceStatusCd;
	}


	public Set<TbSysRoleBO> getRoles() {
		return roles;
	}


	public void setRoles(Set<TbSysRoleBO> roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((resourceId == null) ? 0 : resourceId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysResourceBO))
			return false;
		TbSysResourceBO other = (TbSysResourceBO) obj;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		return true;
	}
}
