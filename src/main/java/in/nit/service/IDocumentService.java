package in.nit.service;

import java.util.List;

import in.nit.model.Document;

public interface IDocumentService {

	public Integer saveDocument(Document d);
	public List<Object[]> getFileIdAndNames();
	public Document getOneDocument(Integer id);
}
