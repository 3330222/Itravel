package com.myrent.service.bsfc;

import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;

public interface RefundServiceFacade {
	public RefundVO findRefundbyOrder(OrderVO vo);
	public void updateRefundStatus(RefundVO vo);
}
