package com.myrent.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myrent.vo.NodeVO;
import com.myrent.vo.RouteVO;

public class RouteValidator implements Validator {

	private Validator NodeValidator;

	  public RouteValidator(Validator NodeValidator) {
	        if (NodeValidator == null) {
	            throw new IllegalArgumentException("The supplied [Validator] is " +
	                "required and must not be null.");
	        }
	        if (!NodeValidator.supports(NodeVO.class)) {
	            throw new IllegalArgumentException("The supplied [Validator] must " +
	                "support the validation of [Address] instances.");
	        }
	        this.NodeValidator = NodeValidator;
	    }

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return RouteVO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		RouteVO vo = (RouteVO) obj;
		ValidationUtils.rejectIfEmpty(errors, "name", null, "路线名称不能为空");
		ValidationUtils.rejectIfEmpty(errors, "dayofweek", null, "请选择一个发团时间");
		ValidationUtils.rejectIfEmpty(errors, "cars", null,"请选择车型");
		int idx = 0;
		if (vo.getNodes() != null) {
			for (NodeVO item : vo.getNodes()) {
				errors.pushNestedPath("nodes[" + idx + "]");
				ValidationUtils.invokeValidator(this.NodeValidator, item,
						errors);
				errors.popNestedPath();
				idx++;
			}
		}
	}

}
