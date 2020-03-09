package in.nit.service;

import java.util.List;

import in.nit.model.Shipping;

public interface IShippingService
{
	Integer saveShipping(Shipping si);
	List<Shipping> getAllShippings();
	void deleteShipping(Integer id);
	Shipping getOneShippingId(Integer id);
	void updateShipping(Shipping si);

}
