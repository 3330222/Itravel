package com.myrent.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_biz_route_type")
public class TbBizRouteTypeBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7799713217711861147L;

	@Id
	@Column(name="route_type_id",length=32)
	private String routeTypeId;
	
	@Column(name="route_name",length=50)
	private String routeName;
	
	@Column(length=100)
	private String descrition;
	
	@OneToMany(mappedBy="routeType",cascade=CascadeType.REFRESH)
	private Set<TbBizRouteBO> routes;

	public String getRouteTypeId() {
		return routeTypeId;
	}

	public void setRouteTypeId(String routeTypeId) {
		this.routeTypeId = routeTypeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public Set<TbBizRouteBO> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<TbBizRouteBO> routes) {
		this.routes = routes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((routeTypeId == null) ? 0 : routeTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteTypeBO))
			return false;
		TbBizRouteTypeBO other = (TbBizRouteTypeBO) obj;
		if (routeTypeId == null) {
			if (other.routeTypeId != null)
				return false;
		} else if (!routeTypeId.equals(other.routeTypeId))
			return false;
		return true;
	}
	
	
}
