package in.nit.service;

import java.util.List;

import in.nit.model.GoodsReceiveNote;

public interface IGoodsReceiveNoteService {

	Integer saveGoodsReceiveNote(GoodsReceiveNote om);
	List<GoodsReceiveNote> getAllGoodsReceiveNotes();
	void deleteGoodsReceiveNote(Integer id);
	GoodsReceiveNote getOneGoodsReceiveNoteId(Integer id);
	void updateGoodsReceiveNote(GoodsReceiveNote om);
}
