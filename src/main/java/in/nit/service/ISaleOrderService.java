package in.nit.service;

import java.util.List;

import in.nit.model.SaleOrder;

public interface ISaleOrderService 
{
	Integer saveSaleOrder(SaleOrder so);
	List<SaleOrder> getAllSaleOrders();
	void DeleteSaleOrder(Integer id);
	void updateSaleOrder(SaleOrder so);
	SaleOrder getOneSaleOrderId(Integer id);
	public List<Object[]> getSaleIdAndSaleOrdCode();
	boolean isSaleOrderCodeExist(String ordCode);
}
