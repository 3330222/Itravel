package com.myrent.biz.test.bsfc.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrent.biz.test.bs.impl.EmployeeService;
import com.myrent.biz.test.bsfc.EmployeeServiceFacade;
import com.myrent.biz.test.vo.EmployeeVO;
import com.myrent.data.entity.TbCsmEmployeeBO;
import com.myrent.data.model.QueryResult;
import com.myrent.data.model.service.FacadeService;

@Service("EmployeeServiceBean")
public class EmployeeServiceFacadeBean implements EmployeeServiceFacade{

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="employeeService")
	EmployeeService employeeService;

	@Transactional
	public String findName(EmployeeVO vo){
		
		TbCsmEmployeeBO bo = employeeService.find("1");
		
		return bo.getEmployeeName();
	}

	@Override
	//@Transactional
	public void createName(EmployeeVO vo) {
		logger.info("entering create employee...");
		TbCsmEmployeeBO bo = new TbCsmEmployeeBO();
		bo.setEmployeeId(System.currentTimeMillis()+"");
		bo.setEmployeeName("中国");
		bo.setAddress("北京");
		employeeService.save(bo);
	}
	
	@Override
	@Transactional
	public Map[] findAllEmployeeArrayMap(EmployeeVO vo) {
		
	    QueryResult<TbCsmEmployeeBO> result = employeeService.queryJpqlPagedEntity();
	    List<Map> list = new ArrayList<>();
	    for(TbCsmEmployeeBO bo : result.getResultList()){
	    	Map map = new HashMap();
	    	map.put("employeeId", bo.getEmployeeId());
	    	map.put("employeeName", bo.getEmployeeName());
	    	map.put("address", bo.getAddress());
	    	list.add(map);
	    }
	    Map[] a = new Map[list.size()];
	    return list.toArray(a);
	}
	
	
}
