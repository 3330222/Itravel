package com.myrent.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_biz_order_message")
public class TbBizOrderMessageBO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6529804495427324586L;

	@Id
	@Column(name="message_id",length=32)
	private String messageId;
	
	@Column(length=500)
	private String content;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO createUser;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private TbBizOrderBO order;
	
	@OneToMany(mappedBy="originMessage",cascade=CascadeType.REFRESH)
	private Set<TbBizOrderMessageBO> replies;
	
	@ManyToOne
	@JoinColumn(name="origin_message_id",referencedColumnName="message_id")
	private TbBizOrderMessageBO originMessage;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public TbCsmUserBO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TbCsmUserBO createUser) {
		this.createUser = createUser;
	}

	public Set<TbBizOrderMessageBO> getReplies() {
		return replies;
	}

	public void setReplies(Set<TbBizOrderMessageBO> replies) {
		this.replies = replies;
	}

	public TbBizOrderMessageBO getOriginMessage() {
		return originMessage;
	}

	public void setOriginMessage(TbBizOrderMessageBO originMessage) {
		this.originMessage = originMessage;
	}
	
	

	public TbBizOrderBO getOrder() {
		return order;
	}

	public void setOrder(TbBizOrderBO order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((messageId == null) ? 0 : messageId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizOrderMessageBO))
			return false;
		TbBizOrderMessageBO other = (TbBizOrderMessageBO) obj;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		return true;
	} 
	
	
	
}
