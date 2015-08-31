package com.myrent.vo;

import com.myrent.data.model.vo.BaseVO;

@SuppressWarnings("serial")
public class RefundVO extends BaseVO {
	private String refundId;
	private Double refundAmount;
	private String refundReason;
	private String refundStatus;
	private String paymentId;
	private String cTime;
	private String orderId;
	private PaymentVO payment;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public PaymentVO getPayment() {
		return payment;
	}
	public void setPayment(PaymentVO payment) {
		this.payment = payment;
	}
	public String getRefundId() {
		return refundId;
	}
	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getcTime() {
		return cTime;
	}
	public void setcTime(String cTime) {
		this.cTime = cTime;
	}
	
}
