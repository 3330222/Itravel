package com.myrent.biz.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myrent.biz.test.bsfc.EmployeeServiceFacade;
import com.myrent.biz.test.vo.EmployeeVO;
import com.myrent.controller.BaseController;
import com.myrent.data.entity.TbCsmEmployeeBO;
import com.myrent.system.exception.ServiceException;

@Controller
@RequestMapping("employee")
//@SessionAttributes("vo") //THIS VO WILL BE STORED IN SESSION
public class EmployeeController extends BaseController {

	@Resource(name = "EmployeeServiceBean")
	EmployeeServiceFacade employeeBean;

	@RequestMapping("/queryInfo")
	public ModelAndView queryValidManagers(HttpServletRequest request,
			HttpServletResponse response, Locale locale) throws IOException {
		System.out.println("local>>>>" + locale);
        System.out.println(">>>>>>>>>>>>>>>" + this.getMessage("label.employee.name", null, locale));
		response.setCharacterEncoding("utf-8");
		return new ModelAndView("xxx");
	}
	
	@RequestMapping("/exception")
	public ModelAndView sufferException(HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
       throw new ServiceException();
	}
	
	@RequestMapping("/jqueryUIClienta")
	public String showJqueryUIClient(HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
      return "jqueryuiclient";
	}
	
	@RequestMapping("/jqueryPopupWindow")
	public String showPopup(HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
      return "jqueryPopupWindow";
     
	}


	@RequestMapping("/queryInfoJson")
	public ModelAndView queryJson(HttpServletRequest request,
			HttpServletResponse response, Locale local) throws IOException {
		Map<String, String> map = new HashMap<>();
        System.out.println("query info sjson...");
		return new ModelAndView("employee_json");
	}

	@RequestMapping(value="/queryRestJson", produces = "text/html;charset=UTF-8")
	public String queryRestJson(HttpServletRequest request,
			HttpServletResponse response, Locale local) throws IOException {
		Map<String, String> map = new HashMap<>();
		String value = employeeBean.findName(null);
		System.out.println("value>>>" + value);
		map.put("employeeName", value);
		this.writeJson(map, response);
		return null;
	}

	@RequestMapping("/createEmployee")
	public String createEmployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, String> map = new HashMap<>();
		logger.info("enter create employee...");
		employeeBean.createName(null);
		map.put("creatioinstatus", "success");
		this.writeJson(map, response);
		return "redirect:queryInfo";
	}

	@RequestMapping("/queryAllEmployees")
	public String queryAllEmployees(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map[] array = employeeBean.findAllEmployeeArrayMap(null);
		this.writeJsonArray(array, response);
		return null;
	}

	@RequestMapping("/fileUpload")
	public String findUploadIndex(HttpServletRequest request,
			HttpServletResponse response ,ModelMap modelMap) throws IOException {
		modelMap.addAttribute("vo", new EmployeeVO());
		 return "fileuploadindex";
	}
	


	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String handleFormUpload(@ModelAttribute("vo") @Valid EmployeeVO vo,ModelMap model,
			HttpServletResponse response, HttpServletRequest request,
			BindingResult bindingResult, SessionStatus sessionStatus, Exception e) throws Exception {
		
		MultipartFile file = vo.getFile();
      
		if(vo.validateImageFile(file))
			vo.saveFile(file);
		return "redirect:jqueryUIClienta";
	}
	
	
	

	/**
	 * return json to the client
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/rest",  method = RequestMethod.GET)
	@ResponseBody //USED TO RETURN JSON TO THE CLIENTS
	public TbCsmEmployeeBO[] handleRest(ModelMap model,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		System.out.println("enter rest...");
		TbCsmEmployeeBO tbCsmEmployeeBO = new TbCsmEmployeeBO();
		tbCsmEmployeeBO.setEmployeeId("1334343434");
		tbCsmEmployeeBO.setAddress("human");
		tbCsmEmployeeBO.setEmployeeName("wangerxiao");
		
		TbCsmEmployeeBO tbCsmEmployeeBO2 = new TbCsmEmployeeBO();
		tbCsmEmployeeBO2.setEmployeeId("1334343434");
		tbCsmEmployeeBO2.setAddress("human");
		tbCsmEmployeeBO2.setEmployeeName("wangerxiao");
		TbCsmEmployeeBO[] employees = new TbCsmEmployeeBO[3];
		employees[0] = tbCsmEmployeeBO;
		employees[1] = tbCsmEmployeeBO2;
		employees[2] = tbCsmEmployeeBO;
		return employees;
	}
	
}
