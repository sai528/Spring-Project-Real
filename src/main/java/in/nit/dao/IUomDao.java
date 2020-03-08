package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface IUomDao 
{
	Integer saveUom(Uom u);
	List<Uom> displayAllUoms();
	void deleteUomById(Integer id);
	Uom getOneUomId(Integer id);
	void updateUom(Uom uom);
	public List<Object[]> getUomTypeCount();
	public List<Object[]> getUomIdAndUomMode();
}
