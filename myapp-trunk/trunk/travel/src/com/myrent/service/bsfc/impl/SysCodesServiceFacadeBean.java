package com.myrent.service.bsfc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbSysCodesBO;
import com.myrent.service.bs.SysCodesService;
import com.myrent.service.bsfc.SysCodesServiceFacade;


@Service("sysCodesServiceFacadeBean")
public class SysCodesServiceFacadeBean implements SysCodesServiceFacade{

	@Resource(name="sysCodesServiceBean")
	private SysCodesService sysCodesService;

	@Override
	public List<String> findOccupations() {
		List<String> list = new ArrayList<String>();
		List<TbSysCodesBO> occu = sysCodesService.findOccupations();
		for(TbSysCodesBO bo : occu){
			list.add(bo.getCodeName());
		}
		return list;
	}

	@Override
	public String getOccupationValue(String name) {
		// TODO Auto-generated method stub
		TbSysCodesBO bo = sysCodesService.findOccupationByName(name);
		String val = null;
		if(bo != null)
		{
			val = bo.getCodeValue();
		}
		return val;
	}

	@Override
	public String getGenderValue(String name) {
		// TODO Auto-generated method stub
		TbSysCodesBO bo = sysCodesService.findGender(name);
		String val = null;
		if(bo != null)
		{
			val = bo.getCodeValue();
		}
		return val;
	}

	@Override
	public String getOccupationName(String value) {
		// TODO Auto-generated method stub
		TbSysCodesBO bo = sysCodesService.findOccupationByVale(value);
		String val = null;
		if(bo != null)
		{
			val = bo.getCodeName();
		}
		return val;
	}
	
	
}
