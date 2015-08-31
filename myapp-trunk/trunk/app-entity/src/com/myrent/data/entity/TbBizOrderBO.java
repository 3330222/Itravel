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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_biz_order")
public class TbBizOrderBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5443562621707933967L;

	@Id
	@Column(name="order_id",length=32)
	private String orderId;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.REFRESH)
	private Set<TbBizOrderMessageBO> messages;
	
	@ManyToOne
	@JoinColumn(name="route_detail_id")
	private TbBizRouteDetailBO routeDetail;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO createUser;
	
	@Column(name="order_status_cd")
	private String orderStatusCd;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;
	
	@Column(name="travel_date")
	private Timestamp travelDate;
	
	
	@Column
	private Double price;
	
	@Column(name="contact_person_name",length=50)
	private String contactPersonName;
	
	@Column(name="contact_person_gender_cd",length=5)
	private String contactPersonGenderCd;
	
	@Column(name="contact_number",length=15)
	private String contactNumber;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	@Column(length=100)
	private String remarks;
	
	@Column(name="adults_count")
	private Integer adultsCount;
	
	@Column(name="children_count")
	private Integer childrenCount;
	
	@Column(name="tour_type_cd",length=5)
	private String tourTypeCd;
	
	
	
	

	public String getTourTypeCd() {
		return tourTypeCd;
	}

	public void setTourTypeCd(String tourTypeCd) {
		this.tourTypeCd = tourTypeCd;
	}

	public Integer getAdultsCount() {
		return adultsCount;
	}

	public void setAdultsCount(Integer adultsCount) {
		this.adultsCount = adultsCount;
	}

	public Integer getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(Integer childrenCount) {
		this.childrenCount = childrenCount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Set<TbBizOrderMessageBO> getMessages() {
		return messages;
	}

	public void setMessages(Set<TbBizOrderMessageBO> messages) {
		this.messages = messages;
	}

    


	public TbBizRouteDetailBO getRouteDetail() {
		return routeDetail;
	}

	public void setRouteDetail(TbBizRouteDetailBO routeDetail) {
		this.routeDetail = routeDetail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TbCsmUserBO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TbCsmUserBO createUser) {
		this.createUser = createUser;
	}

	public String getOrderStatusCd() {
		return orderStatusCd;
	}

	public void setOrderStatusCd(String orderStatusCd) {
		this.orderStatusCd = orderStatusCd;
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

	public Timestamp getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Timestamp travelDate) {
		this.travelDate = travelDate;
	}
	
	

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonGenderCd() {
		return contactPersonGenderCd;
	}

	public void setContactPersonGenderCd(String contactPersonGenderCd) {
		this.contactPersonGenderCd = contactPersonGenderCd;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizOrderBO))
			return false;
		TbBizOrderBO other = (TbBizOrderBO) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
}
