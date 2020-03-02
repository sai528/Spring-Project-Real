package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer)ht.save(st);
	}
	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public void deleteShipmentType(Integer id) {

		/* ShipmentType st=new ShipmentType();
		st.setShipId(id);
		ht.delete(st);
		   (or)
		 */
		ht.delete(new ShipmentType(id));
	}

	@Override
	public ShipmentType getOneShipmentTypeId(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		ht.update(st);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getShipmentModeCount()
	{
		String hql="select shipMode,count(shipMode) from in.nit.model.ShipmentType group by shipMode";
		return (List<Object[]>)ht.find(hql);
	}
}
