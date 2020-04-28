package in.nit.Controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.GoodsReceiveNote;
import in.nit.service.IGoodsReceiveNoteService;


	@RestController
	@RequestMapping("/rest/goods")
	public class GoodsReceiveNoteRestController {

		@Autowired
		private IGoodsReceiveNoteService service;
		
		@PostMapping("/save")
		public ResponseEntity<String> saveGoodsReceiveNote(@RequestBody GoodsReceiveNote goodsReceiveNote)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.saveGoodsReceiveNote(goodsReceiveNote);
				resp=new ResponseEntity<String>("GoodsReceiveNote'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save GoodsReceiveNote",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllGoodsReceiveNotes() {

			ResponseEntity<?> resp=null;
			try {
				List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<GoodsReceiveNote>>(list,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>(HttpStatus.NO_CONTENT);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/one")
		public ResponseEntity<?> getOneGoodsReceiveNote(@RequestParam("goodsid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				GoodsReceiveNote grn=service.getOneGoodsReceiveNoteId(id);
				if(grn!=null) {
					resp=new ResponseEntity<GoodsReceiveNote>(grn,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("GoodsReceiveNote '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch GoodsReceiveNote",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteGoodsReceiveNote(@RequestParam("goodsid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.deleteGoodsReceiveNote(id);;
				resp=new ResponseEntity<String>("GoodsReceiveNote'"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("GoodsReceiveNote '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updateGoodsReceiveNote(@RequestBody GoodsReceiveNote goodsReceiveNote)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updateGoodsReceiveNote(goodsReceiveNote);
				resp=new ResponseEntity<String>("GoodsReceiveNote '"+goodsReceiveNote.getGoodsId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("GoodsReceiveNote '"+goodsReceiveNote.getGoodsId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}

