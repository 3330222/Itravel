package com.myrent.service.bsfc;

import java.util.List;

import com.myrent.data.model.service.FacadeService;


public interface SysCodesServiceFacade extends FacadeService{

	public List<String> findOccupations();
	
	public String getOccupationValue(String name);
	
	public String getGenderValue(String name);
	
	public String getOccupationName(String value);
}
