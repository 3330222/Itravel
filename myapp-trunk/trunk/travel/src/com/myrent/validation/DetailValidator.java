package com.myrent.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myrent.vo.DetailVO;


public class DetailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DetailVO.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "price", null, "价格不能为空");
		ValidationUtils.rejectIfEmpty(errors, "limit", null, "发团次数不能为空");
	     DetailVO vo=(DetailVO)obj;
	     if(isNumeric(vo.getPrice().toString()))
	     {
	    	 errors.rejectValue("price", "请输入正确格式");
	     }
	     if(isNumeric(String.valueOf(vo.getLimit())))
	     {
	    	 errors.rejectValue("limit", "请输入正确格式");
	     }
	}
	
	
	public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
}
