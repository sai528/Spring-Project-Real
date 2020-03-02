package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.dao.ISaleOrderDao;
import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService {

	@Autowired
	private ISaleOrderDao dao;

	@Override
	public Integer saveSaleOrder(SaleOrder so) {
		return dao.saveSaleOrder(so) ;
	}

	@Override
	public List<SaleOrder> getAllSaleOrders() {
		List<SaleOrder> list=dao.getAllSaleOrders();
		Collections.sort(list, (o1,o2)->o1.getSaleId()-o2.getSaleId());
		return list ;
	}

	@Override
	public void DeleteSaleOrder(Integer id) {
		dao.DeleteSaleOrder(id);
	}

	@Override
	public void updateSaleOrder(SaleOrder so) {
		dao.updateSaleOrder(so);
	}

	@Override
	public SaleOrder getOneSaleOrderId(Integer id) {
		dao.getOneSaleOrderId(id);
		return null;
	}

}
