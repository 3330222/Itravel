package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_email")
public class TbCsmEmailBO implements Serializable{


	private static final long serialVersionUID = 413259351715750599L;
	@Id
	@Column(name="email_id",length=32)
	private String emailId;
	
	@Column(name="email_type_cd",length=5)
	private String emailTypeCd;
	
	@Column(length=1024)
	private String content;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(length=100)
	private String subject;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO toUser = new TbCsmUserBO();

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailTypeCd() {
		return emailTypeCd;
	}

	public void setEmailTypeCd(String emailTypeCd) {
		this.emailTypeCd = emailTypeCd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public TbCsmUserBO getToUser() {
		return toUser;
	}

	public void setToUser(TbCsmUserBO toUser) {
		this.toUser = toUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbCsmEmailBO))
			return false;
		TbCsmEmailBO other = (TbCsmEmailBO) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		return true;
	}
	
	
	

}
