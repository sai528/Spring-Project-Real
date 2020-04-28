package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPurchaseOrderDao;
import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;

	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return dao.savePurchaseOrder(po);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> list=dao.getAllPurchaseOrders();
		Collections.sort(list, (o1,o2)->o1.getPurseId()-o2.getPurseId());
		return list;
	}

	@Override
	@Transactional
	public void DeletePurchaseOrder(Integer id) {
		dao.DeletePurchaseOrder(id);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {
		dao.updatePurchaseOrder(po);
	}

	@Override
	@Transactional(readOnly = true)
	public PurchaseOrder getOnePurchaseOrderId(Integer id) {
		return dao.getOnePurchaseOrderId(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getpurseIdAndOrdCode() {

		return dao.getpurseIdAndOrdCode();
	}

	@Override
	public boolean isPurchaseOrderCodeExist(String ordCode) {
		return dao.isPurchaseOrderCodeExist(ordCode);
	}
}
