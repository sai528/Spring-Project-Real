package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType st)
	{
		return dao.saveShipmentType(st);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() 
	{
		List<ShipmentType> list=dao.getAllShipmentTypes();
		Collections.sort(list,(o1,o2)->o1.getShipId()-o2.getShipId());
		return list;
	}
	@Override
	@Transactional
	public void deleteShipmentType(Integer id)
	{
		dao.deleteShipmentType(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentTypeId(Integer id) {

		return dao.getOneShipmentTypeId(id);
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType st) {
		dao.updateShipmentType(st);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getShipmentModeCount() {
		return dao.getShipmentModeCount();
	}
}
