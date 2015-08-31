package com.myrent.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_sys_codes")
public class TbSysCodesBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8596744790120131305L;

	@Id
	@Column(name="code_id",length=32)
	private String codeId;
	
	@Column(name="code_type_cd",length=50)
	private String codeTypeCd;
	
	@Column(name="code_value",length=50)
	private String codeValue;
	
	@Column(name="code_name",length=50)
	private String codeName;
	
	@Column(name="status",length=1)
	private String status;
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="code_type_id")
	private TbSysCodeTypeBO tbSysCodeTypeBO;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeTypeCd() {
		return codeTypeCd;
	}

	public void setCodeTypeCd(String codeTypeCd) {
		this.codeTypeCd = codeTypeCd;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TbSysCodeTypeBO getTbSysCodeTypeBO() {
		return tbSysCodeTypeBO;
	}

	public void setTbSysCodeTypeBO(TbSysCodeTypeBO tbSysCodeTypeBO) {
		this.tbSysCodeTypeBO = tbSysCodeTypeBO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeId == null) ? 0 : codeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysCodesBO))
			return false;
		TbSysCodesBO other = (TbSysCodesBO) obj;
		if (codeId == null) {
			if (other.codeId != null)
				return false;
		} else if (!codeId.equals(other.codeId))
			return false;
		return true;
	}
	
	
}
