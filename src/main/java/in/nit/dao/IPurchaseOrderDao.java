package in.nit.dao;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface IPurchaseOrderDao 
{
	Integer savePurchaseOrder(PurchaseOrder po);
	List<PurchaseOrder> getAllPurchaseOrders();
	void DeletePurchaseOrder(Integer id);
	void updatePurchaseOrder(PurchaseOrder po);
	PurchaseOrder getOnePurchaseOrderId(Integer id);
	public List<Object[]> getpurseIdAndOrdCode();

}
