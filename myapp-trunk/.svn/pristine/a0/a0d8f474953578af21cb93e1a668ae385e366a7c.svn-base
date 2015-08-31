package com.myrent.service.bsfc;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.myrent.vo.HostelVO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.user.UserVO;

public interface OrderServiceFacade {

	public void createOrder(OrderVO vo);
	
	public HashMap<String, Integer> findOrderByRouteId(OrderVO vo, Timestamp date);
	public List<OrderVO> findOrderbyHostel(HostelVO vo);
	public List<OrderVO> findOrdersByRoute(RouteVO vo);
	public List<OrderVO> findOrderbyUser(UserVO vo);
	
	public LinkedHashMap<String, Map<String, String[]>> findOrderByPeriod(OrderVO vo, String period) throws ParseException;
	public void updateUnpaidOrder();
	public void updateOrderByStatus(OrderVO vo);
	public void createRefund(RefundVO vo);
}
