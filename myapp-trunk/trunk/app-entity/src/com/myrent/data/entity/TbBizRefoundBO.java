package com.myrent.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_biz_refound")
public class TbBizRefoundBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 916441480875000479L;

	@Id
	@Column(name="refound_id",length=32)
	private String refoundId;
	
    @Column(name="refound_amt")
	private double refoundAmt;
    
    @Column(name="refound_reason",length=200)
    private String refoundReason;
    
    @Column(name="refound_status_cd",length=5)
    private String refoundStatusCd;
	
	@ManyToOne
	@JoinColumn(name="payment_id")
	private TbBizPaymentBO payment;

	
	public String getRefoundReason() {
		return refoundReason;
	}

	public void setRefoundReason(String refoundReason) {
		this.refoundReason = refoundReason;
	}

	public String getRefoundId() {
		return refoundId;
	}

	public void setRefoundId(String refoundId) {
		this.refoundId = refoundId;
	}

	public double getRefoundAmt() {
		return refoundAmt;
	}

	public void setRefoundAmt(double refoundAmt) {
		this.refoundAmt = refoundAmt;
	}

	public String getRefoundStatusCd() {
		return refoundStatusCd;
	}

	public void setRefoundStatusCd(String refoundStatusCd) {
		this.refoundStatusCd = refoundStatusCd;
	}

	public TbBizPaymentBO getPayment() {
		return payment;
	}

	public void setPayment(TbBizPaymentBO payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((refoundId == null) ? 0 : refoundId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRefoundBO))
			return false;
		TbBizRefoundBO other = (TbBizRefoundBO) obj;
		if (refoundId == null) {
			if (other.refoundId != null)
				return false;
		} else if (!refoundId.equals(other.refoundId))
			return false;
		return true;
	}
}
