package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;

	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType wut) {
		return dao.saveWhUserType(wut);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> displayAllWhUserTypes()
	{
		List<WhUserType> list=dao.displayAllWhUserTypes();
		Collections.sort(list, (o1,o2)->o1.getUserId()-o2.getUserId());
		return  list;
	}

	@Override
	@Transactional
	public void deleteWhUserById(Integer id) {
		dao.deleteWhUserById(id);	
	}
	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneWhUserTypeId(Integer id) {
		return dao.getOneWhUserTypeId(id);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType wut) {
		dao.updateWhUserType(wut);	
	}

	@Override
	public List<Object[]> getWhUserTypeCount() {
		return dao.getWhUserTypeCount();
	}

	@Override
	public List<Object[]> getUserIdAndUserCode(String userType) {
		return dao.getUserIdAndUserCode(userType);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUserCodeExist(String userCode) {
		return dao.isUserCodeExist(userCode);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUserEmailExist(String userEmail) {
		return dao.isUserEmailExist(userEmail);
	}
	
	@Override
	@Transactional(readOnly=true)
	public boolean isUserContactExist(Long userContact) {
		return dao.isUserContactExist(userContact);
	}
	
	@Override
	@Transactional(readOnly=true)
	public boolean isIdNumberExist(Integer idNumber) {
		return dao.isIdNumberExist(idNumber);
	}
}
