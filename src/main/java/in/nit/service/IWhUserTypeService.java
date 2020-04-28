package in.nit.service;

import java.util.List;

import in.nit.model.WhUserType;

public interface IWhUserTypeService {

	Integer saveWhUserType(WhUserType wut);
	List<WhUserType> displayAllWhUserTypes();
	void deleteWhUserById(Integer id);
	WhUserType getOneWhUserTypeId(Integer id);
	void updateWhUserType(WhUserType wut);
	public List<Object[]> getWhUserTypeCount();

	public List<Object[]> getUserIdAndUserCode(String userType);

	boolean isUserCodeExist(String userCode);
	boolean isUserEmailExist(String userEmail);
	boolean isUserContactExist(Long userContact);
	boolean isIdNumberExist(Integer idNumber);
}
