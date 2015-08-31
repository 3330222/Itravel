package com.myrent.service.bsfc.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrent.service.bs.RefundService;
import com.myrent.service.bsfc.RefundServiceFacade;
import com.myrent.vo.OrderVO;
import com.myrent.vo.RefundVO;


@Service("refundServiceFacadeBean")
public class RefundServiceFacadeBean implements RefundServiceFacade{
	
	@Resource(name="refundServiceBean")
	private RefundService refundService;

	public RefundVO findRefundbyOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return refundService.findRefundbyOrder(vo);
	}

	@Override
	public void updateRefundStatus(RefundVO vo) {
		// TODO Auto-generated method stub
		refundService.updateRefundStatus(vo);
	}

}
