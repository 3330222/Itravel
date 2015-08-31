package com.myrent.web.controller.hostelapplyverify;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.myrent.controller.BaseController;
import com.myrent.service.bsfc.HostelServiceFacade;
import com.myrent.vo.HostelVO;

@Controller

@RequestMapping("backend/hostel")
public class HostelApplyVerifyController extends BaseController {

	@Resource(name = "hostelSeriveFacadeBean")
	HostelServiceFacade hostelbean;

	@RequestMapping(value = "/applyverify", method = RequestMethod.GET)
	public String toVerifyHostel(ModelMap model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		HostelVO hostelVO = new HostelVO();	
		hostelVO.setId(getCurrentUserId());
		System.out.println(hostelVO.getId());
		System.out.println("eee");
		hostelVO = hostelbean.findHostel(hostelVO);
		if(hostelVO.getHostelstatus().equals("3")){
			model.addAttribute("svo", hostelVO);
			model.addAttribute("edit",3);
			System.out.println("sdfsafdsfsfsaf");
		}else if(hostelVO.getHostelstatus().equals("2")){
			model.addAttribute("svo", hostelVO);
			model.addAttribute("edit",2);
			System.out.println("fsfsaf");
			
		}else{
			model.addAttribute("svo", hostelVO);
			model.addAttribute("edit",1);
			System.out.println("wwwwwww");
		}
		return "verifyhostel";
	}

	@RequestMapping(value = "/applyverify", method = RequestMethod.POST)
	public String toVerifyHostel(@ModelAttribute("svo") HostelVO vo, ModelMap model,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus) throws IOException {
		vo.setId(getCurrentUserId());
		MultipartFile id = vo.getIdfile();
		MultipartFile license = vo.getLicensefile();
		MultipartFile idback = vo.getIdfileback();
		vo.setIdImageUrl(vo.saveFile(id));
		vo.setLicenseImageUrl(vo.saveFile(license));
		vo.setIdbackImageUrl(vo.saveFile(idback));
		vo.setHostelstatus("2");
		hostelbean.create(vo);
		sessionStatus.setComplete();
		return "homepage";
	}

}
