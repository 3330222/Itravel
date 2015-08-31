package com.myrent.web.controller.route;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.myrent.validation.NodeValidator;
import com.myrent.validation.RouteValidator;
import com.myrent.controller.BaseController;
import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.service.bsfc.HostelServiceFacade;
import com.myrent.service.bsfc.RouteServiceFacade;
import com.myrent.service.bsfc.UserServiceFacade;
import com.myrent.vo.DetailVO;
import com.myrent.vo.HostelVO;
import com.myrent.vo.NodeVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.VOManager;
import com.myrent.vo.user.UserVO;

@Controller
@RequestMapping("backend/route")
@SessionAttributes({ "vo", "currentuser" })
public class RouteController extends BaseController {

	@Resource(name = "routeServiceFacadeBean")
	RouteServiceFacade routebean;

	@Resource(name = "userServiceFacadeBean")
	UserServiceFacade userServiceFacade;

	@Resource(name = "hostelSeriveFacadeBean")
	HostelServiceFacade hostelbean;

	@InitBinder("vo")
	public void initBinder(DataBinder binder) {
		binder.setValidator(new RouteValidator(new NodeValidator()));
	}

	@RequestMapping("/newroute")
	public String newRoutePage(ModelMap model) {
		RouteVO vo = new RouteVO();
		String[] cars = { "轿车", "商务车", "大巴", "自行车" };
		model.addAttribute("cars", cars);
		model.addAttribute("vo", vo);
		HostelVO ht = new HostelVO();
		ht.setId(getCurrentUserId());
		vo.setHotel(ht);
		return "createroute";
	}

	@RequestMapping(value = "/newroute", method = RequestMethod.POST)
	public String createRoutePage(@ModelAttribute("vo") @Valid RouteVO vo,
			BindingResult bindingResult, ModelMap model,
			HttpServletResponse response, HttpServletRequest request,
			SessionStatus sessionStatus) throws IOException {
		String flag = request.getParameter("flag");
		if (flag.equals("false")) {
			int nodes = Integer.valueOf(request.getParameter("nodesnum"));
			List<NodeVO> nodelist = new ArrayList<NodeVO>();
			for (int i = 0; i < nodes; i++) {
				if (vo.getNodes() != null) {
					if (vo.getNodes().size() > i)
						nodelist.add(vo.getNodes().get(i));
					else {
						nodelist.add(new NodeVO());
					}
					;
				} else {
					nodelist.add(new NodeVO());
				}
			}
			vo.setNodes(nodelist);
			model.addAttribute("vo", vo);
			return "createroute";
		} else if (flag.equals("true")) {
			if (!bindingResult.hasErrors()) {
				MultipartFile theme = vo.getFile();
				if (theme != null && vo.validateImageFile(theme)) {
					vo.setThemeImageUrl(vo.saveFile(theme));
				}
				;
				for (int i = 0; i < vo.getNodes().size(); i++) {
					MultipartFile image = vo.getNodes().get(i).getImage();
					if (image != null && vo.validateImageFile(image)) {
						vo.getNodes().get(i).setIpath(vo.saveFile(image));
					}
					;
				}
				vo.setStatus("1");
				routebean.create(vo);
				sessionStatus.setComplete();
				return "redirect:homepage";
			}
		}
		return "createroute";
	}

	@RequestMapping(value = "/displaylist")
	public String displayroutes(ModelMap model, SessionStatus sessionStatus) {
		HostelVO vo = new HostelVO();
		vo.setId(getCurrentUserId());
		HashMap<String, RouteVO> results = routebean.findroute(vo);
		List<RouteVO> result1 = new ArrayList<RouteVO>();
		List<RouteVO> result2 = new ArrayList<RouteVO>();
		List<RouteVO> result3 = new ArrayList<RouteVO>();
		List<RouteVO> result4 = new ArrayList<RouteVO>();
		List<RouteVO> result5 = new ArrayList<RouteVO>();
		for (RouteVO value : results.values()) {
			switch (value.getStatus()) {
			case "1":
				result1.add(value);
				break;
			case "2":
				result2.add(value);
				break;
			case "3":
				result3.add(value);
				break;
			case "4":
				result4.add(value);
				break;
			case "5":
				result5.add(value);
				break;
			}
		}
		// sessionStatus.setComplete();
		model.addAttribute("list", results);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);
		model.addAttribute("result4", result4);
		model.addAttribute("result5", result5);
		return "displayroutes";
	}

	@RequestMapping(value = "/displaylist", method = RequestMethod.POST)
	public String displaydetail(ModelMap model, HttpServletResponse response,
			HttpServletRequest request) {
		HostelVO hvo = new HostelVO();
		hvo.setId(getCurrentUserId());
		HashMap<String, RouteVO> list = routebean.findroute(hvo);
		String id = request.getParameter("routeid");
		RouteVO vo = list.get(id);
		List<DetailVO> detail = vo.getDetails();
		List<DetailVO> carlist = new ArrayList<DetailVO>();
		String[] cars = { "轿车", "商务车", "大巴", "自行车" };
		String[] e = { "1", "2", "3", "4" };
		vo.setCars(e);
		for (int i = 0; i < 4; i++) {
			DetailVO c = new DetailVO();
			c.setVehiclename(cars[i]);
			carlist.add(c);
		}
		for (DetailVO a : carlist) {
			for (DetailVO d : detail) {
				if (a.getVehiclename().equals(d.getVehiclename())) {
					a.setPrice(d.getPrice());
					a.setLimit(d.getLimit());
				}
			}
		}
		vo.setDetails(carlist);
		model.addAttribute("vo", vo);
		return "createroute";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchdetail(ModelMap model, HttpServletResponse response,
			HttpServletRequest request) {
		String searchby = request.getParameter("search");
		HostelVO vo = new HostelVO();
		vo.setId(getCurrentUserId());
		HashMap<String, RouteVO> results = routebean.findroute(vo);
		HashMap<String, RouteVO> list = routebean.findroute(vo);
		for (RouteVO route : results.values()) {
			if (route.getName().contains(searchby)) {
				list.put(route.getRouteid(), route);
			}
		}
		List<RouteVO> result1 = new ArrayList<RouteVO>();
		List<RouteVO> result2 = new ArrayList<RouteVO>();
		List<RouteVO> result3 = new ArrayList<RouteVO>();
		List<RouteVO> result4 = new ArrayList<RouteVO>();
		List<RouteVO> result5 = new ArrayList<RouteVO>();
		for (RouteVO value : list.values()) {
			if (value.getName().contains(searchby))
				switch (value.getStatus()) {
				case "1":
					result1.add(value);
					break;
				case "2":
					result2.add(value);
					break;
				case "3":
					result3.add(value);
					break;
				case "4":
					result4.add(value);
					break;
				case "5":
					result5.add(value);
					break;
				}
		}
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);
		model.addAttribute("result4", result4);
		model.addAttribute("result5", result5);
		return "displayroutes";
	}

	@RequestMapping(value = "/updateroute", method = RequestMethod.GET)
	public String downroute(HttpServletResponse response,
			HttpServletRequest request, @RequestParam("rid") String id,
			@RequestParam("status") String status) {
		RouteVO vo = new RouteVO();
		vo.setRouteid(id);
		vo.setStatus(status);
		vo.setcTime(new Timestamp(new Date().getTime()));
		routebean.updateStaus(vo);
		return "redirect:displaylist";
	}

	@RequestMapping(value = "/updateroute", method = RequestMethod.POST)
	public String uproute(HttpServletResponse response,
			HttpServletRequest request) throws ParseException {
		RouteVO vo = new RouteVO();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		String id = request.getParameter("uprouteid");
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		vo.setRouteid(id);
		vo.setStatus("2");
		vo.setcTime(new Timestamp(dateFormat.parse(stime).getTime()));
		vo.seteTime(new Timestamp(dateFormat.parse(etime).getTime()));
		routebean.updateStaus(vo);
		return "redirect:displaylist";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletResponse response,
			HttpServletRequest request) {
		RouteVO vo = new RouteVO();
		String id = request.getParameter("deleteid");
		vo.setRouteid(id);
		routebean.delete(vo);
		return "redirect:displaylist";
	}

	@RequestMapping(value = "/routeinfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	// USED TO RETURN JSON TO THE CLIENTS
	public RouteVO handleRoute(@PathVariable String id) throws IOException {
		RouteVO vo = new RouteVO();
		vo.setRouteid(id);
		TbBizRouteBO bo = routebean.findoneRoute(vo);
		VOManager vm = new VOManager();
		RouteVO result = vm.addroute(bo);
		return result;
	}

	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public void date(HttpServletResponse response, HttpServletRequest request) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		for (int i = 10 - 1; i >= 0; i--) {
			cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - i);
			if (cal.get(Calendar.DAY_OF_WEEK) == 2) {
				System.out.println((dateFormat.format(cal.getTime())));
			}
		}
	}

	@RequestMapping(value = "/preview", method = RequestMethod.POST)
	public String preview(@ModelAttribute("vo") RouteVO vo, ModelMap model)
			throws IOException {
		MultipartFile theme = vo.getFile();
		if (theme != null && vo.validateImageFile(theme)) {
			vo.setThemeImageUrl(vo.saveFile(theme));
		}
		;
		for (int i = 0; i < vo.getNodes().size(); i++) {
			MultipartFile image = vo.getNodes().get(i).getImage();
			if (image != null && vo.validateImageFile(image)) {
				vo.getNodes().get(i).setIpath(vo.saveFile(image));
			}
			;
		}
		model.addAttribute("flag", "preview");
		model.addAttribute("vo", vo);
		return "preview";
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String cancelRoutePage(@ModelAttribute("vo") RouteVO vo,
			ModelMap model, HttpServletResponse response,
			HttpServletRequest request, SessionStatus sessionStatus)
			throws IOException {
		if(!vo.getStatus().equals("3")){
		vo.setStatus("5");
		routebean.create(vo);
		sessionStatus.setComplete();
		}
		return "redirect:displaylist";
	}

	
	@RequestMapping(value = "/homepage")
	public String homepage(ModelMap model) {

		HostelVO n = new HostelVO();
		n.setId(getCurrentUserId());
		getCurrentUser().getUserStatusCd();
		HostelVO hostel = hostelbean.findHostel(n);
		String status = hostel.getHostelstatus();
		model.addAttribute("status", status);
		return "homepage";
	}

}
