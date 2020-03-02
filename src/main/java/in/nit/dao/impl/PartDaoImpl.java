package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartDao;
import in.nit.model.Part;

@Repository
public class PartDaoImpl implements IPartDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePart(Part pt) {
		return (Integer) ht.save(pt);
	}

	@Override
	public List<Part> getAllParts() {
		return ht.loadAll(Part.class);
	}

	@Override
	public void DeletePart(Integer id) {
		/*
		 * Part pt=new Part(); 
		 * pt.setPartId(id); 
		 * ht.delete(pt);
		 * (or)
		 */
		ht.delete(new Part(id));
	}

	@Override
	public void updatePart(Part pt) {
		ht.update(pt);
	}

	@Override
	public Part getOnePartId(Integer id) {
		return ht.get(Part.class, id);
	}

}
