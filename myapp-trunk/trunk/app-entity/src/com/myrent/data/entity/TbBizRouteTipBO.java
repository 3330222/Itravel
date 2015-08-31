package com.myrent.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_biz_route_tip")
public class TbBizRouteTipBO implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3360116492407007865L;

	@Id
	@Column(name="tip_id",length=32)
	private String tipId;
	
	@Column(length=50)
	private String head;
	
	@Column(length=50)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="routeId")
	private TbBizRouteBO route;

	public String getTipId() {
		return tipId;
	}

	public void setTipId(String tipId) {
		this.tipId = tipId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TbBizRouteBO getRoute() {
		return route;
	}

	public void setRoute(TbBizRouteBO route) {
		this.route = route;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipId == null) ? 0 : tipId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteTipBO))
			return false;
		TbBizRouteTipBO other = (TbBizRouteTipBO) obj;
		if (tipId == null) {
			if (other.tipId != null)
				return false;
		} else if (!tipId.equals(other.tipId))
			return false;
		return true;
	}
	
	

}
