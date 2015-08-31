package com.myrent.service.bsfc.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrent.service.bs.PlanService;
import com.myrent.service.bsfc.PlanServiceFacade;
import com.myrent.vo.PlanVO;

@Service("planServiceFacadeBean")
public class PlanServiceFacadeBean implements PlanServiceFacade{
	
	@Resource(name="planServiceBean")
	private PlanService planservice;
	
	@Override
	public void createplan(PlanVO vo) {
		// TODO Auto-generated method stub
		planservice.createplan(vo);
	}

}
