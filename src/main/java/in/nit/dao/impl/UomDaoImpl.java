package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;


	@Override
	public Integer saveUom(Uom u) 
	{
		return (Integer)ht.save(u);
	}


	@Override
	public List<Uom> displayAllUoms() 
	{
		return ht.loadAll(Uom.class);
	}

	@Override
	public void deleteUomById(Integer id)
	{
		/* Uom uom=new Uom();
            uom.setUomId(id);
            ht.delete(uom);
               (or)
		 */
		ht.delete(new Uom(id));
	}

	@Override
	public Uom getOneUomId(Integer id)
	{
		return ht.get(Uom.class, id);
	}

	@Override
	public void updateUom(Uom uom) 
	{
		ht.update(uom);		
	}

	@Override
	public List<Object[]> getUomTypeCount() 
	{
		String hql="select uomType,count(uomType) from in.nit.model.Uom group by uomType";
		return (List<Object[]>)ht.find(hql);
	}

	@Override
	public List<Object[]> getUomIdAndUomMode() 
	{
		String hql=" select uomId,uomModel from " + Uom.class.getName();
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
}
