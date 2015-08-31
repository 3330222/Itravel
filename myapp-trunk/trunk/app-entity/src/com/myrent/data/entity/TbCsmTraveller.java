package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_traveller")
@PrimaryKeyJoinColumn(name="user_id")
public class TbCsmTraveller extends TbCsmUserBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7972646135379382690L;
	
	@Column(name="birthday")
	private Timestamp birthday;
	
	@Column(length=5)
	private String occupationCd;
	
	@Column(name="tour_declaration")
	private String tourDeclaration;
	
	@Column(name="future_detination",length=200)
	private String futureDestination;
	
	@Column(name="history_destination",length=200)
	private String historyDestination;

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getOccupationCd() {
		return occupationCd;
	}

	public void setOccupationCd(String occupationCd) {
		this.occupationCd = occupationCd;
	}

	public String getTourDeclaration() {
		return tourDeclaration;
	}

	public void setTourDeclaration(String tourDeclaration) {
		this.tourDeclaration = tourDeclaration;
	}

	public String getFutureDestination() {
		return futureDestination;
	}

	public void setFutureDestination(String futureDestination) {
		this.futureDestination = futureDestination;
	}

	public String getHistoryDestination() {
		return historyDestination;
	}

	public void setHistoryDestination(String historyDestination) {
		this.historyDestination = historyDestination;
	}
	
	

}
