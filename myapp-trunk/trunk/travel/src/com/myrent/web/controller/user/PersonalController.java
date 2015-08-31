package com.myrent.web.controller.user;

import java.io.Console;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myrent.controller.BaseController;
import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.service.bsfc.HostelServiceFacade;
import com.myrent.service.bsfc.OrderServiceFacade;
import com.myrent.service.bsfc.RefundServiceFacade;
import com.myrent.service.bsfc.RouteServiceFacade;
import com.myrent.service.bsfc.SysCodesServiceFacade;
import com.myrent.service.bsfc.UserServiceFacade;
import com.myrent.system.security.UserInfo;
import com.myrent.vo.HostelVO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.UserInfoVO;
import com.myrent.vo.VOManager;
import com.myrent.vo.user.UserVO;

@Controller
@RequestMapping("personal")
public class PersonalController extends BaseController{
	
	@Resource(name="userServiceFacadeBean")
	UserServiceFacade userServiceFacade;
	
	@Resource(name="routeServiceFacadeBean")
	RouteServiceFacade routeServiceFacade;
	
	@Resource(name="sysCodesServiceFacadeBean")
	SysCodesServiceFacade sysCodesServiceFacade;
	
	@Resource(name = "orderServiceFacadeBean")
	private OrderServiceFacade orderFacade;
	
	@Resource(name = "hostelSeriveFacadeBean")
	HostelServiceFacade hostelbean;
	
	@Resource(name = "refundServiceFacadeBean")
	private RefundServiceFacade refundfacade;
	
	@RequestMapping(value = "/info",  method = RequestMethod.GET)
	public ModelAndView getPersonalInfo(ModelMap model,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		ModelAndView view = new ModelAndView("personalInfo");
		UserVO u = new UserVO();
		u.setUserId(this.getCurrentUserId());
		UserInfoVO userInfo = userServiceFacade.getTravellerInfo(u);
		if(userInfo != null){
			userInfo.setOccupation(sysCodesServiceFacade.getOccupationName(userInfo.getOccupation()));
			view.addObject("vo", userInfo);
		}	
		List<String> occupationList = sysCodesServiceFacade.findOccupations();
		view.addObject("occupationList", occupationList);
		view.addObject("userInfo", new UserInfoVO());
		return view;
	}
	
	@RequestMapping(value = "/order")
	public ModelAndView getPersonalOrder(ModelMap model, 
			HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
		ModelAndView view = new ModelAndView("personalOrder");
		UserVO u = new UserVO();
		u.setUserId(this.getCurrentUserId());

		List<OrderVO> all=orderFacade.findOrderbyUser(u);
		List<OrderVO> unpaid=new ArrayList<OrderVO>();
		List<OrderVO> paid=new ArrayList<OrderVO>();
		List<OrderVO> refund=new ArrayList<OrderVO>();
		List<OrderVO> closed=new ArrayList<OrderVO>();
		List<OrderVO> success=new ArrayList<OrderVO>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		for(OrderVO o : all)
		{
			Date d = new Date();
			if(o.getStatus().equals("1")){
				long dif = (d.getTime() - o.getcTime().getTime()) / (24 * 60 * 1000);
				System.out.println(dif + "  "+o.getcTime().getTime());
				if(dif >= 30){
					o.setStatus("4");
					orderFacade.updateOrderByStatus(o);
				}
			}
			else if(o.getStatus().equals("2")){
				long dif = (d.getTime() - sdf.parse(o.getTravelDate()).getTime()) / (24 * 60 * 60 * 1000);
				if(dif >= 3){
					o.setStatus("5");
					orderFacade.updateOrderByStatus(o);
				}
			}
			else if(o.getStatus().equals("3")){
				RefundVO refundVO = refundfacade.findRefundbyOrder(o);
				long dif = (d.getTime() - sdf.parse(refundVO.getcTime()).getTime()) / (24 * 60 * 60 * 1000);
				if(dif >= 5){
					o.setStatus("4");
					//return money back to the user at the same time...... 支付宝
					orderFacade.updateOrderByStatus(o);
				}
			}

			if(o.getStatus().equals("1"))
				unpaid.add(o);
			else if(o.getStatus().equals("2"))
				paid.add(o);
			else if(o.getStatus().equals("3"))
				refund.add(o);
			else if(o.getStatus().equals("4"))
				closed.add(o);
			else if(o.getStatus().equals("5"))
				success.add(o);
		}
		view.addObject("refundVO",new RefundVO());
		view.addObject("unpaid",unpaid);
		view.addObject("paid",paid);
		view.addObject("refund",refund);
		view.addObject("closed",closed);
		view.addObject("success",success);
		return view;
	}
	
	@RequestMapping(value = "/getRefundCT")
	@ResponseBody
	public Date getRefundCT(@RequestParam String orderid,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		OrderVO vo = new OrderVO();
		vo.setOrderid(orderid);
		System.out.println(orderid);
		RefundVO refund = refundfacade.findRefundbyOrder(vo);
		String CT = refund.getcTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date cT = sdf.parse(CT);
		Calendar cc = Calendar.getInstance();
		cc.setTime(cT);
		cc.add(Calendar.DATE, 5);
		Date dd = cc.getTime();
		System.out.println(dd);
		return dd;		
	}
	
	@RequestMapping(value = "/saveRealInfo",  method = RequestMethod.POST)
	public String saveReakInfo(@ModelAttribute("userInfo") @Valid UserInfoVO realInfo,
HttpServletResponse response, HttpServletRequest request, BindingResult bindingResult, SessionStatus sessionStatus) throws IOException {
		realInfo.setRealInfoStatus("2");
		userServiceFacade.updateTravellerInfo(realInfo);
		return "redirect:info";
	}
	
	@RequestMapping(value="/saveInfo")
	public String saveInfo(@ModelAttribute("userInfo") UserInfoVO userInfo,
			HttpServletResponse response, HttpServletRequest request) throws IOException{

		String occu = sysCodesServiceFacade.getOccupationValue(userInfo.getOccupation());
		userInfo.setOccupation(occu);

	    userServiceFacade.updateTravellerInfo(userInfo);
		
		return "redirect:info";
	}
	
//	@RequestMapping(value="/saveTag")
//	public String saveTag(@RequestParam String tag, @RequestParam String userid,
//			HttpServletResponse response, HttpServletRequest request){
//
//		UserVO u = new UserVO();
//		u.setUserId(userid);
//		userServiceFacade.updateDest(tag, u);
//		
//		return null;
//	}
//	
//	@RequestMapping(value="/removeTag")
//	public String removeTag(@RequestParam String tag, @RequestParam String userid,
//			HttpServletResponse response, HttpServletRequest request) throws IOException{
//		System.out.println("tag "+tag);
//		UserVO u = new UserVO();
//		u.setUserId(userid);
//		userServiceFacade.updateDest(tag, u);
//		Map<String, String> map = new HashMap<>();
//		this.writeJson(map, response);
//		return null;
//	}
	
	@RequestMapping(value="/pay")
	public ModelAndView payMoney(@RequestParam String orderid,
			HttpServletResponse response, HttpServletRequest request) throws IOException{
		ModelAndView view = new ModelAndView("pay");
		System.out.println(orderid);
		OrderVO vo = new OrderVO();
		vo.setOrderid(orderid);
		vo.setStatus("2");
		orderFacade.updateOrderByStatus(vo);
		return view;
	}
	
	@RequestMapping(value="/refundApply")
	public String refundApply(@ModelAttribute("refundVO") RefundVO refundVO,
			HttpServletResponse response, HttpServletRequest request) throws IOException{

			OrderVO vo = new OrderVO();
			vo.setOrderid(refundVO.getOrderId());
			vo.setStatus("3");
			orderFacade.createRefund(refundVO);
			orderFacade.updateOrderByStatus(vo);
		return "redirect:order";
	}
	
	@RequestMapping(value = "/tourDIY")
	public ModelAndView maketourDIY( ModelMap model,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		ModelAndView view = new ModelAndView("personalTravel");
		List<RouteVO> list = routeServiceFacade.findAllOnSaleRoutes();
		List<String> routeList = new ArrayList<String>();
		for(RouteVO vo : list){
			routeList.add(vo.getName());
		}
		String routeid="9331344b4efe4503afb5f3a9ce551956";
 		view.addObject("TravelFlag",true);
 		view.addObject("routeList",routeList);
 		view.addObject("routeid",routeid);
		return view;
	}
		
	@RequestMapping(value = "/getTourDIY")
	public ModelAndView gettourDIY( ModelMap model,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		ModelAndView view = new ModelAndView("personalTourDIY");
		UserVO u = new UserVO();
		u.setUserId(this.getCurrentUserId());
		UserInfoVO userInfo = userServiceFacade.getTravellerInfo(u);
		view.addObject("headPath",userInfo.getHeadPhotoPath());
		
		return view;
	}
	
	@RequestMapping(value="/personSetting")
	public String personset(ModelMap model)
	{
		String id=getCurrentUserId();
		UserVO vo=new UserVO();
		vo.setUserId(id);
		UserVO user=userServiceFacade.findUserById(vo);
		model.addAttribute("user",user);
		return "setting";
	}
	
	@RequestMapping(value="/personSetting",method=RequestMethod.POST)
	public String SavepersonSetting(@ModelAttribute("user") UserVO vo,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String url=request.getParameter("imgurl");
		String pre=request.getParameter("previousHead");
		MultipartFile file=vo.getHeadPhotofile();
		if(!url.equals("")){
			vo.setHeadPhoto(url);
		}else if(!file.isEmpty()){
			String path=vo.saveFile(file);
			vo.setHeadPhoto(path);
		}else{
			vo.setHeadPhoto(pre);
		}
		userServiceFacade.updateHostelUser(vo);
		return "redirect:/backend/route/homepage";
	}
	
	
	@RequestMapping(value = "/userinfo")
	@ResponseBody
	// USED TO RETURN JSON TO THE CLIENTS
	public UserVO handleRoute(HttpServletRequest request,HttpServletResponse response) throws IOException {
		UserVO vo = new UserVO();
	    String id=getCurrentUserId();
		vo.setUserId(id);
		UserVO user=userServiceFacade.findUserById(vo);
		HostelVO n=new HostelVO();
		n.setId(id);
		HostelVO hostel=hostelbean.findHostel(n);
		if(hostel!=null){
			user.setHosteluserStatus(hostel.getHostelstatus());
		}
		return user;
	}


	@RequestMapping(value="/findPartner")
	public String findPartner(ModelMap model)
	{
		return "findPartner";
	}
	
	@RequestMapping(value="/myPartner")
	public String myPartner(ModelMap model)
	{
		return "myPartner";
	}
}
