package com.myrent.validation;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myrent.vo.NodeVO;

public class NodeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return NodeVO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "name", null,
				"每日主题不能为空");
		ValidationUtils.rejectIfEmpty(errors,"description",null,"请输入行程安排");
	}

}
