package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IDocumentDao;
import in.nit.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer saveDocument(Document d) {
		return (Integer)ht.save(d);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getFileIdAndNames() 
	{
		String hql="select fileId ,fileName from in.nit.model.Document";
		return (List<Object[]>) ht.find(hql);
	}

@Override
public Document getOneDocument(Integer id) {
	return ht.get(Document.class, id);
}

}
