package com.myrent.service.bsfc.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizOrderBO;
import com.myrent.data.entity.TbBizPaymentBO;
import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.entity.TbBizRouteDetailBO;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.service.bs.OrderService;
import com.myrent.service.bs.PaymentService;
import com.myrent.service.bs.RefundService;
import com.myrent.service.bs.RouteService;
import com.myrent.service.bs.UserService;
import com.myrent.service.bsfc.OrderServiceFacade;
import com.myrent.vo.HostelVO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.user.UserVO;

@Service("orderServiceFacadeBean")
public class OrderServiceFacadeBean implements OrderServiceFacade {

	@Resource(name="orderServiceBean")
	private OrderService orderService;
	
	@Resource(name="userServiceBean")
	private UserService userService;
	
	@Resource(name="routeServiceBean")
	private RouteService routeService;
	
	@Resource(name="paymentServiceBean")
	private PaymentService paymentService;
	
	@Resource(name="refundServiceBean")
	private RefundService refundService;
	
	@Override
	public void createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		TbCsmUserBO user = userService.find(vo.getUserId());
		TbBizRouteBO route = routeService.find(vo.getRouteid());
		TbBizRouteDetailBO detail = new TbBizRouteDetailBO();
		System.out.println(route.getRouteName());

		for(TbBizRouteDetailBO d : route.getDetails()){
			if(d.getVehicle().getBrand().equals(vo.getVehicleName()))
				detail = d;
		}
		orderService.createOrder(vo, user, detail);
	}

	@Override
	public HashMap<String, Integer> findOrderByRouteId(OrderVO vo, Timestamp date) {
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String, TbBizOrderBO>> map = orderService.findOrderByRouteId(vo, date);
		HashMap<String, Integer> mapCount = new HashMap<String, Integer>();
		for(Iterator iterator = map.keySet().iterator();iterator.hasNext();){
			String k = (String) iterator.next();
			if(map.get(k).size() != 0){
				HashMap<String, TbBizOrderBO> innerMap = map.get(k);
				for(String innerKey : innerMap.keySet()){
					TbBizOrderBO bo = innerMap.get(innerKey);
					int v = bo.getRouteDetail().getTourGroupLimit() - innerMap.size();
					mapCount.put(k,v);
				}
			}
			else{
				TbBizRouteBO bo = routeService.find(vo.getRouteid());
				Set<TbBizRouteDetailBO> list = bo.getDetails();
				for(Iterator iter = list.iterator();iter.hasNext();){
					TbBizRouteDetailBO b = (TbBizRouteDetailBO) iter.next();
					if(b.getVehicle().getBrand().equals(k)){
						int v = b.getTourGroupLimit();
						mapCount.put(k,v);
					}

				}
				
			}
		}
		return mapCount;
	}

	@Override
	public List<OrderVO> findOrderbyHostel(HostelVO vo) {
		// TODO Auto-generated method stub
		return orderService.findOrdersByHostel(vo);
	}

	@Override
	public LinkedHashMap<String, Map<String, String[]>> findOrderByPeriod(OrderVO vo, String period) throws ParseException {
		// TODO Auto-generated method stub
		return orderService.findOrderByPeriod(vo, period);	
	}

	@Override
	public List<OrderVO> findOrderbyUser(UserVO vo) {
		// TODO Auto-generated method stub
		return orderService.findOrdersByUser(vo);
	}

	@Override
	public void updateOrderByStatus(OrderVO vo) {
		// TODO Auto-generated method stub
		orderService.updateOrderByStatus(vo);
	}
	
	@Override
	public List<OrderVO> findOrdersByRoute(RouteVO vo) {
		// TODO Auto-generated method stub
		return orderService.findOrdersByRoute(vo);
	}

	@Override
	public void updateUnpaidOrder() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void createRefund(RefundVO vo) {
		// TODO Auto-generated method stub
		List<TbBizPaymentBO> list = paymentService.findPaymentByOrderId(vo.getOrderId());
		TbBizPaymentBO payment = null;
		for(TbBizPaymentBO bo : list){
			if(bo.getPaymentStatusCd().equals("2"))
				payment = bo;
		}
		refundService.createRefund(vo, payment);
		
	}

}
