package com.myrent.biz.test.bs;

import org.springframework.stereotype.Service;

import com.myrent.biz.test.bs.impl.EmployeeService;
import com.myrent.data.entity.TbCsmEmployeeBO;
import com.myrent.data.model.dao.impl.DAOImpl;



@Service(value = "employeeService")
public class EmployeeServiceBean extends DAOImpl<TbCsmEmployeeBO> implements EmployeeService {
	
     
	
}