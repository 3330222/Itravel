package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_csm_user")
@Inheritance(strategy = InheritanceType.JOINED)
public  class TbCsmUserBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5378372906224742502L;

	@Id
	@Column(name="user_id",length=32)
	private String userId;
	
	@Column(length=32)
	private String password;
	
	@Column(length=30,unique=true)
	private String account;
	
	
	@Column(name="user_name",length=50)
	private String userName;
	
	@Column(name="gender_cd",length=5)
	private String genderCd;
	
	
	@Column(length=100)
	private String address;
	
	@Column(length=20)
	private String phone;
	
	@Column(length=80)
	private String email;
	
	@Column(name="head_photo",length=200)
	private String headPhoto;
	
	@Column(name="real_photo",length=200)
	private String realPhoto;
	
	
	@Column(length=5,name="user_status_cd")
	private String userStatusCd;
	
	@Column(length=5, name="user_type_cd")
	private String userTypeCd;

	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;
	
	@Column(name="nick_name", length=50)
	private String nickName;
	
	@OneToMany(mappedBy="createUser",cascade=CascadeType.REFRESH)
	private Set<TbBizOrderBO> orders = new HashSet<TbBizOrderBO>();
	
	@OneToMany(mappedBy="createUser",cascade=CascadeType.REFRESH)
	private Set<TbBizOrderMessageBO> messages  = new HashSet<TbBizOrderMessageBO>();
	
	@OneToMany(mappedBy="createUser",cascade=CascadeType.REFRESH)
	private Set<TbBizPaymentBO> payments  = new HashSet<TbBizPaymentBO>();
	
	@OneToMany(mappedBy="createUser",cascade=CascadeType.REFRESH)
	private Set<TbBizRouteCommentBO> comments = new HashSet<TbBizRouteCommentBO>();
	
	@OneToMany(mappedBy="createUser",cascade=CascadeType.REFRESH)
	private Set<TbBizRouteShareBO> shares = new HashSet<TbBizRouteShareBO>();
	
	@OneToMany(mappedBy="createUser", cascade=CascadeType.REFRESH)
	private Set<TbCsmPasswordResetBO> passwordResets = new HashSet<TbCsmPasswordResetBO>();
	
	@OneToMany(mappedBy="createUser", cascade=CascadeType.REFRESH)
	private Set<TbSysAnouncementBO> anouncements = new HashSet<TbSysAnouncementBO>();
	
	@OneToMany(mappedBy="toUser", cascade=CascadeType.REFRESH)
	private Set<TbCsmEmailBO> emails = new HashSet<TbCsmEmailBO>();
	
	
	
	public Set<TbCsmEmailBO> getEmails() {
		return emails;
	}

	public void setEmails(Set<TbCsmEmailBO> emails) {
		this.emails = emails;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGenderCd() {
		return genderCd;
	}

	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getRealPhoto() {
		return realPhoto;
	}

	public void setRealPhoto(String realPhoto) {
		this.realPhoto = realPhoto;
	}

	public String getUserTypeCd() {
		return userTypeCd;
	}

	public void setUserTypeCd(String userTypeCd) {
		this.userTypeCd = userTypeCd;
	}

	@ManyToMany(cascade=CascadeType.REFRESH)
	@JoinTable(
				name="tb_csm_user_role",
				joinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="role_id")
	 )
	 private Set<TbSysRoleBO> roles = new HashSet<TbSysRoleBO>();
	
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Set<TbSysRoleBO> getRoles() {
		return roles;
	}

	public void setRoles(Set<TbSysRoleBO> roles) {
		this.roles = roles;
	}

	public Set<TbBizOrderMessageBO> getMessages() {
		return messages;
	}

	public void setMessages(Set<TbBizOrderMessageBO> messages) {
		this.messages = messages;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserStatusCd() {
		return userStatusCd;
	}

	public void setUserStatusCd(String userStatusCd) {
		this.userStatusCd = userStatusCd;
	}
	
	

	public Set<TbBizOrderBO> getOrders() {
		return orders;
	}

	public void setOrders(Set<TbBizOrderBO> orders) {
		this.orders = orders;
	}
	
	

	public Set<TbBizPaymentBO> getPayments() {
		return payments;
	}

	public void setPayments(Set<TbBizPaymentBO> payments) {
		this.payments = payments;
	}
	
	

	public Set<TbBizRouteCommentBO> getComments() {
		return comments;
	}

	public void setComments(Set<TbBizRouteCommentBO> comments) {
		this.comments = comments;
	}

	public Set<TbBizRouteShareBO> getShares() {
		return shares;
	}

	public void setShares(Set<TbBizRouteShareBO> shares) {
		this.shares = shares;
	}
	
	

	public Set<TbCsmPasswordResetBO> getPasswordResets() {
		return passwordResets;
	}

	public void setPasswordResets(Set<TbCsmPasswordResetBO> passwordResets) {
		this.passwordResets = passwordResets;
	}
	
	

	public Set<TbSysAnouncementBO> getAnouncements() {
		return anouncements;
	}

	public void setAnouncements(Set<TbSysAnouncementBO> anouncements) {
		this.anouncements = anouncements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/**
	 * As the subclass may override the equals method
	 * so, here use getClass() against instanceof
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbCsmUserBO other = (TbCsmUserBO) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
