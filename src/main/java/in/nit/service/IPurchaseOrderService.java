package in.nit.service;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface IPurchaseOrderService
{
	Integer savePurchaseOrder(PurchaseOrder po);
	List<PurchaseOrder> getAllPurchaseOrders();
	void DeletePurchaseOrder(Integer id);
	void updatePurchaseOrder(PurchaseOrder po);
	PurchaseOrder getOnePurchaseOrderId(Integer id);


}
