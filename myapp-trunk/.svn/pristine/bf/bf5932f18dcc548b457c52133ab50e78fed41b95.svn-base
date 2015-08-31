package com.myrent.web.controller.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myrent.controller.BaseController;
import com.myrent.service.bsfc.PlanServiceFacade;
import com.myrent.service.bsfc.RouteServiceFacade;
import com.myrent.vo.PlanVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.user.UserVO;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class CommonController extends BaseController{
	
	@Resource(name = "routeServiceFacadeBean")
	RouteServiceFacade routeServiceFacade;
	
	@Resource(name = "planServiceFacadeBean")
	private PlanServiceFacade planServiceFacade;
	
	@RequestMapping("/")
	public String index(ModelMap modelMap){
		//modelMap.addAttribute("CurrentUserAccount",this.getCurrentUserAccount());
		List<RouteVO> list = routeServiceFacade.findAllRouteByType("1001");
		List<RouteVO> result  = new ArrayList<RouteVO>();
		if(list.size() < 12)
			modelMap.addAttribute("result", list);
		else{
			for(int i =0; i<12 ; i++){
			result.add(list.get(i));
			}
			modelMap.addAttribute("result", result);
		}
		List<RouteVO> list2 = routeServiceFacade.findAllRouteByType("1003");
		modelMap.addAttribute("list2", list2);
		return "index";
	}
	
	@RequestMapping("/showMore")
	@ResponseBody
	public ArrayList<String[]> showMore(HttpServletRequest request,
			HttpServletResponse response) throws IOException{

		List<RouteVO> list = routeServiceFacade.findAllRouteByType("1001");
		ArrayList<String[]> routes = new ArrayList<String[]>();
		for(RouteVO vo : list){
			String[] ss = new String[4];
			ss[0] = vo.getThemeImageUrl();
			ss[1] = vo.getName();
			ss[2] = vo.getDes();
			ss[3] = vo.getRouteid();
			routes.add(ss);
		}
		return routes;
	}
	
	@RequestMapping("/showMoreAll")
	@ResponseBody
	public ArrayList<String[]> showMoreAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException{

		List<RouteVO> all = routeServiceFacade.findAllOnSaleRoutes();
		ArrayList<String[]> routes = new ArrayList<String[]>();
		for(RouteVO i : all){
			String[] ss = new String[4];
			ss[0] = i.getThemeImageUrl();
			ss[1] = i.getName();
			ss[2] = i.getDes();
			ss[3] = i.getRouteid();
			routes.add(ss);
		}
		return routes;
	}
	
	@RequestMapping("/route_list")
	public String toDetail(ModelMap modelMap){
		
		List<RouteVO> list = routeServiceFacade.findAllOnSaleRoutes();
		modelMap.addAttribute("list",list);
		return "route_list";
	}
	
	@RequestMapping("/dingzhi")
	public String toDingzhi(ModelMap modelMap){
		modelMap.addAttribute("plan", new PlanVO());
		return "dingzhi";
	
	}
	
	@RequestMapping(value = "/personplan", method = RequestMethod.POST)
	public String createplan(@ModelAttribute("plan") PlanVO plan,HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		UserVO vo=new UserVO();
		vo.setUserId(getCurrentUserId());
		plan.setUser(vo);
		String date=request.getParameter("travelDate");
		if(!date.equals(""))
		{
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		plan.setTraveldate(new Timestamp(format.parse(date).getTime()));
		}else{
			plan.setTraveldate(null);
		}
		planServiceFacade.createplan(plan);
		return "index";
	}
	
	@RequestMapping("/contact_us")
	public String toContact(ModelMap modelMap){
		modelMap.addAttribute("cont", new RouteVO());
		return "contact_us";
	
	}

}
