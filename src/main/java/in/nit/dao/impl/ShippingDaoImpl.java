package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShippingDao;
import in.nit.model.Shipping;

@Repository
public class ShippingDaoImpl implements IShippingDao {

	@Autowired
	public HibernateTemplate ht;

	@Override
	public Integer saveShipping(Shipping si) {
		return (Integer)ht.save(si);
	}

	@Override
	public List<Shipping> getAllShippings() {
		return ht.loadAll(Shipping.class);
	}

	@Override
	public void deleteShipping(Integer id) {

		ht.delete(new Shipping(id));
	}

	@Override
	public Shipping getOneShippingId(Integer id) {
		return ht.get(Shipping.class, id);
	}

	@Override
	public void updateShipping(Shipping si) {
		ht.update(si);
	}

}
