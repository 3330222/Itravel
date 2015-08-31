package com.myrent.web.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.myrent.controller.BaseController;
import com.myrent.service.bsfc.HostelServiceFacade;
import com.myrent.service.bsfc.RouteServiceFacade;
import com.myrent.service.bsfc.SysResourceServiceFacade;
import com.myrent.service.bsfc.UserServiceFacade;
import com.myrent.system.SystemConfig;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.SysResourceVO;
import com.myrent.vo.user.UserVO;

@Controller
@RequestMapping("admin")
@SessionAttributes("vo")
public class AdminController extends BaseController {

	@Resource(name = "userServiceFacadeBean")
	UserServiceFacade userServiceFacade;

	@Resource(name = "routeServiceFacadeBean")
	RouteServiceFacade routeServiceFacade;

	@Resource(name = "hostelSeriveFacadeBean")
	HostelServiceFacade hostelServiceFacade;

	@Resource(name = "sysResourceServiceFacadeBean")
	SysResourceServiceFacade sysResourceServiceFacade;

	@RequestMapping(value = "/info")
	public String getPersonalInfo(HttpServletResponse response,
			HttpServletRequest request, ModelMap model) throws IOException {

		Map<String, UserVO> maps = userServiceFacade.findUserDetails(null);
		Map<String, UserVO> map = new HashMap<String, UserVO>();
		Map<String, HostelVO> hostellist = new HashMap<String, HostelVO>();
		for (UserVO vo : maps.values()) {
			if (vo.getUserTypeCd().equals("1")
					&& vo.getUserStatus().equals("2")) {
				map.put(vo.getUserId(), vo);
			} else if (vo.getUserTypeCd().equals("2")) {
				HostelVO hostel = new HostelVO();
				hostel.setId(vo.getUserId());
				HostelVO co = hostelServiceFacade.findHostel(hostel);
				if (co.getHostelstatus().equals("2")) {
					map.put(vo.getUserId(), vo);
					hostellist.put(vo.getUserId(), co);
					model.addAttribute("result2", hostellist);
				}
			}
		}
		model.addAttribute("result1", map);
		Map<String, RouteVO> routemaps = routeServiceFacade.findAllRoutes();
		Map<String, RouteVO> routemap = new HashMap<String, RouteVO>();
		int routenumber = 0;
		for (RouteVO v : routemaps.values()) {
			if (v.getStatus().equals("1")) {
				routemap.put(v.getRouteid(), v);
			} else if (v.getStatus().equals("2") || v.getStatus().equals("3")) {
				routenumber++;
			}
		}
		
        int usernum=0;
		Map<String, UserVO> user = userServiceFacade.findUserDetails(null);
		for (UserVO u : user.values()) {
			if (u.getUserTypeCd().equals("1") && u.getUserStatus().equals("2")) {
				usernum++;
			}
		}
		model.addAttribute("result2", routemap);
		model.addAttribute("routebumber", routenumber);
		model.addAttribute("usernum", usernum);
		return "adminInfo";
	}

	/*
	 * @RequestMapping(value = "/applicationList", method = RequestMethod.GET)
	 * public ModelAndView displayRouteApplicationList(ModelMap model,
	 * 
	 * @ModelAttribute("vo") @Valid UserVO vo, HttpServletResponse response,
	 * HttpServletRequest request) throws IOException { ModelAndView view = new
	 * ModelAndView("routeAudition");
	 * 
	 * //HashMap[] map = routeServiceFacade.findAllUsers(null);
	 * //this.writeJsonArray(map, response);
	 * 
	 * return view; }
	 */

	@RequestMapping("/queryAllApplication")
	public String queryAllEmployees(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// Map[] array = employeeBean.findAllEmployeeArrayMap(null);
		Map[] map = userServiceFacade.findAllUsers(null);
		this.writeJsonArray(map, response);
		// Map<String, RouteVO> map = routeServiceFacade.find(null);
		// List<Map> resultList = new ArrayList<Map>();
		// Map[] array = (Map[])resultList.toArray();

		// array[0].put("userName", "help");
		// this.writeJson(map, response);
		return null;
	}

	@RequestMapping(value = "/applicationList")
	public String displayRouteApplicationList(HttpServletResponse response,
			HttpServletRequest request, ModelMap model) throws IOException {

		Map<String, RouteVO> maps = routeServiceFacade.findAllRoutes();
		Map<String, RouteVO> map = new HashMap<String, RouteVO>();
		for (RouteVO v : maps.values()) {
			if (v.getStatus().equals("1")) {
				map.put(v.getRouteid(), v);
			}
		}
		RouteVO vo = new RouteVO();
		model.addAttribute("vo", vo);
		model.addAttribute("result1", map);
		return "routeAudition";
	}

	@RequestMapping(value = "/routeList")
	public String RouteApplicationHistory(HttpServletResponse response,
			HttpServletRequest request, ModelMap model) throws IOException {
		Map<String, RouteVO> maps = routeServiceFacade.findAllRoutes();
		Map<String, RouteVO> map = new HashMap<String, RouteVO>();
		for (RouteVO v : maps.values()) {
			if (v.getStatus().equals("2") || v.getStatus().equals("3")) {
				map.put(v.getRouteid(), v);
			}
		}
		RouteVO vo = new RouteVO();
		model.addAttribute("vo", vo);
		model.addAttribute("result1", map);
		model.addAttribute("flag", "true");
		return "routeAudition";
	}

	@RequestMapping(value = "/queryRestJson", produces = "text/html;charset=UTF-8")
	public String queryRestJson(HttpServletRequest request,
			HttpServletResponse response, Locale local) throws IOException {
		// Map<String, String> map = new HashMap<>();
		// String value = "123中文";
		// System.out.println("value>>>" + value);
		// map.put("employeeName", value);
		// this.writeJson(map, response);
		// return null;
		//
		Map<String, RouteVO> map = routeServiceFacade.findAllRoutes();
		List<Map> resultList = new ArrayList<Map>();

		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String routeId = (String) entry.getKey();
			RouteVO vo1 = (RouteVO) entry.getValue();

			Map tempMap = new HashMap();
			tempMap.put("routeid", vo1.getRouteid());
			tempMap.put("des", vo1.getDes());
			tempMap.put("name", vo1.getName());
			tempMap.put("Status", vo1.getStatus());
			tempMap.put("themeImageUrl", vo1.getThemeImageUrl());
			resultList.add(tempMap);
		}

		System.out.println(resultList);

		Map[] array = (Map[]) resultList.toArray();

		this.writeJsonArray(array, response);
		return null;
	}

	@RequestMapping(value = "/approveRoute", method = RequestMethod.POST)
	public String approveRoute(
			@ModelAttribute("routeid") @Valid String routeid,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus) throws IOException {
		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		vo.setStatus("3");
		routeServiceFacade.updateRouteCheckStatus(vo);
		return "redirect:applicationList";
	}

	@RequestMapping(value = "/rejectRoute", method = RequestMethod.POST)
	public String denyRoute(@ModelAttribute("routeid") @Valid String routeid,
			@ModelAttribute("failReason") @Valid String reason,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus) throws IOException {
		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		vo.setStatus("4");
		vo.setFailReason(reason);
		routeServiceFacade.updateRouteCheckStatus(vo);
		return "redirect:applicationList";
	}

	@RequestMapping(value = "/setRouteType", method = RequestMethod.POST, params = { "set" })
	public String setRouteType(
			@ModelAttribute("routeid") @Valid String routeid,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus, @RequestParam String set)
			throws IOException {

		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		vo.setRoutetype("1001");
		routeServiceFacade.updateRouteType(vo);
		return "redirect:updateEpicRoute";
	}

	@RequestMapping(value = "/setRouteType", method = RequestMethod.POST, params = { "delete" })
	public String deleteRouteType(
			@ModelAttribute("routeid") @Valid String routeid,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus, @RequestParam String delete)
			throws IOException {
		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		vo.setRoutetype("1002");
		routeServiceFacade.updateRouteType(vo);
		return "redirect:updateEpicRoute";
	}

	@RequestMapping(value = "/updateImage")
	public String updateImage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		List<RouteVO> all = routeServiceFacade.findAllOnSaleRoutes();
		model.addAttribute("result1", all);
		return "updateImage";
	}

	@RequestMapping(value = "/updateImageType", method = RequestMethod.POST)
	public String uploadFileHandler(ModelMap model,
			@RequestParam String indexs, HttpServletResponse response,
			HttpServletRequest request) {
		List<RouteVO> all = routeServiceFacade.findAllOnSaleRoutes();
		for (RouteVO vo : all) {
			if (vo.getRoutetype().equals("1003")) {
				vo.setRoutetype("1002");
				routeServiceFacade.updateRouteType(vo);
			}
		}

		String[] index = indexs.split(",");
		for (String i : index) {
			String[] r = i.split("-");
			RouteVO vo = new RouteVO();
			vo.setRouteid(r[1]);
			System.out.println(r[1]);
			vo.setRoutetype("1003");
			routeServiceFacade.updateRouteType(vo);
		}
		return "redirect:updateImage";
	}

	@RequestMapping(value = "/updateEpicRoute")
	public String updateEpicRoute(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		List<RouteVO> all = routeServiceFacade.findAllOnSaleRoutes();
		model.addAttribute("result1", all);
		return "updateEpicRoute";
	}

	@RequestMapping(value = "/updateRouteType")
	public String updateRouteType(@RequestParam String indexs,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<RouteVO> all = routeServiceFacade.findAllOnSaleRoutes();
		for (RouteVO v : all) {
			if (v.getRoutetype().equals("1001")) {
				v.setRoutetype("1002");
				routeServiceFacade.updateRouteType(v);
			}
		}

		String[] index = indexs.split(",");
		for (String i : index) {
			String[] r = i.split("-");
			RouteVO vo = new RouteVO();
			vo.setRouteid(r[1]);
			vo.setRoutetype("1001");
			routeServiceFacade.updateRouteType(vo);
		}
		return "redirect:updateEpicRoute";
	}

	@RequestMapping(value = "/userAudition")
	public String userAudition(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,
			@RequestParam("usertype") String usertype) {
		Map<String, UserVO> maps = userServiceFacade.findUserDetails(null);
		Map<String, UserVO> map = new HashMap<String, UserVO>();
		Map<String, HostelVO> hostellist = new HashMap<String, HostelVO>();
		if (usertype.equals("1")) {
			for (UserVO vo : maps.values()) {
				if (vo.getUserTypeCd().equals("1")
						&& vo.getUserStatus().equals("2")) {
					map.put(vo.getUserId(), vo);
				}
			}
		} else {
			for (UserVO vo : maps.values()) {
				if (vo.getUserTypeCd().equals("2")) {
					HostelVO hostel = new HostelVO();
					hostel.setId(vo.getUserId());
					HostelVO co = hostelServiceFacade.findHostel(hostel);
					if (co.getHostelstatus().equals("2")) {
						map.put(vo.getUserId(), vo);
						hostellist.put(vo.getUserId(), co);
					}
				}
			}
			model.addAttribute("result2", hostellist);
		}
		model.addAttribute("result1", map);
		return "userAudition";
	}

	@RequestMapping(value = "/userAuditionWithPara")
	public String userAudition(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,
			@RequestParam(value = "display") int display) {
		Map<String, UserVO> userMap = new HashMap<String, UserVO>();
		UserVO vo1 = new UserVO();
		if (display == 1) {
			Map<String, UserVO> userMap1 = new HashMap<String, UserVO>();
			vo1.setUserStatus("1");
			userMap1 = userServiceFacade.findUserByUserStatus(vo1);
			Map<String, UserVO> userMap2 = new HashMap<String, UserVO>();
			vo1.setUserStatus("2");
			userMap2 = userServiceFacade.findUserByUserStatus(vo1);
			userMap.putAll(userMap1);
			userMap.putAll(userMap2);
		} else if (display == 2) {
			vo1.setUserStatus("0");
			userMap = userServiceFacade.findUserByUserStatus(vo1);
		} else {
			System.out.println("plz check the param");
		}
		// Map<String, UserVO> map = userServiceFacade.findUserDetails(null);
		UserVO vo = new UserVO();
		model.addAttribute("vo", vo);
		model.addAttribute("result1", userMap);
		return "userAudition";
	}

	@RequestMapping(value = "/auditUser", method = RequestMethod.POST, params = { "approve" })
	public String approveUser(@ModelAttribute("userid") @Valid String userid,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus, @RequestParam String approve)
			throws IOException {
		String usertype = request.getParameter("typeid");
		UserVO vo = new UserVO();
		vo.setUserId(userid);
		vo.setUserStatus("4");
		// routeServiceFacade.updateRouteType(vo);
		userServiceFacade.updateUserStatus(vo);
		return "redirect:userAudition?usertype=" + usertype;
	}

	@RequestMapping(value = "/auditUser", method = RequestMethod.POST, params = { "reject" })
	public String rejectUser(@ModelAttribute("userid") @Valid String userid,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus, @RequestParam String reject)
			throws IOException {
		String usertype = request.getParameter("typeid");
		UserVO vo = new UserVO();
		vo.setUserId(userid);
		vo.setUserStatus("3");
		// routeServiceFacade.updateRouteType(vo);
		userServiceFacade.updateUserStatus(vo);
		return "redirect:userAudition?usertype=" + usertype;
	}

	@RequestMapping(value = "/auditHostel", method = RequestMethod.POST)
	public String verifyHostel(@ModelAttribute("userid") @Valid String userid,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus) throws IOException {
		String usertype = request.getParameter("typeid");
		String status = request.getParameter("status");
		HostelVO vo = new HostelVO();
		vo.setId(userid);
		vo.setHostelstatus(status);
		hostelServiceFacade.updateHostelStatus(vo);
		return "redirect:userAudition?usertype=" + usertype;
	}

	@RequestMapping(value = "/applicationListWithPara")
	public String displayRouteApplicationListWithPara(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, @RequestParam(value = "display") int display)
			throws IOException {

		Map<String, RouteVO> map = routeServiceFacade.findAllRoutes();
		RouteVO vo1 = new RouteVO();
		if (display == 0) {
			Map<String, RouteVO> routeMap1 = new HashMap<String, RouteVO>();
			vo1.setStatus("0");
			map = routeServiceFacade.findRouteByStatus(vo1);
		} else if (display == 12) {

			Map<String, RouteVO> routeMap1 = new HashMap<String, RouteVO>();
			vo1.setStatus("1");
			routeMap1 = routeServiceFacade.findRouteByStatus(vo1);
			Map<String, RouteVO> routeMap2 = new HashMap<String, RouteVO>();
			vo1.setStatus("2");
			routeMap2 = routeServiceFacade.findRouteByStatus(vo1);
			map.putAll(routeMap1);
			map.putAll(routeMap2);

		} else if (display == 1) {
			Map<String, RouteVO> routeMap1 = new HashMap<String, RouteVO>();
			vo1.setStatus("1");
			map = routeServiceFacade.findRouteByStatus(vo1);

		} else if (display == 2) {
			Map<String, RouteVO> routeMap1 = new HashMap<String, RouteVO>();
			vo1.setStatus("2");
			map = routeServiceFacade.findRouteByStatus(vo1);
		} else {
			System.out.println("plz check the param");
		}

		model.addAttribute("vo", vo1);
		model.addAttribute("result1", map);
		return "routeAudition";
	}

}
