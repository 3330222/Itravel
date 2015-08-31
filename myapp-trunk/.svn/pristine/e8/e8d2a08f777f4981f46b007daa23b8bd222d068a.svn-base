package com.myrent.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_biz_payment")
public class TbBizPaymentBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6644181246492822372L;

	@Id
	@Column(name="payment_id")
	private String paymentId;
	
	@Column(name="create_time")
	private String createTime;
	
	@Column(name="udpate_time")
	private String updateTime;

	@Column(name="payment_status_cd",length=5)
	private String paymentStatusCd;
	
	@Column(name="paid_amt")
	private Double paidAmt;
	
	
	
	@ManyToOne
	@JoinColumn(name="payment_type_id")
	private TbSysPaymentTypeBO paymentType;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO createUser;
	
	@OneToMany
	@JoinColumn(name="payment_id")
	private Set<TbBizRefoundBO> refounds;
	

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public TbSysPaymentTypeBO getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(TbSysPaymentTypeBO paymentType) {
		this.paymentType = paymentType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	

	public Double getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(Double paidAmt) {
		this.paidAmt = paidAmt;
	}

	public String getPaymentStatusCd() {
		return paymentStatusCd;
	}

	public void setPaymentStatusCd(String paymentStatusCd) {
		this.paymentStatusCd = paymentStatusCd;
	}

	public TbCsmUserBO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TbCsmUserBO createUser) {
		this.createUser = createUser;
	}
	
	

	public Set<TbBizRefoundBO> getRefounds() {
		return refounds;
	}

	public void setRefounds(Set<TbBizRefoundBO> refounds) {
		this.refounds = refounds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paymentId == null) ? 0 : paymentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizPaymentBO))
			return false;
		TbBizPaymentBO other = (TbBizPaymentBO) obj;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		return true;
	}
}
