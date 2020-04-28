package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao
{

	Integer saveShipmentType(ShipmentType st);
	List<ShipmentType> getAllShipmentTypes();
	void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentTypeId(Integer id);
	void updateShipmentType(ShipmentType st);
	public List<Object[]> getShipmentModeCount();
	
	public List<Object[]> getShipIdAndShipCode();
	
	boolean isShipCodeExist(String shipCode);
}
