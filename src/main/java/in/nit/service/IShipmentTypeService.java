package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService
{
	Integer saveShipmentType(ShipmentType st);
	List<ShipmentType> getAllShipmentTypes();
	void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentTypeId(Integer id);
	void updateShipmentType(ShipmentType st);
	public List<Object[]> getShipmentModeCount();
}
