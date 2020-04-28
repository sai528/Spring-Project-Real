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

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;


	@RestController
	@RequestMapping("/rest/whuser")
	public class WhUserTypeRestController {

		@Autowired
		private IWhUserTypeService service;
		
		@PostMapping("/save")
		public ResponseEntity<String> saveWhUserType(@RequestBody WhUserType whUserType)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.saveWhUserType(whUserType);
				resp=new ResponseEntity<String>("WhUserType'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save WhUserType",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllWhUserTypes() {

			ResponseEntity<?> resp=null;
			try {
				List<WhUserType> list=service.displayAllWhUserTypes();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<WhUserType>>(list,HttpStatus.OK);
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
		public ResponseEntity<?> getOneWhUserType(@RequestParam("userid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				WhUserType wut=service.getOneWhUserTypeId(id);
				if(wut!=null) {
					resp=new ResponseEntity<WhUserType>(wut,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("WhUserType '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch WhUserType",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteWhUserType(@RequestParam("userid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.deleteWhUserById(id);
				resp=new ResponseEntity<String>("WhUserType'"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("WhUserType '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updateWhUserType(@RequestBody WhUserType whUserType)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updateWhUserType(whUserType);
				resp=new ResponseEntity<String>("WhUserType '"+whUserType.getUserId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("WhUserType '"+whUserType.getUserId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}

