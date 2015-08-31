package com.myrent.service.bs;

import java.util.HashMap;
import java.util.List;

import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.model.dao.DAO;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;

public interface RouteService extends DAO<TbBizRouteBO> {
	
	public RouteVO createroute(RouteVO vo);
	public HashMap<String,RouteVO> findAllRoutes() ;
	public List<TbBizRouteBO> findAllRouteByType(String routetypeid);
	public HashMap<String, RouteVO> findrouteByhotel(HostelVO vo);
	public void updateStatus(RouteVO vo);
	public void deleterecode(RouteVO vo);
	public RouteVO updateRouteCheckStatus(RouteVO vo);
	public RouteVO updateRouteType(RouteVO vo);
	public double findRouteLeastPrice(RouteVO vo);
	public RouteVO findrouteByRouteId(RouteVO vo);
	public HashMap<String, RouteVO> findRouteByStatus(RouteVO vo);
}
