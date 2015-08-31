package com.myrent.vo.user;

import java.sql.Timestamp;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;




import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.model.vo.BaseVO;

public class HostelVO extends UserVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555881815960840461L;

	private String registerNum;
	private String licenseNum;

	@NotNull(message="{registernum_not_blank}")
	@Size(min=5,max=20,message="{registernum_not_in_range}")
	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
}
