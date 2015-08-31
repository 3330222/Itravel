package com.myrent.service.bs.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myrent.data.entity.TbBizOrderBO;
import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.entity.TbBizRouteDetailBO;
import com.myrent.data.entity.TbBizRouteNodeBO;
import com.myrent.data.entity.TbBizRouteTypeBO;
import com.myrent.data.entity.TbCsmHostelBO;
import com.myrent.data.entity.TbCsmVehicleBO;
import com.myrent.data.model.QueryResult;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.RouteService;
import com.myrent.utils.UUIDUtil;
import com.myrent.vo.DetailVO;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.VOManager;

@Service("routeServiceBean")
public class RouteServiceBean extends DAOImpl<TbBizRouteBO> implements
		RouteService {

	public RouteVO createroute(RouteVO vo) {
		// String whereJPQL = "o.userName like ?1";
		// Object[] params = {"user1"};
		// LinkedHashMap<String, String> orderby = new LinkedHashMap<String,
		// String>();
		// orderby.put("userName", "desc");
		// QueryResult<TbBizRouteBO> queryResult = queryJpqlPagedEntity(0, 10,
		// whereJPQL, params, orderby);
		//
		// List<TbBizRouteBO> list= queryResult.getResultList();
		//
		// System.out.println(list.size());
		if (vo.getRouteid() != null) {
			TbBizRouteBO bo = find(vo.getRouteid());
			String flag = bo.getRouteStatusCd();
			if (flag.equals("3")) {
				bo.setRouteStatusCd("6");
			} else {
				for (Iterator<TbBizRouteDetailBO> iterator = bo.getDetails()
						.iterator(); iterator.hasNext();) {
					TbBizRouteDetailBO detailbo = iterator.next();
					em.remove(detailbo);
				}
				for (Iterator<TbBizRouteNodeBO> iterator = bo.getRouteNodes()
						.iterator(); iterator.hasNext();) {
					TbBizRouteNodeBO nodebo = iterator.next();
					em.remove(nodebo);
				}
				em.remove(bo);
			}
		}
		Timestamp dtime = new Timestamp(System.currentTimeMillis());
		// insert Route.
		TbBizRouteBO newBizRouteBO = new TbBizRouteBO();
		newBizRouteBO.setRouteId(UUIDUtil.generateUUID());
		newBizRouteBO.setRouteName(vo.getName());
		newBizRouteBO.setCreateTime(dtime);
		newBizRouteBO.setDescription(vo.getDes());
		newBizRouteBO.setRouteStatusCd(vo.getStatus());
		MultipartFile file = vo.getFile();
		if (file != null) {
			newBizRouteBO.setThemeImage(vo.getThemeImageUrl());
		}
		TbCsmHostelBO newCsmHostelBO = new TbCsmHostelBO();
		newCsmHostelBO.setUserId(vo.getHotel().getId());
		newBizRouteBO.setHostel(newCsmHostelBO);
		TbBizRouteTypeBO bo=new TbBizRouteTypeBO();
		bo.setRouteTypeId("1002");
		newBizRouteBO.setRouteType(bo);
		save(newBizRouteBO);
		int days = vo.getNodes().size();
		for (int i = 0; i < days; i++) {
			TbBizRouteNodeBO day = new TbBizRouteNodeBO();
			day.setNodeId(UUIDUtil.generateUUID());
			day.setAccommodation(vo.getNodes().get(i).getAccommodation());
			day.setDescription(vo.getNodes().get(i).getDescription());
			day.setNodeName(vo.getNodes().get(i).getName());
			day.setKeywords(vo.getNodes().get(i).getKeywords());
			day.setSequentialNum(i+1);
			MultipartFile image = vo.getNodes().get(i).getImage();
			if (image != null) {
				day.setImageUrl(vo.getNodes().get(i).getIpath());
			}
			day.setRoute(newBizRouteBO);
			em.persist(day);
		}
		int num = vo.getDetails().size();
		int onetime = vo.getDayofweek().length;
		System.out.println(num);
		String a="";
		for (int j = 0; j < onetime; j++) {
			a += vo.getDayofweek()[j] ;
		}
		for (int i = 0; i < num; i++) {
			if (vo.getDetails().get(i).getPrice() != null
					&& (vo.getDetails().get(i).getLimit() != 0)) {
				TbBizRouteDetailBO detail = new TbBizRouteDetailBO();
				detail.setDetailId(UUIDUtil.generateUUID());
				detail.setVehicleType(vo.getDetails().get(i).getVehiclename());	
				Query query = em
						.createQuery("SELECT o FROM TbCsmVehicleBO o WHERE o.brand = ?1");
				query.setParameter(1,vo.getDetails().get(i).getVehiclename());
				List<TbCsmVehicleBO> list = query.getResultList();
				TbCsmVehicleBO vbo=list.get(0);
				detail.setVehicle(vbo);
				detail.setPrice(vo.getDetails().get(i).getPrice());
				detail.setTourGroupLimit(vo.getDetails().get(i).getLimit());
				detail.setRoute(newBizRouteBO);
				detail.setDayOfWeek(a);
				em.persist(detail);
			}
		}
		return vo;
	}

	

	public HashMap<String, RouteVO> findAllRoutes() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT o FROM TbBizRouteBO o");
		List<TbBizRouteBO> result = query.getResultList();
		VOManager voManager = new VOManager();
		HashMap<String, RouteVO> map = new HashMap<String, RouteVO>();
		for (TbBizRouteBO route : result) {
			RouteVO vo1 = new RouteVO();
			String routeId = route.getRouteId();
			vo1 = voManager.getRouteDetail(route);
			map.put(routeId, vo1);
		}
		return map;
	}

	public HashMap<String, RouteVO> findrouteByhotel(HostelVO vo) {
		// TODO Auto-generated method stub

		HashMap<String, RouteVO> results = new HashMap<String, RouteVO>();
		Query query = em
				.createQuery("SELECT o FROM TbCsmHostelBO o WHERE o.userId = ?1");
		query.setParameter(1, vo.getId());
		List<TbCsmHostelBO> list = query.getResultList();	
		Set<TbBizRouteBO> routes = list.get(0).getRoutes();	
		VOManager manager = new VOManager();
		for (Iterator<TbBizRouteBO> iterator = routes.iterator(); iterator
				.hasNext();) {
			TbBizRouteBO oneroute = iterator.next();
			RouteVO route = manager.addroute(oneroute);
			results.put(route.getRouteid(), route);
		}
		return results;
	}

	public void updateStatus(RouteVO vo) {
		// TODO Auto-generated method stub
		TbBizRouteBO bo = find(vo.getRouteid());
		bo.setRouteStatusCd(vo.getStatus());
		bo.setCreateTime(vo.getcTime());
		bo.setUpdateTime(vo.geteTime());
		update(bo);
	}

	@Override
	public void deleterecode(RouteVO vo) {
		TbBizRouteBO bo = find(vo.getRouteid());
		System.out.println(bo.getRouteId());
		for (Iterator<TbBizRouteDetailBO> iterator = bo.getDetails().iterator(); iterator
				.hasNext();) {
			TbBizRouteDetailBO detailbo = iterator.next();
			em.remove(detailbo);
		}
		for (Iterator<TbBizRouteNodeBO> iterator = bo.getRouteNodes()
				.iterator(); iterator.hasNext();) {
			TbBizRouteNodeBO nodebo = iterator.next();
			em.remove(nodebo);
		}
		em.remove(bo);
		
	}

	@Override
	public RouteVO updateRouteCheckStatus(RouteVO vo) {
		
		TbBizRouteBO bo = find(vo.getRouteid());
		bo.setRouteStatusCd(vo.getStatus());
		bo.setFailReason(vo.getFailReason());
		update(bo);
		return vo;
	}
	
	@Override
	public RouteVO updateRouteType(RouteVO vo) {
		// TODO Auto-generated method stub
		TbBizRouteBO bo = find(vo.getRouteid());
		Query query = em
				.createQuery("SELECT o FROM TbBizRouteTypeBO o WHERE o.routeTypeId = ?1");
		query.setParameter(1, vo.getRoutetype());
		System.out.println(vo.getRoutetype());
		List<TbBizRouteTypeBO> list = query.getResultList();	
        bo.setRouteType(list.get(0));
		update(bo);
		return vo;
	}
	
	@Override
	public double findRouteLeastPrice(RouteVO vo) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("select distinct o.price from TbBizRouteDetailBO as o where o.route.routeId = ?1 order by o.price");
		query.setParameter(1, vo.getRouteid());
		List<Double> list = query.getResultList();
		double leastPrice = 0;
		if(list.size() != 0){
			leastPrice = (list.get(0) != null?list.get(0) : list.get(1));
		}
		return leastPrice;
	}


	@Override
	public RouteVO findrouteByRouteId(RouteVO vo) {
		// TODO Auto-generated method stub
		RouteVO route = new RouteVO();
		TbBizRouteBO bo = this.find(vo.getRouteid());
		VOManager manager = new VOManager();
		route = manager.addroute(bo);
		return route;
	}

	@Override
	public HashMap<String, RouteVO> findRouteByStatus(RouteVO vo) {
		// TODO Auto-generated method stub
		HashMap<String, RouteVO> results = new HashMap<String, RouteVO>();
		Query query = em
				.createQuery("SELECT o FROM TbBizRouteBO o WHERE o.routeStatusCd = ?1");
		query.setParameter(1, vo.getStatus());
		List<TbBizRouteBO> routes = query.getResultList();
		VOManager manager = new VOManager();
		for (Iterator<TbBizRouteBO> iterator = routes.iterator(); iterator
				.hasNext();) {
			TbBizRouteBO oneroute = iterator.next();
			RouteVO route = manager.addroute(oneroute);
			results.put(route.getRouteid(), route);
		}
		return results;
	}



	@Override
	public List<TbBizRouteBO> findAllRouteByType(String typeId) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("SELECT o FROM TbBizRouteBO o WHERE o.routeType.routeTypeId = ?1 and o.routeStatusCd = ?2");
		query.setParameter(1, typeId);
		query.setParameter(2, "2");
		return query.getResultList();
	}



	
}