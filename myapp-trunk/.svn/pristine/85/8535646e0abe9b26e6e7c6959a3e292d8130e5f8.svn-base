package com.myrent.web.controller.user;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myrent.common.constant.ViewConstant;
import com.myrent.controller.BaseController;
import com.myrent.service.bsfc.UserServiceFacade;
import com.myrent.vo.user.HostelVO;
import com.myrent.vo.user.UserVO;

@Controller
@RequestMapping(ViewConstant.USERMODULE)
public class UserController extends BaseController{
	
	@Resource(name="userServiceFacadeBean")
	UserServiceFacade userServiceFacade;
	
	@RequestMapping(value = "/list",  method = RequestMethod.GET)
	public String handleRest(ModelMap model,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		userServiceFacade.findAllUsers(null);
		return null;
	}
	
	@RequestMapping(value = "/toregister/{userType}",  method = RequestMethod.GET)
	public String toRegisterUser(ModelMap model,@PathVariable("userType") String userType,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserVO userVO = null;
		if("traveller".equals(userType))
		    model.addAttribute("vo",new UserVO());
		if("hostel".equals(userType))
		    model.addAttribute("vo",new HostelVO());
		return "create_"+userType;
	}
	
	@RequestMapping(value = "/register/traveller",  method = RequestMethod.POST)
	public String createUser(ModelMap model,@Valid @ModelAttribute("vo") UserVO vo,
			BindingResult result) {
		
		if(result.hasErrors()){
			model.addAttribute("vo",vo);
			return "create_traveller";
		}
	    vo.setUserTypeCd("1");
		userServiceFacade.createUser(vo);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/register/hostel",  method = RequestMethod.POST)
	public String createHostel(ModelMap model,@Valid @ModelAttribute("vo") HostelVO vo,
			BindingResult result) {
		
		if(result.hasErrors()){
			model.addAttribute("vo",vo);
			return "create_hostel";
		}
		
		vo.setUserTypeCd("2");
		userServiceFacade.createUser(vo);
		return "redirect:/login";
	}
	
	
	@RequestMapping(value = "/rest/query/{account}",  method = RequestMethod.GET)
	@ResponseBody
	public String queryUser(@PathVariable("account") String account,
			HttpServletResponse response) {
		UserVO vo = new UserVO();
		vo.setAccount(account);
		userServiceFacade.queryUserByAccount(vo);
		if(null == vo.getTbCsmUserBO())
		    response.setStatus(HttpServletResponse.SC_OK);
		else
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "end";
		
	}
}
