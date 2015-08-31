package com.myrent.service.bs.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizTravelPlan;
import com.myrent.data.entity.TbCsmUserBO;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.PlanService;
import com.myrent.utils.UUIDUtil;
import com.myrent.vo.PlanVO;


@Service("planServiceBean")
public class PlanServiceBean  extends DAOImpl<TbBizTravelPlan> implements PlanService
{

	@SuppressWarnings("deprecation")
	@Override
	public void createplan(PlanVO vo) {
		// TODO Auto-generated method stub
		TbBizTravelPlan plan=new TbBizTravelPlan();
		plan.setAdultsCount(vo.getAdult());
		plan.setChildrenCount(vo.getChild());
		plan.setDaySupplementDescription(vo.getDaysupplement());
		plan.setPersonSupplementDescription(vo.getPersonsupplement());
		plan.setDestination(vo.getDestination());
		plan.setPlanStatusCd("1");
		plan.setStartDate(vo.getTraveldate());
		plan.setTravelDays(Integer.parseInt(vo.getTraveldays()));
		plan.setPlanId(UUIDUtil.generateUUID());
		TbCsmUserBO user=new TbCsmUserBO();
		user.setUserId(vo.getUser().getUserId());
		plan.setCreateUser(user);
		save(plan);
	}

}
