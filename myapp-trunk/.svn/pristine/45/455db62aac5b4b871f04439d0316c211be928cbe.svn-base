package com.myrent.service.bsfc;

import java.util.HashMap;
import java.util.List;

import com.myrent.data.entity.TbBizRouteBO;
import com.myrent.data.model.service.FacadeService;
import com.myrent.vo.HostelVO;
import com.myrent.vo.RouteVO;

public interface RouteServiceFacade extends FacadeService{
	public void create(RouteVO vo);
    public void update();
    public void delete(RouteVO vo);
    public TbBizRouteBO findoneRoute(RouteVO vo);
    public HashMap<String, RouteVO> findAllRoutes();
    public List<RouteVO> findAllOnSaleRoutes();
	public HashMap<String, RouteVO> findroute(HostelVO vo);
	public List<RouteVO> findAllRouteByType(String typeId);
	public void updateStaus(RouteVO vo);
	public RouteVO updateRouteCheckStatus(RouteVO vo);
	public RouteVO updateRouteType(RouteVO vo);
	public double findRouteLeastPrice(RouteVO vo);
	public RouteVO findrouteById(RouteVO vo);
	public HashMap<String, RouteVO> findRouteByStatus(RouteVO vo);
	
}
