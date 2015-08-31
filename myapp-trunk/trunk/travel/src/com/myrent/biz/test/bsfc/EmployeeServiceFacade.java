package com.myrent.biz.test.bsfc;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.myrent.biz.test.vo.EmployeeVO;
import com.myrent.data.model.service.FacadeService;

public interface EmployeeServiceFacade extends FacadeService {

	public void createName(EmployeeVO vo);
	public String findName(EmployeeVO vo);
	Map[] findAllEmployeeArrayMap(EmployeeVO vo);
}
