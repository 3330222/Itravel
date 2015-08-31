package com.myrent.vo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.myrent.data.model.vo.BaseVO;

@SuppressWarnings("serial")
public class RouteVO extends BaseVO{
	private String routeid;
	private String des;
	private String routetype;
	private Timestamp cTime;
	private Timestamp eTime;
	private String name;
	private String status;
	private List<DetailVO>details;
	private List<NodeVO>nodes;
	private String [] dayofweek;
	private MultipartFile file;
	private String themeImageUrl;
	private HostelVO hotel;
	private String [] cars;
	private String failReason;
	
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getRoutetype() {
		return routetype;
	}
	public void setRoutetype(String routetype) {
		this.routetype = routetype;
	}
	public Timestamp getcTime() {
		return cTime;
	}
	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	public Timestamp geteTime() {
		return eTime;
	}
	public void seteTime(Timestamp eTime) {
		this.eTime = eTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<DetailVO> getDetails() {
		return details;
	}
	public void setDetails(List<DetailVO> details) {
		this.details = details;
	}
	public List<NodeVO> getNodes() {
		return nodes;
	}
	public void setNodes(List<NodeVO> nodes) {
		this.nodes = nodes;
	}
	public String[] getDayofweek() {
		return dayofweek;
	}
	public void setDayofweek(String[] dayofweek) {
		this.dayofweek = dayofweek;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getThemeImageUrl() {
		return themeImageUrl;
	}
	public void setThemeImageUrl(String themeImageUrl) {
		this.themeImageUrl = themeImageUrl;
	}
	public HostelVO getHotel() {
		return hotel;
	}
	public void setHotel(HostelVO hotel) {
		this.hotel = hotel;
	}
	public String[] getCars() {
		return cars;
	}
	public void setCars(String[] cars) {
		this.cars = cars;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	
	
}
