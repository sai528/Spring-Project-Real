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

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentTypeService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveShipment(@RequestBody ShipmentType shipmentType)
	{
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveShipmentType(shipmentType);
			resp=new ResponseEntity<String>("ShipmentType'"+id+"'saved",HttpStatus.CREATED);
		}catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to save ShipmentType",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}


	@GetMapping("/all")
	public ResponseEntity<?> getAllShipmentTypes() {

		ResponseEntity<?> resp=null;
		try {
			List<ShipmentType> list=service.getAllShipmentTypes();
			if(list!=null && !list.isEmpty()) {
				resp=new ResponseEntity<List<ShipmentType>>(list,HttpStatus.OK);
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
	public ResponseEntity<?> getOneShipmentType(@RequestParam("sid")Integer id)
	{
		ResponseEntity<?> resp=null;
		try {
			ShipmentType st=service.getOneShipmentTypeId(id);
			if(st!=null) {
				resp=new ResponseEntity<ShipmentType>(st,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("ShipmentType '"+id+"'not exist",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch ShipmentType",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteShipment(@RequestParam("sid")Integer id)
	{
		ResponseEntity<String> resp=null;
		try {
			service.deleteShipmentType(id);
			resp=new ResponseEntity<String>("shipment'"+id+"'deleted",HttpStatus.OK);	
		} catch (Exception e) {
			resp=new ResponseEntity<String>("ShipmentType '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateShipmentType(@RequestBody ShipmentType shipmentType)
	{
		ResponseEntity<String> resp=null;

		try {
			service.updateShipmentType(shipmentType);
			resp=new ResponseEntity<String>("ShipmentType '"+shipmentType.getShipId()+"' Updated",HttpStatus.RESET_CONTENT);			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("ShipmentType '"+shipmentType.getShipId()+"' not exist",HttpStatus.BAD_REQUEST);			
			e.printStackTrace();
		}
		return resp;
	}


}


