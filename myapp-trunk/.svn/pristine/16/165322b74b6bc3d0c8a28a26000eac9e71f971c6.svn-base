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
@Table(name="tb_sys_anoucement")
public class TbSysAnouncementBO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4299875543131356164L;

	@Id
    @Column(name="anouncement_id")
	private String anouncementId;
	
    @Column(length=500)
	private String content;
	
    @Column(name="create_time")
	private Timestamp createTime;
	
    @Column(name="update_time")
	private Timestamp updateTime;
	
    @ManyToOne
    @JoinColumn(name="user_id")
	private TbCsmUserBO createUser;
	
    @Column(name="anouncement_status_cd", length=5)
	private String anouncementStatusCd;

	public String getAnouncementId() {
		return anouncementId;
	}

	public void setAnouncementId(String anouncementId) {
		this.anouncementId = anouncementId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public TbCsmUserBO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TbCsmUserBO createUser) {
		this.createUser = createUser;
	}

	public String getAnouncementStatusCd() {
		return anouncementStatusCd;
	}

	public void setAnouncementStatusCd(String anouncementStatusCd) {
		this.anouncementStatusCd = anouncementStatusCd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anouncementId == null) ? 0 : anouncementId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysAnouncementBO))
			return false;
		TbSysAnouncementBO other = (TbSysAnouncementBO) obj;
		if (anouncementId == null) {
			if (other.anouncementId != null)
				return false;
		} else if (!anouncementId.equals(other.anouncementId))
			return false;
		return true;
	}
    
}
