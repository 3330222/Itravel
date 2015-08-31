package com.myrent.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_biz_route_node")
public class TbBizRouteNodeBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -148621443673703059L;

	@Column(name="node_id",length=32)
	@Id
	private String nodeId;
	
	@Column(name="description", length=1024)
	private String description;
	
	@Column(name="image_url", length=512)
	private String imageUrl;
	
	@Column(name="node_name",length=100)
	private String nodeName;
	
	@Column(name="keywords", length=50)
	private String keywords;
	
	@Column(name="accommodation", length=50)
	private String accommodation;
	
	@Column(name="sequential_num")
	private Integer sequentialNum;
	
	
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	@ManyToOne
	@JoinColumn(name="route_id")
	private TbBizRouteBO route;
	
	
	
	
	public Integer getSequentialNum() {
		return sequentialNum;
	}

	public void setSequentialNum(Integer sequentialNum) {
		this.sequentialNum = sequentialNum;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    

	public TbBizRouteBO getRoute() {
		return route;
	}

	public void setRoute(TbBizRouteBO route) {
		this.route = route;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TbBizRouteNodeBO))
			return false;
		TbBizRouteNodeBO other = (TbBizRouteNodeBO) obj;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		return true;
	}

}
