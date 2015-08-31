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
@Table(name="tb_csm_vehicle")
public class TbCsmVehicleBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5446664187945200200L;

	@Id
	@Column(name="vehicle_id")
	private String vehicleId;
	
	@Column
	private Integer persons;
	
	@Column(name="production_time")
	private Timestamp productionTime;
	
	@Column(length=30)
	private String brand;
	
	@Column(name="licence_plate",length=20)
	private String licencePlate;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private TbCsmDriverBO driver;
	
	@OneToMany(mappedBy="vehicle",cascade=CascadeType.REFRESH)
	private Set<TbCsmVehicleImageBO> images;
	
	
	@OneToMany(mappedBy="vehicle",cascade=CascadeType.REFRESH)
	private Set<TbBizRouteDetailBO> routeDetails;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getPersons() {
		return persons;
	}

	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	public Timestamp getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(Timestamp productionTime) {
		this.productionTime = productionTime;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public TbCsmDriverBO getDriver() {
		return driver;
	}

	public void setDriver(TbCsmDriverBO driver) {
		this.driver = driver;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public Set<TbCsmVehicleImageBO> getImages() {
		return images;
	}

	public void setImages(Set<TbCsmVehicleImageBO> images) {
		this.images = images;
	}

	
	
	public Set<TbBizRouteDetailBO> getRouteDetails() {
		return routeDetails;
	}

	public void setRouteDetails(Set<TbBizRouteDetailBO> routeDetails) {
		this.routeDetails = routeDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vehicleId == null) ? 0 : vehicleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbCsmVehicleBO))
			return false;
		TbCsmVehicleBO other = (TbCsmVehicleBO) obj;
		if (vehicleId == null) {
			if (other.vehicleId != null)
				return false;
		} else if (!vehicleId.equals(other.vehicleId))
			return false;
		return true;
	}
	
	
	
}
