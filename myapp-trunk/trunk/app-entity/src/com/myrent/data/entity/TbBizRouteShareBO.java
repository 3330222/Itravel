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
@Table(name="tb_biz_route_share")
public class TbBizRouteShareBO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -691494433590664551L;

	@Id
	@Column(name="share_id")
	private String shareId;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private TbBizRouteBO route;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO createUser;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public TbBizRouteBO getRoute() {
		return route;
	}

	public void setRoute(TbBizRouteBO route) {
		this.route = route;
	}

	public TbCsmUserBO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TbCsmUserBO createUser) {
		this.createUser = createUser;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shareId == null) ? 0 : shareId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteShareBO))
			return false;
		TbBizRouteShareBO other = (TbBizRouteShareBO) obj;
		if (shareId == null) {
			if (other.shareId != null)
				return false;
		} else if (!shareId.equals(other.shareId))
			return false;
		return true;
	}
	
	

}
