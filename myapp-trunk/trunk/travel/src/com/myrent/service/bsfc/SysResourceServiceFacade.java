package com.myrent.service.bsfc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.myrent.vo.RouteVO;
import com.myrent.vo.SysResourceVO;

public interface SysResourceServiceFacade{

	public Map<String, SysResourceVO> findSysResource(SysResourceVO vo);
	public SysResourceVO updateUrl(SysResourceVO vo);
}
