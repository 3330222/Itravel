package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_password_reset")
public class TbCsmPasswordResetBO implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reset_id")
	private String resetId;
	
	@Column(name="password_reset_status_cd",length=5)
	private String passwordRestStatusCd;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;
	
	@Column(length=200)
	private String url;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO createUser;

	public String getResetId() {
		return resetId;
	}

	public void setResetId(String resetId) {
		this.resetId = resetId;
	}

	public String getPasswordRestStatusCd() {
		return passwordRestStatusCd;
	}

	public void setPasswordRestStatusCd(String passwordRestStatusCd) {
		this.passwordRestStatusCd = passwordRestStatusCd;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TbCsmUserBO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TbCsmUserBO createUser) {
		this.createUser = createUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resetId == null) ? 0 : resetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbCsmPasswordResetBO))
			return false;
		TbCsmPasswordResetBO other = (TbCsmPasswordResetBO) obj;
		if (resetId == null) {
			if (other.resetId != null)
				return false;
		} else if (!resetId.equals(other.resetId))
			return false;
		return true;
	}

}
