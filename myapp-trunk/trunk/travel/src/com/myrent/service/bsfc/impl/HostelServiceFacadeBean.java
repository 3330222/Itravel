package com.myrent.service.bsfc.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrent.service.bs.HostelService;
import com.myrent.service.bs.RouteService;
import com.myrent.service.bsfc.HostelServiceFacade;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;

@Service("hostelSeriveFacadeBean")
public class HostelServiceFacadeBean implements HostelServiceFacade {
	
	@Resource(name="hostelService")
	private HostelService hostelService;
	
	public void create(HostelVO vo){
		hostelService.createhostel(vo);
	}

	@Override
	public HostelVO findHostel(HostelVO vo) {
		// TODO Auto-generated method stub
		return hostelService.findHotelById(vo.getId());
	}

	@Override
	public void updateHostelStatus(HostelVO vo) {
		// TODO Auto-generated method stub
		hostelService.updateHostelStatus(vo);
	}

}
