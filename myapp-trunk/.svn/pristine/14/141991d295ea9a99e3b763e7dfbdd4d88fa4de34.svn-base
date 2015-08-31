package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
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
@Table(name="tb_biz_route_detail")
public class TbBizRouteDetailBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="detail_id")
	private String detailId;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="route_id")
	private TbBizRouteBO route;
	
	@Column(name="start_time")
	private Timestamp startTime;
	
	@Column(name="end_time")
	private Timestamp endTime;
	
	@Column(name="route_detail_status_cd")
	private String routeDetailStatusCd;

	@Column
	private Double price;
	
	@Column(name="day_of_week",length=50)
	private String dayOfWeek;
	
	@Column(name="tour_group_limit")
	private Integer tourGroupLimit;
	
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private TbCsmVehicleBO vehicle;
	
	@Column(name="vehicle_type",length=5)
	private String vehicleType;
	
	@OneToMany(mappedBy="routeDetail")
	private Set<TbBizOrderBO> orders = new HashSet<TbBizOrderBO>();
	
	
	
	

	public Set<TbBizOrderBO> getOrders() {
		return orders;
	}

	public void setOrders(Set<TbBizOrderBO> orders) {
		this.orders = orders;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Integer getTourGroupLimit() {
		return tourGroupLimit;
	}

	public void setTourGroupLimit(Integer tourGroupLimit) {
		this.tourGroupLimit = tourGroupLimit;
	}

	public TbBizRouteBO getRoute() {
		return route;
	}

	public void setRoute(TbBizRouteBO route) {
		this.route = route;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getRouteDetailStatusCd() {
		return routeDetailStatusCd;
	}

	public void setRouteDetailStatusCd(String routeDetailStatusCd) {
		this.routeDetailStatusCd = routeDetailStatusCd;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TbCsmVehicleBO getVehicle() {
		return vehicle;
	}

	public void setVehicle(TbCsmVehicleBO vehicle) {
		this.vehicle = vehicle;
	}
	
	

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((detailId == null) ? 0 : detailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteDetailBO))
			return false;
		TbBizRouteDetailBO other = (TbBizRouteDetailBO) obj;
		if (detailId == null) {
			if (other.detailId != null)
				return false;
		} else if (!detailId.equals(other.detailId))
			return false;
		return true;
	}

    
	
}
