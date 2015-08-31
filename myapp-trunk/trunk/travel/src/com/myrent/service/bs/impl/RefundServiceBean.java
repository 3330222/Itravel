package com.myrent.service.bs.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizPaymentBO;
import com.myrent.data.entity.TbBizRefoundBO;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.RefundService;
import com.myrent.utils.UUIDUtil;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;
import com.myrent.vo.VOManager;


@Service("refundServiceBean")
public class RefundServiceBean extends DAOImpl<TbBizRefoundBO> implements
RefundService{

	@Override
	public RefundVO findRefundbyOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		TbBizRefoundBO bo=find(vo.getOrderid());
		VOManager vm=new VOManager();
		RefundVO rVo=vm.getRefundVO(bo);
		return rVo;
	}

	@Override
	public void updateRefundStatus(RefundVO vo) {
		// TODO Auto-generated method stub
		TbBizRefoundBO bo=find(vo.getRefundId());
		bo.setRefoundReason(vo.getRefundReason());
		bo.setRefoundStatusCd(vo.getRefundStatus());
		update(bo);
	}

	@Override
	public void createRefund(RefundVO vo, TbBizPaymentBO bo) {
		// TODO Auto-generated method stub
		TbBizRefoundBO refund = new TbBizRefoundBO();
		refund.setPayment(bo);
		refund.setRefoundAmt(vo.getRefundAmount());
		refund.setRefoundId(vo.getOrderId());
		refund.setRefoundReason(vo.getRefundReason());
		refund.setRefoundStatusCd("1");
		Timestamp dtime = new Timestamp(System.currentTimeMillis());
		refund.setRefoundTime(dtime);
		em.persist(refund);
	}

}
