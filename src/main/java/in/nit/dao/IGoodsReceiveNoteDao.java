package in.nit.dao;

import java.util.List;

import in.nit.model.GoodsReceiveNote;


public interface IGoodsReceiveNoteDao {

	Integer saveGoodsReceiveNote(GoodsReceiveNote om);
	List<GoodsReceiveNote> getAllGoodsReceiveNotes();
	void deleteGoodsReceiveNote(Integer id);
	GoodsReceiveNote getOneGoodsReceiveNoteId(Integer id);
	void updateGoodsReceiveNote(GoodsReceiveNote om);
}
