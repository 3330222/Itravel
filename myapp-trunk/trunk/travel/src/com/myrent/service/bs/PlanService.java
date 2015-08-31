package com.myrent.service.bs;


import com.myrent.data.entity.TbBizTravelPlan;
import com.myrent.data.model.dao.DAO;
import com.myrent.vo.PlanVO;


public interface PlanService extends DAO<TbBizTravelPlan> {
	public void createplan(PlanVO vo);
}
