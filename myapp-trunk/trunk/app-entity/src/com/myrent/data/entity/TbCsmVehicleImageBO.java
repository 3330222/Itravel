package com.myrent.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_vehicle_image")
public class TbCsmVehicleImageBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7322002465145319484L;

	/**
	 * 
	 */
    

	@Id
	@Column(name="image_id")
	private String imageId;
	
	@Column
	private Integer ordinal;
	
	@Column(length=200)
	private String url;
	
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private TbCsmVehicleBO  vehicle;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
    
	

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TbCsmVehicleBO getVehicle() {
		return vehicle;
	}

	public void setVehicle(TbCsmVehicleBO vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbCsmVehicleImageBO))
			return false;
		TbCsmVehicleImageBO other = (TbCsmVehicleImageBO) obj;
		if (imageId == null) {
			if (other.imageId != null)
				return false;
		} else if (!imageId.equals(other.imageId))
			return false;
		return true;
	}

	
	
}
