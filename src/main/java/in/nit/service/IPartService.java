package in.nit.service;

import java.util.List;

import in.nit.model.Part;

public interface IPartService 
{
	Integer savePart(Part pt);
	List<Part> getAllParts();
	void DeletePart(Integer id);
	void updatePart(Part pt);
	Part getOnePartId(Integer id);

}
