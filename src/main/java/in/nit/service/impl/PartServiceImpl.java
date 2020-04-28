package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
import in.nit.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private IPartDao dao;

	@Override
	@Transactional
	public Integer savePart(Part pt) {
		return dao.savePart(pt) ;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Part> getAllParts() {
		List<Part> list= dao.getAllParts();
		Collections.sort(list,(o1,o2)->o1.getPartId()-o2.getPartId());
		return list;
	}

	@Override
	@Transactional
	public void DeletePart(Integer id) {
		dao.DeletePart(id);
	}

	@Override
	@Transactional
	public void updatePart(Part pt) {
		dao.updatePart(pt);
	}

	@Override
	@Transactional(readOnly = true)
	public Part getOnePartId(Integer id) {
		return dao.getOnePartId(id);
	}
	
	
	 @Override
	 @Transactional(readOnly = true)
	 public boolean isPartCodeExist(String partCode) {
		 return dao.isPartCodeExist(partCode);
		 }
	

}
