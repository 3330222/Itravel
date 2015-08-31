package com.myrent.web.controller.order;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myrent.controller.BaseController;
import com.myrent.service.bs.RefundService;
import com.myrent.service.bsfc.OrderServiceFacade;
import com.myrent.service.bsfc.PlanServiceFacade;
import com.myrent.service.bsfc.RefundServiceFacade;
import com.myrent.service.bsfc.RouteServiceFacade;
import com.myrent.service.bsfc.SysCodesServiceFacade;
import com.myrent.service.bsfc.UserServiceFacade;
import com.myrent.vo.HostelVO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.PlanVO;
import com.myrent.vo.RefundVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.UserInfoVO;
import com.myrent.vo.user.UserVO;

@Controller
@RequestMapping("order")
public class OrderController extends BaseController {

	@Resource(name = "userServiceFacadeBean")
	UserServiceFacade userServiceFacade;

	@Resource(name = "sysCodesServiceFacadeBean")
	SysCodesServiceFacade sysCodesServiceFacade;

	@Resource(name = "routeServiceFacadeBean")
	RouteServiceFacade routeFacade;

	@Resource(name = "orderServiceFacadeBean")
	private OrderServiceFacade orderFacade;
	
	@Resource(name = "refundServiceFacadeBean")
	RefundServiceFacade refundServiceFacade;

	@RequestMapping(value = "/makeOrder")
	public ModelAndView makeOrder(@RequestParam String routeid,HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		ModelAndView view = new ModelAndView("makeOrder");
		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		UserVO u = new UserVO();
		u.setUserId(this.getCurrentUserId());
		vo = routeFacade.findrouteById(vo);
		double leastPrice = routeFacade.findRouteLeastPrice(vo);
		OrderVO order = new OrderVO();
		order.setRouteid(vo.getRouteid());
		order.setUserId(u.getUserId());
		view.addObject("route", vo);
		view.addObject("leastPrice", leastPrice);
		view.addObject("vo", order);
		return view;
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public ModelAndView createOrder(@ModelAttribute("vo") @Valid OrderVO order,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		ModelAndView view = new ModelAndView("pay");
		orderFacade.createOrder(order);
		return view;
	}

	@RequestMapping(value = "/checkAvali")
	public ModelAndView gerPrice(@RequestParam String date,
			@RequestParam String routeid, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		OrderVO vo = new OrderVO();
		vo.setRouteid(routeid);
		String time = date + " 00:00:00";
		Timestamp ts = Timestamp.valueOf(time);
		HashMap<String, Integer> map = orderFacade.findOrderByRouteId(vo, ts);
		this.writeJson(map, response);
		return null;
	}

	@RequestMapping(value = "/orderDetail")
	public ModelAndView getAvalibleRoute(@RequestParam String tourNumber,
			@RequestParam String routeid, @RequestParam String date,
			@RequestParam String leftSpace, @RequestParam String price,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException, ParseException {

		ModelAndView view = new ModelAndView("OrderDetail");
		UserVO u = new UserVO();
		u.setUserId(this.getCurrentUserId());
		OrderVO order = new OrderVO();

		String[] ss = tourNumber.split("-");
		String name = ss[0];
		order.setVehicleName(name);
		order.setTourNumber(tourNumber);
		order.setTravelDate(date);
		order.setUserId(u.getUserId());
		order.setRouteid(routeid);
		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		vo = routeFacade.findrouteById(vo);
		view.addObject("route", vo);
		view.addObject("vo", order);
		view.addObject("leftSpace", leftSpace);
		view.addObject("SepPrice", price);
		return view;
	}

	@RequestMapping(value = "/getAvalibleRoute", method = RequestMethod.GET)
	@ResponseBody
	public LinkedHashMap<String, Map<String, String[]>> handleRest(
			ModelMap model, @RequestParam String period,
			@RequestParam String routeid, HttpServletResponse response,
			HttpServletRequest request) throws IOException, ParseException {
		OrderVO vo = new OrderVO();
		vo.setRouteid(routeid);

		orderFacade.findOrderByPeriod(vo, period);
		return orderFacade.findOrderByPeriod(vo, period);
	}

	@RequestMapping(value = "/viewOrders")
	public String viewHostelOrders(ModelMap model) throws ParseException {
		HostelVO vo = new HostelVO();
		vo.setId(getCurrentUserId());
		List<OrderVO> orders = orderFacade.findOrderbyHostel(vo);
		List<OrderVO> suc = new ArrayList<OrderVO>();
		List<OrderVO> turnback = new ArrayList<OrderVO>();
		List<OrderVO> history = new ArrayList<OrderVO>();
		for (OrderVO o : orders) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			Date traveldate = format.parse(o.getTravelDate());
			if (traveldate.after(d)) {
				if (o.getStatus().equals("2")) {
					suc.add(o);
				} else if (o.getStatus().equals("3")) {
					turnback.add(o);
				}
			} else {
				if (!o.getStatus().equals("1")) {
					history.add(o);
				};
			}
		}
		model.addAttribute("suc", suc);
		model.addAttribute("fail", turnback);
		model.addAttribute("history", history);
		return "Ordersview";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(ModelMap model, RouteVO route,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		String name = request.getParameter("search");
		RouteVO searchvo = new RouteVO();
		searchvo.setName(name);
		if (!name.equals("")) {
			List<OrderVO> orders = orderFacade.findOrdersByRoute(searchvo);
			List<OrderVO> suc = new ArrayList<OrderVO>();
			List<OrderVO> turnback = new ArrayList<OrderVO>();
			List<OrderVO> history = new ArrayList<OrderVO>();
			for (OrderVO o : orders) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d = new Date();
				Date traveldate = format.parse(o.getTravelDate());
				if (traveldate.after(d)) {
					if (o.getStatus().equals("2")) {
						suc.add(o);
					} else if (o.getStatus().equals("3")) {
						turnback.add(o);
					}
				} else {
					if (!o.getStatus().equals("1")) {
						history.add(o);
					};
				}
			}
			model.addAttribute("suc", suc);
			model.addAttribute("fail", turnback);
			model.addAttribute("history", history);
			return "Ordersview";
		}else{
			return "redirect:viewOrders";
		}
	}

	@RequestMapping(value = "/getMonth", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getMonth(@RequestParam String endD,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		List<String> dates = new ArrayList<String>();
		Date sD = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date eD = sdf.parse(endD);
		Calendar c = Calendar.getInstance();
		c.setTime(sD);
		Calendar cc = Calendar.getInstance();
		cc.setTime(eD);
		c.set(Calendar.DATE, cc.get(Calendar.DATE));
		while ((eD.getTime() - c.getTimeInMillis()) / (3600 * 24 * 1000) >= 0) {
			int month = 1 + c.get(Calendar.MONTH);
			String d = c.get(Calendar.YEAR) + "-" + month;
			System.out.println(d);
			dates.add(d);
			c.add(Calendar.MONTH, 1);
		}
		return dates;
	}

	@RequestMapping(value = "/updaterefund", method = RequestMethod.POST)
	public String updateRefund(HttpServletRequest request,
			HttpServletResponse response) {
		String order = request.getParameter("orderid");
		String status = request.getParameter("status");
		String rejectreason = request.getParameter("rejectreason");
		String rejectstatus = request.getParameter("refundstatus");
		OrderVO vo = new OrderVO();
		vo.setOrderid(order);
		vo.setStatus(status);
		orderFacade.updateOrderByStatus(vo);
		RefundVO rvo = new RefundVO();
		rvo.setRefundId(vo.getOrderid());
		rvo.setRefundStatus(rejectstatus);
		rvo.setRefundReason(rejectreason);
		refundServiceFacade.updateRefundStatus(rvo);
		return "redirect:viewOrders";
	}
	
	@RequestMapping(value = "/viewRoute")
	public String viewRoute(@RequestParam String routeid,ModelMap model,
			HttpServletRequest request,
			HttpServletResponse response) {
		RouteVO vo = new RouteVO();
		vo.setRouteid(routeid);
		RouteVO v = routeFacade.findrouteById(vo);
		System.out.println(v.getHotel().getHostelname());
		model.addAttribute("vo",v);
		return "tourPreview";
	}
	
}
