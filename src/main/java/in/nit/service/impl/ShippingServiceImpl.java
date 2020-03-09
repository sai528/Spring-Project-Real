package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShippingDao;
import in.nit.model.Shipping;
import in.nit.service.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired
	private IShippingDao dao;

	@Override
	@Transactional
	public Integer saveShipping(Shipping si) {
		return dao.saveShipping(si) ;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Shipping> getAllShippings() {
		List<Shipping> list=dao.getAllShippings();
		Collections.sort(list,(o1,o2)->o1.getShippingId()-o2.getShippingId());
		return list;
	}

	@Override
	public void deleteShipping(Integer id) {
		dao.deleteShipping(id);
	}

	@Override
	public Shipping getOneShippingId(Integer id) {
		return dao.getOneShippingId(id);
	}

	@Override
	public void updateShipping(Shipping si) {
		dao.updateShipping(si);
	}

}
