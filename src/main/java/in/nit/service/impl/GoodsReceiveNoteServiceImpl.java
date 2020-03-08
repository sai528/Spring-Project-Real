package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IGoodsReceiveNoteDao;
import in.nit.model.GoodsReceiveNote;
import in.nit.service.IGoodsReceiveNoteService;

@Service
public class GoodsReceiveNoteServiceImpl implements IGoodsReceiveNoteService {

	@Autowired
	private IGoodsReceiveNoteDao dao;
	
	@Override
	@Transactional
	public Integer saveGoodsReceiveNote(GoodsReceiveNote om) {
		return dao.saveGoodsReceiveNote(om);
	}

	@Override
	@Transactional(readOnly=true)
	public List<GoodsReceiveNote> getAllGoodsReceiveNotes() {
		List<GoodsReceiveNote> list=dao.getAllGoodsReceiveNotes();
		Collections.sort(list, (o1,o2)->o1.getGoodsId()-o2.getGoodsId());
		return list;	}

	@Override
	@Transactional
	public void deleteGoodsReceiveNote(Integer id) {
		dao.deleteGoodsReceiveNote(id);
	}

	@Override
	@Transactional(readOnly=true)
	public GoodsReceiveNote getOneGoodsReceiveNoteId(Integer id) {
		return dao.getOneGoodsReceiveNoteId(id);
	}

	@Override
	@Transactional
	public void updateGoodsReceiveNote(GoodsReceiveNote om) {
		dao.updateGoodsReceiveNote(om);
	}

}
