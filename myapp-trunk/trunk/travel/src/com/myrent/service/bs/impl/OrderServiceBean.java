package com.myrent.service.bs.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizOrderBO;
import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.entity.TbBizRouteDetailBO;
import com.myrent.data.entity.TbCsmHostelBO;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.OrderService;
import com.myrent.utils.UUIDUtil;
import com.myrent.vo.HostelVO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.VOManager;
import com.myrent.vo.user.UserVO;

@Service("orderServiceBean")
public class OrderServiceBean extends DAOImpl<TbBizOrderBO> implements
		OrderService {

	@Override
	public TbBizOrderBO find(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbBizOrderBO findOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder(OrderVO vo, TbCsmUserBO user,
			TbBizRouteDetailBO route) {
		// TODO Auto-generated method stub
		Timestamp dtime = new Timestamp(System.currentTimeMillis());
		TbBizOrderBO bo = new TbBizOrderBO();
		bo.setOrderId(UUIDUtil.generateUUID());
		bo.setCreateTime(dtime);
		bo.setOrderStatusCd("1");
		bo.setContactEmail(vo.getContactEmail());
		bo.setContactNumber(vo.getContactNumber());
		bo.setContactPersonGenderCd(vo.getContactGender());
		bo.setContactPersonName(vo.getContactName());
		bo.setRemarks(vo.getRemarks());
		bo.setPrice(vo.getPrice());
		bo.setTourTypeCd(vo.getType());
		bo.setTourNumber(vo.getTourNumber());
		String time = vo.getTravelDate() + " 00:00:00";
		Timestamp ts = Timestamp.valueOf(time);
		bo.setTravelDate(ts);
		bo.setAdultsCount(vo.getNumOfAdult());
		bo.setChildrenCount(vo.getNumOfChild());
		em.persist(bo);
		bo.setCreateUser(user);
		em.merge(user);
		bo.setRouteDetail(route);
		em.merge(route);
	}

	@Override
	public HashMap<String, HashMap<String, TbBizOrderBO>> findOrderByRouteId(OrderVO vo,
			Timestamp date) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("select o from TbBizOrderBO o where o.routeDetail.route.routeId = ?1 and o.travelDate = ?2 and (o.orderStatusCd = ?3 or o.orderStatusCd = ?4)");
		query.setParameter("1", vo.getRouteid());
		query.setParameter("2", date);
		query.setParameter("3", "2");
		query.setParameter("4", "3");
		List<TbBizOrderBO> list = query.getResultList();
		HashMap<String, HashMap<String, TbBizOrderBO>> results = new HashMap<String, HashMap<String, TbBizOrderBO>>();
		query = em
				.createQuery("select o from TbBizRouteDetailBO o where o.route.routeId = ?1");
		query.setParameter("1", vo.getRouteid());
		List<TbBizRouteDetailBO> list2 = query.getResultList();
		if (list2.size() != 0) {
			for (TbBizRouteDetailBO bo : list2) {
				if (!results.keySet().contains(bo.getVehicle().getBrand())) {
					results.put(bo.getVehicle().getBrand(),
							new HashMap<String, TbBizOrderBO>());
				}
			}
		}
		if (list.size() != 0) {
			for (TbBizOrderBO b : list) {
				HashMap<String, TbBizOrderBO> map = results.get(b.getRouteDetail().getVehicle().getBrand());
				if (!map.keySet().contains(b.getTourNumber())) {
					map.put(b.getTourNumber(), b);
				}
			}
		}
		return results;
	}

	@Override
	public LinkedHashMap<String, Map<String, String[]>> findOrderByPeriod(OrderVO vo, String period)
			throws ParseException {
		logger.trace("findOrderByPeriod");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		Date startD = sdf.parse(period + "-01");

		Calendar cal = Calendar.getInstance();
		cal.setTime(startD);
		int month = cal.get(Calendar.MONTH) + 1;
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date endD = cal.getTime();

		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		if (c.get(Calendar.MONTH) == cal.get(Calendar.MONTH)) {
			cal.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
			startD = cal.getTime();
		}

		Timestamp startDate = new Timestamp(startD.getTime());
		Timestamp endDate = new Timestamp(endD.getTime());
		LinkedHashMap<String, Map<String, String[]>> result = new LinkedHashMap<String, Map<String, String[]>>();

		Query query = em.createQuery("select o from TbBizRouteDetailBO o where o.route.routeId = ?1");
		query.setParameter("1", vo.getRouteid());
		List<TbBizRouteDetailBO> list = query.getResultList();
		
		query = em.createQuery("select o from TbBizOrderBO o where o.routeDetail.route.routeId = ?1 and o.travelDate between ?2 and ?3 and (o.orderStatusCd = ?6 or o.orderStatusCd = ?4) and o.tourTypeCd = ?5");
		query.setParameter("1", vo.getRouteid());
		query.setParameter("2", startDate);
		query.setParameter("3", endDate);
		query.setParameter("4", "2");
		query.setParameter("5", "1");
		query.setParameter("6", "3");
		List<TbBizOrderBO> list3 = query.getResultList();
		
		if (list.size() != 0) {
			String dayOfWeek = list.get(0).getDayOfWeek();
			String[] days = dayOfWeek.split("");
			List<List<Date>> dlist = new ArrayList<List<Date>>();
			
			Calendar cc = Calendar.getInstance();
			cc.setTime(startD);
			List<Date> days1 = new ArrayList<Date>();
			
			while (cc.get(Calendar.MONTH) < month) {
				for(String day : days){
					int d = Integer.parseInt(day)+1;
					if(cc.get(Calendar.DAY_OF_WEEK) == d && cc.get(Calendar.MONTH) < month){
						days1.add(cc.getTime());
						cc.add(Calendar.DATE, 1);
					}
				}
				cc.add(Calendar.DATE, 1);
			}
			
			for (Date dl : days1) {
				if (!result.keySet().contains(dl)){
					Map<String, String[]> type = new HashMap<String, String[]>();
					for (TbBizRouteDetailBO bo : list) {
						int num = bo.getTourGroupLimit();
						for (int i = 1; i < num + 1; i++) {
							String keyN = bo.getVehicle().getBrand() + "-" +i;
							if (!type.keySet().contains(keyN)) {
								String perN = bo.getVehicle().getPersons().toString();
								int price = (int) Math.ceil(bo.getPrice()/bo.getVehicle().getPersons());
								String priceN = String.valueOf(price);
								String[] ss = new String[]{perN, priceN};
								type.put(keyN, ss);
							}
//							for (TbBizOrderBO bo1 : list3) {
//								long dif = (bo1.getTravelDate().getTime() - dl.getTime()) / (24 * 60 * 60 * 1000);
//								if (dif == 0 && type.keySet().contains(bo1.getTourNumber())) {	
//									type.remove(bo1.getTourNumber());
//								}
//							}
						}
					}
					result.put(sdf.format(dl), type);
				}
			}
		}

		query = em.createQuery("select o from TbBizOrderBO o where o.routeDetail.route.routeId = ?1 and o.travelDate between ?2 and ?3 and (o.orderStatusCd = ?5 or o.orderStatusCd = ?4)");
		query.setParameter("1", vo.getRouteid());
		query.setParameter("2", startDate);
		query.setParameter("3", endDate);
		query.setParameter("4", "2");
		query.setParameter("5", "3");
		List<TbBizOrderBO> list2 = query.getResultList();
		
		if (list2.size() != 0) {
			for(String k : result.keySet()){				
				Map<String,String[]> m = result.get(k);
				for(String kk : m.keySet()){
					for (TbBizOrderBO bo : list2) {
						long dif = (bo.getTravelDate().getTime() - sdf.parse(k).getTime()) / (24 * 60 * 60 * 1000);
						if (dif == 0 && kk.equals(bo.getTourNumber()) && bo.getTourTypeCd().equals("2")) {	
							int total = bo.getAdultsCount()+bo.getChildrenCount();
							String[] ss = m.get(kk);
							int numLeft = Integer.parseInt(ss[0])-total;
							ss[0] = String.valueOf(numLeft);
							m.put(kk, ss);
						}else if(dif == 0 && kk.equals(bo.getTourNumber()) && bo.getTourTypeCd().equals("1")){
							String[] ss = m.get(kk);
							ss[0] = String.valueOf(0);
							m.put(kk, ss);
						}
					}
				}	
			}
		}

		return result;

	}

	@Override
	public List<OrderVO> findOrdersByHostel(HostelVO vo) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		VOManager vm = new VOManager();
		Query query = em
				.createQuery("SELECT o FROM TbCsmHostelBO o WHERE o.userId = ?1");
		query.setParameter(1, vo.getId());
		List<TbCsmHostelBO> hostel = query.getResultList();
		Set<TbBizRouteBO> routes = hostel.get(0).getRoutes();
		for (TbBizRouteBO bo : routes) {
			Set<TbBizRouteDetailBO> detaillist = bo.getDetails();
			for (TbBizRouteDetailBO dbo : detaillist) {
				Set<TbBizOrderBO> orders = dbo.getOrders();
				for (TbBizOrderBO order : orders) {
					OrderVO od = vm.getOrderVO(order);
						list.add(od);
				}
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> findOrdersByUser(UserVO vo) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		VOManager vm = new VOManager();
		Query query = em
				.createQuery("SELECT o FROM TbCsmUserBO o WHERE o.userId = ?1");
		query.setParameter(1, vo.getUserId());
		List<TbCsmUserBO> users = query.getResultList();
		if(users.size() != 0){
			TbCsmUserBO user = users.get(0);
			query = em.createQuery("SELECT o FROM TbBizOrderBO o WHERE o.createUser = ?1 order by travelDate");
			query.setParameter(1, user);
			List<TbBizOrderBO> orders = query.getResultList();
			for (TbBizOrderBO order : orders) {
				OrderVO od = vm.getOrderVO(order);
					list.add(od);
			}
		}
		
		return list;
	}

	@Override
	public void updateOrderByStatus(OrderVO vo) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT o FROM TbBizOrderBO o WHERE o.orderId = ?1");
		query.setParameter(1, vo.getOrderid());
		TbBizOrderBO bo = (TbBizOrderBO) query.getResultList().get(0);		
		bo.setOrderStatusCd(vo.getStatus());
	}
	
	
	public List<OrderVO> findOrdersByRoute(RouteVO vo) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		VOManager vm = new VOManager();
		Query query = em
				.createQuery("SELECT o FROM TbBizRouteBO o WHERE o.routeName Like '%"+vo.getName()+"%'");
		List<TbBizRouteBO> routes = query.getResultList();
		for (TbBizRouteBO bo : routes) {
			Set<TbBizRouteDetailBO> detaillist = bo.getDetails();
			for (TbBizRouteDetailBO dbo : detaillist) {
				Set<TbBizOrderBO> orders = dbo.getOrders();
				for (TbBizOrderBO order : orders) {
					OrderVO od = vm.getOrderVO(order);
						list.add(od);
				}
			}
		}
		return list;
	}

	@Override
	public void updateUnpaidOrder() {
		// TODO Auto-generated method stub
		
	}
}
