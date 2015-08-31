package com.myrent.service.bs;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myrent.data.entity.TbBizOrderBO;
import com.myrent.data.entity.TbBizRouteDetailBO;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.model.dao.DAO;
import com.myrent.vo.HostelVO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.user.UserVO;

public interface OrderService extends DAO<TbBizOrderBO> {
	
	public TbBizOrderBO findOrder(String orderId);
	public void createOrder(OrderVO vo, TbCsmUserBO user, TbBizRouteDetailBO route);
	public HashMap<String, HashMap<String, TbBizOrderBO>> findOrderByRouteId(OrderVO vo,Timestamp date);
	public LinkedHashMap<String, Map<String, String[]>> findOrderByPeriod(OrderVO vo, String period) throws ParseException;
	public List<OrderVO> findOrdersByHostel(HostelVO vo);
	public  List<OrderVO> findOrdersByRoute(RouteVO vo);
	public List<OrderVO> findOrdersByUser(UserVO vo);
	public void updateOrderByStatus(OrderVO vo);
	public void updateUnpaidOrder();
}
