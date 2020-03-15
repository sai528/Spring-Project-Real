package in.nit.dao;

import java.util.List;

import in.nit.model.Shipping;

public interface IShippingDao 
{
	Integer saveShipping(Shipping si);
	List<Shipping> getAllShippings();
	void deleteShipping(Integer id);
	Shipping getOneShippingId(Integer id);
	void updateShipping(Shipping si);
	
}
