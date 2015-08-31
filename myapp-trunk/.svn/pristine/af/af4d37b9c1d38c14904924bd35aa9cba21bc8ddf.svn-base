package com.myrent.data.entity;

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
@Table(name="tb_biz_route_comment")
public class TbBizRouteCommentBO {
	
	@Id
	@Column(name="comment_id",length=32)
	private String commentId;
	
	@Column(length=800)
	private String content;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="update_time")
	private Timestamp updateTime;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private TbCsmUserBO createUser;
	
	@OneToMany(mappedBy="originComment",cascade=CascadeType.REFRESH)
	private Set<TbBizRouteCommentBO> followingComments;
	
	@ManyToOne
	@JoinColumn(name="origin_comment_id",referencedColumnName="comment_id")
	private TbBizRouteCommentBO originComment;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
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
	
	
	public Set<TbBizRouteCommentBO> getFollowingComments() {
		return followingComments;
	}

	public void setFollowingComments(Set<TbBizRouteCommentBO> followingComments) {
		this.followingComments = followingComments;
	}

	public TbBizRouteCommentBO getOriginComment() {
		return originComment;
	}

	public void setOriginComment(TbBizRouteCommentBO originComment) {
		this.originComment = originComment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentId == null) ? 0 : commentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteCommentBO))
			return false;
		TbBizRouteCommentBO other = (TbBizRouteCommentBO) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		return true;
	}
	
	

}
