package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IGoodsReceiveNoteDao;
import in.nit.model.GoodsReceiveNote;

@Repository
public class GoodsReceiveNoteDaoImpl implements IGoodsReceiveNoteDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveGoodsReceiveNote(GoodsReceiveNote om) {
		return (Integer)ht.save(om) ;
	}

	@Override
	public List<GoodsReceiveNote> getAllGoodsReceiveNotes() {
		return ht.loadAll(GoodsReceiveNote.class);
	}

	@Override
	public void deleteGoodsReceiveNote(Integer id) {
		/*
		 * GoodsReceiveNote grn=new GoodsReceiveNote(); grn.setGoodsId(id);
		 * ht.delete(grn);
		 *  (or)
		 */
		ht.delete(new GoodsReceiveNote(id));
	}

	@Override
	public GoodsReceiveNote getOneGoodsReceiveNoteId(Integer id) {
		return ht.get(GoodsReceiveNote.class, id);
	}

	@Override
	public void updateGoodsReceiveNote(GoodsReceiveNote om) {
		ht.update(om);
	}

}
