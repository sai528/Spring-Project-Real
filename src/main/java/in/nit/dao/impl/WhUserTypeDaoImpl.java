package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType wut) {
		return (Integer)ht.save(wut); 
	}
	@Override
	public List<WhUserType> displayAllWhUserTypes() 
	{
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public void deleteWhUserById(Integer id) 
	{

		ht.delete(new WhUserType(id));
	}
	@Override
	public WhUserType getOneWhUserTypeId(Integer id) {

		return ht.get(WhUserType.class, id);
	}

	@Override
	public void updateWhUserType(WhUserType wut) {
		ht.update(wut);		
	}

	@Override
	public List<Object[]> getWhUserTypeCount() {
		String hql="select userType,count(userType) from in.nit.model.WhUserType group by userType";

		return (List<Object[]>) ht.find(hql);
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public List<Object[]> getUserIdAndUserCode(String userType) {
		String hql="select userId,userCode from in.nit.model.WhUserType where userType=?0";

		List<Object[]> list=(List<Object[]>) ht.find(hql, userType);
		return list;
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isUserCodeExist(String userCode) {
		boolean flag=false;
		String hql="select count(userCode) from in.nit.model.WhUserType where userCode=?0";
		List<Long> list=(List<Long>) ht.find(hql, userCode);
		if (list!=null && !list.isEmpty())
		{
			long count=list.get(0);
			if (count==0) {
				flag=false;
			}else {
				flag=true;

			}
		}
		return flag;
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isUserEmailExist(String userEmail) {
		boolean flag=false;
		String hql="select count(userEmail) from in.nit.model.WhUserType where userEmail=?0";
		List<Long> list=(List<Long>) ht.find(hql, userEmail);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) {
				flag=false;
			}else {
				flag=true;
			}
		}
		return flag;
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isUserContactExist(Long userContact) {
		boolean flag=false;

		String hql="select count(userContact) from in.nit.model.WhUserType where userContact like '%"+userContact+"' or userContact like '"+userContact+"'";

		List<Long> list=(List<Long>) ht.find(hql);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) {
				flag=false;
			}else {
				flag=true;
			}
		}
		return flag;
	}
	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isIdNumberExist(Integer idNumber) {
		boolean flag=false;
		String hql="select count(idNumber) from in.nit.model.WhUserType where idNumber=?0";
		List<Long> list=(List<Long>) ht.find(hql, idNumber);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) {
				flag=false;
			}else {
				flag=true;
			}
		}
		return flag;
	}
}
