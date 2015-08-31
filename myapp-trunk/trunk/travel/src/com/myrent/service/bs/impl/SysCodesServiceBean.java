package com.myrent.service.bs.impl;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbSysCodesBO;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.SysCodesService;

@Service("sysCodesServiceBean")
public class SysCodesServiceBean extends DAOImpl<TbSysCodesBO> implements
		SysCodesService {

	@Override
	public List<TbSysCodesBO> findOccupations() {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("SELECT T FROM TbSysCodesBO T WHERE T.codeTypeCd = 'OccupationCd'");
		List<TbSysCodesBO> result = query.getResultList();
		return result;
	}

	@Override
	public TbSysCodesBO findOccupationByName(String name) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("SELECT T FROM TbSysCodesBO T WHERE T.codeTypeCd = 'OccupationCd' and T.codeName = ?1");
		query.setParameter(1, name);
		List<TbSysCodesBO> result = query.getResultList();
		if(result.size() != 0){
			return result.get(0);
		}
		return null;
	}
	
	@Override
	public TbSysCodesBO findOccupationByVale(String value) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("SELECT T FROM TbSysCodesBO T WHERE T.codeTypeCd = 'OccupationCd' and T.codeValue = ?1");
		query.setParameter(1, value);
		List<TbSysCodesBO> result = query.getResultList();
		if(result.size() != 0){
			return result.get(0);
		}
		return null;
	}

	@Override
	public TbSysCodesBO findGender(String name) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("SELECT T FROM TbSysCodesBO T WHERE T.codeTypeCd = 'GenderCd' and T.codeName = ?1");
		query.setParameter(1, name);
		List<TbSysCodesBO> result = query.getResultList();
		if(result.size() != 0){
			return result.get(0);
		}
		return null;
	}
	
	
	
}