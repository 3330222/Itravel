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
@Table(name="tb_sys_payment_type")
public class TbSysPaymentTypeBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3978781477241601718L;

	@Id
	@Column(name="payment_type_id", length=32)
	private String paymentTypeId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_code")
	private String bankCode;
	
	@Column(name="payment_type_status_cd")
	private String paymentTypeStatusCd;
	
	@OneToMany(mappedBy="paymentType",cascade=CascadeType.REFRESH)
	private Set<TbBizPaymentBO> payments;

	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getPaymentTypeStatusCd() {
		return paymentTypeStatusCd;
	}

	public void setPaymentTypeStatusCd(String paymentTypeStatusCd) {
		this.paymentTypeStatusCd = paymentTypeStatusCd;
	}

	public Set<TbBizPaymentBO> getPayments() {
		return payments;
	}

	public void setPayments(Set<TbBizPaymentBO> payments) {
		this.payments = payments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paymentTypeId == null) ? 0 : paymentTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysPaymentTypeBO))
			return false;
		TbSysPaymentTypeBO other = (TbSysPaymentTypeBO) obj;
		if (paymentTypeId == null) {
			if (other.paymentTypeId != null)
				return false;
		} else if (!paymentTypeId.equals(other.paymentTypeId))
			return false;
		return true;
	}
	
	
	
}
