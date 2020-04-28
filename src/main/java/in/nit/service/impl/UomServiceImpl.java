package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;

	@Override
	@Transactional
	public Integer saveUom(Uom u)
	{
		return dao.saveUom(u);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> displayAllUoms()
	{
		List<Uom> list=dao.displayAllUoms();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
	}

	@Override
	@Transactional
	public void deleteUomById(Integer id) 
	{
		dao.deleteUomById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Uom getOneUomId(Integer id) {
		return dao.getOneUomId(id);
	}

	@Override
	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);		
	}

	@Override

	public List<Object[]> getUomTypeCount() {
		return dao.getUomTypeCount();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getUomIdAndUomMode() {
		return dao.getUomIdAndUomMode();
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUomModelExist(String uomModel) {
		return dao.isUomModelExist(uomModel);
	}
}
