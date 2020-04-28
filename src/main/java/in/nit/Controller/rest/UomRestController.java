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

import in.nit.model.Uom;
import in.nit.service.IUomService;



@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveShipment(@RequestBody Uom uom)
	{
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveUom(uom);
			resp=new ResponseEntity<String>("Uom'"+id+"'saved",HttpStatus.CREATED);
		}catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to save Uom",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}


	@GetMapping("/all")
	public ResponseEntity<?> getAllUoms() {

		ResponseEntity<?> resp=null;
		try {
			List<Uom> list=service.displayAllUoms();
			if(list!=null && !list.isEmpty()) {
				resp=new ResponseEntity<List<Uom>>(list,HttpStatus.OK);
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
	public ResponseEntity<?> getOneUom(@RequestParam ("uomid")Integer id)
	{
		ResponseEntity<?> resp=null;
		try {
			Uom uom=service.getOneUomId(id);
			if(uom!=null) {
				resp=new ResponseEntity<Uom>(uom,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("Uom '"+id+"'not exist",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch Uom",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUom(@RequestParam("uomid")Integer id)
	{
		ResponseEntity<String> resp=null;
		try {
			service.deleteUomById(id);
			resp=new ResponseEntity<String>("Uom'"+id+"'deleted",HttpStatus.OK);	
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Uom '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUom(@RequestBody Uom uom)
	{
		ResponseEntity<String> resp=null;

		try {
			service.updateUom(uom);
			resp=new ResponseEntity<String>("Uom '"+uom.getUomId()+"' Updated",HttpStatus.RESET_CONTENT);			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Uom '"+uom.getUomId()+"' not exist",HttpStatus.BAD_REQUEST);			
			e.printStackTrace();
		}
		return resp;
	}


}



