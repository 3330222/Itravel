package com.myrent.service.bs.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.myrent.data.entity.TbBizPaymentBO;
import com.myrent.data.model.dao.impl.DAOImpl;
import com.myrent.service.bs.PaymentService;

@Service("paymentServiceBean")
public class PaymentServiceBean extends DAOImpl<TbBizPaymentBO> implements PaymentService{

	@Override
	public List<TbBizPaymentBO> findPaymentByOrderId(String id) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("select o from TbBizPaymentBO o where order.orderId = ?1");
		query.setParameter("1", id);
		return query.getResultList();
	}
}
