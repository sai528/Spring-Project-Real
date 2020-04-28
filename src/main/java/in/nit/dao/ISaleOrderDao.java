package in.nit.dao;

import java.util.List;

import in.nit.model.SaleOrder;

public interface ISaleOrderDao {
	Integer saveSaleOrder(SaleOrder so);
	List<SaleOrder> getAllSaleOrders();
	void DeleteSaleOrder(Integer id);
	void updateSaleOrder(SaleOrder so);
	SaleOrder getOneSaleOrderId(Integer id);
	public List<Object[]> getSaleIdAndSaleOrdCode();
	boolean isSaleOrderCodeExist(String ordCode);
}
