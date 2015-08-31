package com.myrent.data.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_sys_code_type")
public class TbSysCodeTypeBO implements Serializable {

	
	private static final long serialVersionUID = 547083915679824994L;

	@Id
	@Column(name="code_type_id",length=32)
	private String codeTypeId;
	
	@Column(name="code_type_cd",length=50)
	private String codeTypeCd;
	
	@Column(name="code_type_desc",length=100)
	private String codeTypeDesc;
	
	@OneToMany(mappedBy="tbSysCodeTypeBO", cascade=CascadeType.REFRESH)
	private Set<TbSysCodesBO> codes = new HashSet<TbSysCodesBO>();

	public String getCodeTypeId() {
		return codeTypeId;
	}

	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public String getCodeTypeCd() {
		return codeTypeCd;
	}

	public void setCodeTypeCd(String codeTypeCd) {
		this.codeTypeCd = codeTypeCd;
	}

	public String getCodeTypeDesc() {
		return codeTypeDesc;
	}

	public void setCodeTypeDesc(String codeTypeDesc) {
		this.codeTypeDesc = codeTypeDesc;
	}

	public Set<TbSysCodesBO> getCodes() {
		return codes;
	}

	public void setCodes(Set<TbSysCodesBO> codes) {
		this.codes = codes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeTypeId == null) ? 0 : codeTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbSysCodeTypeBO))
			return false;
		TbSysCodeTypeBO other = (TbSysCodeTypeBO) obj;
		if (codeTypeId == null) {
			if (other.codeTypeId != null)
				return false;
		} else if (!codeTypeId.equals(other.codeTypeId))
			return false;
		return true;
	}
	
}
