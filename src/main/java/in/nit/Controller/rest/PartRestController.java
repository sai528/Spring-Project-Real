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

import in.nit.model.Part;
import in.nit.service.IPartService;


	@RestController
	@RequestMapping("/rest/part")
	public class PartRestController {

		@Autowired
		private IPartService service;

		@PostMapping("/save")
		public ResponseEntity<String> savePart(@RequestBody Part part)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.savePart(part);
				resp=new ResponseEntity<String>("Part'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save Part",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllPart() {

			ResponseEntity<?> resp=null;
			try {
				List<Part> list=service.getAllParts();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<Part>>(list,HttpStatus.OK);
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
		public ResponseEntity<?> getOnePart(@RequestParam("pid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				Part part=service.getOnePartId(id);
				if(part!=null) {
					resp=new ResponseEntity<Part>(part,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("Part '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch Part",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deletePart(@RequestParam("pid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.DeletePart(id);
				resp=new ResponseEntity<String>("Part '"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Part '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updatePart(@RequestBody Part part)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updatePart(part);
				resp=new ResponseEntity<String>("Part '"+part.getPartId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Part '"+part.getPartId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}

