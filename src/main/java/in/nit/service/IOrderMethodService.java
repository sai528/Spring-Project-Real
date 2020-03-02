package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService
{
	Integer saveOrderMethod(OrderMethod om);
	List<OrderMethod> getAllOrderMethods();
	void deleteOrderMethod(Integer id);
	OrderMethod getOneOrderMethodId(Integer id);
	void updateOrderMethod(OrderMethod om);
	public List<Object[]> getOrderTypeCount();
}
