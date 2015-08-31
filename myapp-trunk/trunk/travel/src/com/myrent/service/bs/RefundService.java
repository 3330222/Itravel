package com.myrent.service.bs;

import java.util.List;

import com.myrent.data.entity.TbBizPaymentBO;
import com.myrent.data.entity.TbBizRefoundBO;
import com.myrent.data.model.dao.DAO;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;

public interface RefundService extends DAO<TbBizRefoundBO> {
	public RefundVO findRefundbyOrder(OrderVO vo);
	public void updateRefundStatus(RefundVO vo);
	public void createRefund(RefundVO vo, TbBizPaymentBO bo);
}
