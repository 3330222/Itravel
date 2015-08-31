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
@Table(name="tb_sys_role")
public class TbSysRoleBO implements Serializable{

	private static final long serialVersionUID = 2582682099502376508L;

	@Id
	@Column(name="role_id", length=32)
	private String roleId;
	
    @Column(name="role_name", length=40, unique=true)
	private String roleName;
    
    @Column(name="role_status_cd",length=2)
    private String roleStatusCd;
    
    @ManyToMany(cascade=CascadeType.REFRESH)
    @JoinTable(
			name="tb_sys_role_resource",
			joinColumns=@JoinColumn(name="role_id",referencedColumnName="role_id"),
			inverseJoinColumns=@JoinColumn(name="resource_id", referencedColumnName="resource_id")
    )
    private Set<TbSysResourceBO> resources;
    
    
    @ManyToMany(mappedBy="roles")
	private Set<TbCsmUserBO> users;
    
    
    

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleStatusCd() {
		return roleStatusCd;
	}

	public void setRoleStatusCd(String roleStatusCd) {
		this.roleStatusCd = roleStatusCd;
	}


	public Set<TbSysResourceBO> getResources() {
		return resources;
	}

	public void setResources(Set<TbSysResourceBO> resources) {
		this.resources = resources;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysRoleBO))
			return false;
		TbSysRoleBO other = (TbSysRoleBO) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	public Set<TbCsmUserBO> getUsers() {
		return users;
	}

	public void setUsers(Set<TbCsmUserBO> users) {
		this.users = users;
	}
	
	
	
}
