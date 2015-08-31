package com.myrent.service.bsfc.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.service.bs.RouteService;
import com.myrent.service.bs.UserService;
import com.myrent.service.bsfc.RouteServiceFacade;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;
import com.myrent.vo.VOManager;

@Service("routeServiceFacadeBean")
public class RouteServiceFacadeBean implements RouteServiceFacade{

	@Resource(name="routeServiceBean")
	private RouteService routeService;
	
	public void create(RouteVO vo){
		routeService.createroute(vo);
	}
	
    public void update(){
		
	}
	
    
    public void delete(RouteVO vo){
		routeService.deleterecode(vo);
  	}
 
	public HashMap<String, RouteVO> findAllRoutes() {
		// TODO Auto-generated method stub
		HashMap<String, RouteVO> map = routeService.findAllRoutes();
		return map;
	}

	public HashMap<String, RouteVO> findroute(HostelVO vo) {
		// TODO Auto-generated method stub
		return routeService.findrouteByhotel(vo);
	}

	@Override
	public TbBizRouteBO findoneRoute(RouteVO vo) {
		// TODO Auto-generated method stub
		return routeService.find(vo.getRouteid());
	}

	@Override
	public void updateStaus(RouteVO vo) {
		// TODO Auto-generated method stub
		routeService.updateStatus(vo);
	}

	@Override
	public RouteVO updateRouteCheckStatus(RouteVO vo) {
		// TODO Auto-generated method stub
		return routeService.updateRouteCheckStatus(vo);
	}
	
	@Override
	public RouteVO updateRouteType(RouteVO vo) {
		// TODO Auto-generated method stub
		return routeService.updateRouteType(vo);
	}

	@Override
	public double findRouteLeastPrice(RouteVO vo) {
		// TODO Auto-generated method stub
		return routeService.findRouteLeastPrice(vo);
	}

	@Override
	public RouteVO findrouteById(RouteVO vo) {
		// TODO Auto-generated method stub
		return routeService.findrouteByRouteId(vo);
	}

	@Override
	public HashMap<String, RouteVO> findRouteByStatus(RouteVO vo) {
		// TODO Auto-generated method stub
		return routeService.findRouteByStatus(vo);
	}

	@Override
	public List<RouteVO> findAllRouteByType(String typeId) {
		// TODO Auto-generated method stub
		List<TbBizRouteBO> list = routeService.findAllRouteByType(typeId);
		List<RouteVO> result = new ArrayList<RouteVO>();
		VOManager manager = new VOManager();
		for(TbBizRouteBO bo : list){
			result.add(manager.addroute(bo));
		}
		return result;
	}

	@Override
	public List<RouteVO> findAllOnSaleRoutes() {
		// TODO Auto-generated method stub
		HashMap<String, RouteVO> map = routeService.findAllRoutes();
		List<RouteVO> result = new ArrayList<RouteVO>();
		for(String r : map.keySet()){
			if(map.get(r).getStatus().equals("2")){
				result.add(map.get(r));
			}
		}
		return result;
	}
}