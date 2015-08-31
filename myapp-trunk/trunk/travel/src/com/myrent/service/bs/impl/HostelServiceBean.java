package com.myrent.service.bs.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.entity.TbCsmHostelBO;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.HostelService;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.VOManager;

@Service("hostelService")
public class HostelServiceBean extends DAOImpl<TbCsmHostelBO> implements
		HostelService {

	public HostelVO findHotel(HostelVO vo) {
		// TODO Auto-generated method stub

		Query query = em
				.createQuery("SELECT o FROM TbCsmHostelBO o WHERE o.userId = ?1");
		query.setParameter(1, vo.getId());
		List<TbCsmHostelBO> list = query.getResultList();
		return null;
	}

	/*
	 * public HashMap<String,HostelVO> findAllHotel(HostelVO vo){
	 * 
	 * Query query = em .createQuery("SELECT o FROM TbCsmHostelBO o");
	 * 
	 * List<TbCsmHostelBO> list = query.getResultList();
	 * HashMap<String,HostelVO> result = new HashMap<String,HostelVO>();
	 * 
	 * for (TbCsmHostelBO hostel : list) { HostelVO vo1 = new HostelVO(); String
	 * hostelId = hostel.getUserId(); vo1.setId(hostel.getUserId());
	 * vo1.setName(hostel.getManager()); vo1.setPhone(hostel.getPhone());
	 * result.put(hostelId,vo1); } return result; }
	 */

	public HostelVO findHotelById(String id) {
		// TODO Auto-generated method stub

		HostelVO hostel = new HostelVO();
		Query query = em
				.createQuery("SELECT o FROM TbCsmHostelBO o WHERE o.userId = ?1");
		query.setParameter(1, id);
		List<TbCsmHostelBO> list = query.getResultList();
		if (list.size() == 0) {
			return null;
		} else {
			TbCsmHostelBO bo = list.get(0);
			VOManager vm = new VOManager();
			hostel = vm.getHostel(bo);
		}
		return hostel;
	}

	public HostelVO createhostel(HostelVO vo) {

		TbCsmHostelBO bo = find(vo.getId());
		bo.setAddress(vo.getAddress());
		bo.setAlipayAccount(vo.getAlipayaccount());
		bo.setBusinessLicenseNum(vo.getLicensenum());
		bo.setRegisterNum(vo.getRegisternum());
		bo.setHostelName(vo.getHostelname());
		bo.setWechatAccount(vo.getWechataccount());
		bo.setManager(vo.getManagername());
		bo.setManagerIdentityNum(vo.getManageridentitynum());
		bo.setManagerPhone(vo.getManagerphone());
		bo.setHostelTelephoneNum(vo.getHosteltelephonenum());
		MultipartFile idfile = vo.getIdfile();
		MultipartFile licensefile = vo.getLicensefile();
		bo.setManagerIdentityImg(vo.getIdImageUrl());
		bo.setBusinessLicenceImg(vo.getLicenseImageUrl());
		MultipartFile idbackfile = vo.getIdfileback();
		bo.setManagerIdentityImgBack(vo.getIdbackImageUrl());
		bo.setHostelStatusCd("2");

		return vo;
	}

	public void updateHostelStatus(HostelVO vo) {
		TbCsmHostelBO bo = find(vo.getId());
		bo.setHostelStatusCd(vo.getHostelstatus());
		update(bo);
	}
}
