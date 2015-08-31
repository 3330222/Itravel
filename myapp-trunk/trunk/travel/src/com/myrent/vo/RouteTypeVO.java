package com.myrent.vo;

import com.myrent.data.model.vo.BaseVO;

@SuppressWarnings("serial")
public class RouteTypeVO extends BaseVO{

	  private String routeTypeId;
	  private String routeName;
	  private String descrition;
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
	  
}
