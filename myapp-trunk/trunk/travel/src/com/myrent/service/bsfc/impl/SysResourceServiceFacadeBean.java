package com.myrent.service.bsfc.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrent.service.bs.SysResourceService;
import com.myrent.service.bsfc.SysResourceServiceFacade;
import com.myrent.vo.RouteVO;
import com.myrent.vo.SysResourceVO;


@Service("sysResourceServiceFacadeBean")
public class SysResourceServiceFacadeBean implements SysResourceServiceFacade{

	@Resource(name="sysResourceServiceBean")
	private SysResourceService sysResourceService;
	
	public Map<String, SysResourceVO> findSysResource(SysResourceVO vo){
		return sysResourceService.findSysResource(vo);
	}

	@Override
	public SysResourceVO updateUrl(SysResourceVO vo) {
		// TODO Auto-generated method stub
		return sysResourceService.updateUrl(vo);
	}
}
