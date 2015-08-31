package com.myrent.service.bs.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.entity.TbSysResourceBO;
import com.myrent.data.model.QueryResult;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.RouteService;
import com.myrent.service.bs.SysResourceService;
import com.myrent.vo.RouteVO;
import com.myrent.vo.SysResourceVO;
import com.myrent.vo.VOManager;


@Service("sysResourceServiceBean")
public class SysResourceServiceBean extends DAOImpl<TbSysResourceBO> implements
SysResourceService{

	
	public Map<String, SysResourceVO> findSysResource(SysResourceVO vo){
		
		
		LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
		String whereJPQL = "";
		// Object[] params = {"%ad%","admin@gmail.com"};
		// orderBy.put("userName", "desc");

		QueryResult<TbSysResourceBO> result = queryJpqlPagedEntity(0, 10,
				whereJPQL, null, orderBy);
		VOManager voManager = new VOManager();

		Map<String, SysResourceVO> map = new HashMap<String, SysResourceVO>(); 
		//Map<String, SysResourceVO> treeMap = new TreeMap<String, SysResourceVO>(map);
		for (TbSysResourceBO resource : result.getResultList()) {
			SysResourceVO vo1 = new SysResourceVO();
			String resourceId = resource.getResourceId();
			vo1 = voManager.getResource(resource);
			map.put(resourceId, vo1);
		}
		Map<String, SysResourceVO> treeMap = new TreeMap<String, SysResourceVO>(map);
		return treeMap;
	}

	@Override
	public SysResourceVO updateUrl(SysResourceVO vo) {
		// TODO Auto-generated method stub
		
		TbSysResourceBO bo = find(vo.getResourceId());
		bo.setUrl(vo.getUrl());
		update(bo);
		return null;
	}
	
	
}
