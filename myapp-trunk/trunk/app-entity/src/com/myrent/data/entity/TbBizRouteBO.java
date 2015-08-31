package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_biz_route")
public class TbBizRouteBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7402279389315242705L;
	
	@Id
	@Column(name="route_id", length=32)
	private String routeId;
	
	@Column(name="description",length=1024)
	private String description;
	
	@Column(name="route_name",length=100)
	private String routeName;
	
	@Column(name="theme_image",length=200)
	private String themeImage;
	
	@Column(name="route_status_cd",length=5)
	private String routeStatusCd;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;
	
	@Column(name="fail_reason",length=100)
	private String failReason;
	
	
	
	
	@OneToMany(mappedBy="route", cascade=CascadeType.REFRESH)
	private Set<TbBizRouteNodeBO> routeNodes;
	
	@OneToMany(mappedBy="route", cascade=CascadeType.REFRESH)
	private Set<TbBizRouteShareBO> shares;
	
	@OneToMany(mappedBy="route", cascade=CascadeType.REFRESH)
	private Set<TbBizRouteTipBO> tips;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmHostelBO hostel;
	
	@ManyToOne
	@JoinColumn(name="route_type_id")
	private TbBizRouteTypeBO routeType;
	
	@OneToMany(mappedBy="route",cascade=CascadeType.REFRESH)
	private Set<TbBizRouteDetailBO> details;

	public Set<TbBizRouteTipBO> getTips() {
		return tips;
	}

	public void setTips(Set<TbBizRouteTipBO> tips) {
		this.tips = tips;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Set<TbBizRouteNodeBO> getRouteNodes() {
		return routeNodes;
	}

	public void setRouteNodes(Set<TbBizRouteNodeBO> routeNodes) {
		this.routeNodes = routeNodes;
	}
	
    

	public TbCsmHostelBO getHostel() {
		return hostel;
	}

	public void setHostel(TbCsmHostelBO hostel) {
		this.hostel = hostel;
	}

	public Set<TbBizRouteShareBO> getShares() {
		return shares;
	}

	public void setShares(Set<TbBizRouteShareBO> shares) {
		this.shares = shares;
	}

	public TbBizRouteTypeBO getRouteType() {
		return routeType;
	}

	public void setRouteType(TbBizRouteTypeBO routeType) {
		this.routeType = routeType;
	}
	
	

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getThemeImage() {
		return themeImage;
	}

	public void setThemeImage(String themeImage) {
		this.themeImage = themeImage;
	}

	public String getRouteStatusCd() {
		return routeStatusCd;
	}

	public void setRouteStatusCd(String routeStatusCd) {
		this.routeStatusCd = routeStatusCd;
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

	public Set<TbBizRouteDetailBO> getDetails() {
		return details;
	}

	public void setDetails(Set<TbBizRouteDetailBO> details) {
		this.details = details;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteBO))
			return false;
		TbBizRouteBO other = (TbBizRouteBO) obj;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		return true;
	}
	
	
	
	

}
