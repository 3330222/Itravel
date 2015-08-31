package com.myrent.vo.user;

import java.sql.Timestamp;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;




import org.springframework.web.multipart.MultipartFile;

import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.model.vo.BaseVO;

public class UserVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555881815960840461L;

	private String userId;
	private String userTypeCd;
	private String account;
	private String password;
	private String confirmedPassword;
	private String email;
	private String mobileNum;
	private String licenseNum;
	private String address;
	private Timestamp cTime;
	private Timestamp uTime;
	private String gender;
	private String headPhoto;
	private String nickname;
	private String realPhoto;
	private String realName;
	private String userStatus;
	private MultipartFile headPhotofile;
	private String hosteluserStatus;
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getcTime() {
		return cTime;
	}

	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}

	public Timestamp getuTime() {
		return uTime;
	}

	public void setuTime(Timestamp uTime) {
		this.uTime = uTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealPhoto() {
		return realPhoto;
	}

	public void setRealPhoto(String realPhoto) {
		this.realPhoto = realPhoto;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	private TbCsmUserBO tbCsmUserBO;

	@AssertTrue(message = "密码不一致")
	public  boolean isValid() {
		return this.password.equals(this.confirmedPassword);
	}

	public TbCsmUserBO getTbCsmUserBO() {
		return tbCsmUserBO;
	}

	public void setTbCsmUserBO(TbCsmUserBO tbCsmUserBO) {
		this.tbCsmUserBO = tbCsmUserBO;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserTypeCd() {
		return userTypeCd;
	}

	public void setUserTypeCd(String userTypeCd) {
		this.userTypeCd = userTypeCd;
	}

	@NotNull(message="{account_not_blank}")
	@Size(min=4,max=10,message="{account_not_in_range}")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@NotNull(message="{password_not_blank}")
	@Size(min=6,max=16,message="{password_not_in_range}")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull(message="{password_not_blank}")
	@Size(min=6,max=16,message="{password_not_in_range}")
	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	@NotNull(message="{email_not_blank}")
	@Email(message="{email_not_valid}")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getHeadPhotofile() {
		return headPhotofile;
	}

	public void setHeadPhotofile(MultipartFile headPhotofile) {
		this.headPhotofile = headPhotofile;
	}

	public String getHosteluserStatus() {
		return hosteluserStatus;
	}

	public void setHosteluserStatus(String hosteluserStatus) {
		this.hosteluserStatus = hosteluserStatus;
	}
	
}
