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

import in.nit.model.Shipping;
import in.nit.service.IShippingService;


	@RestController
	@RequestMapping("/rest/shipping")
	public class ShippingRestController {

		@Autowired
		private IShippingService service;
		
		@PostMapping("/save")
		public ResponseEntity<String> saveShipping(@RequestBody Shipping shipping)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.saveShipping(shipping);
				resp=new ResponseEntity<String>("Shipping'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save Shipping",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllShippings() {

			ResponseEntity<?> resp=null;
			try {
				List<Shipping> list=service.getAllShippings();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<Shipping>>(list,HttpStatus.OK);
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
		public ResponseEntity<?> getOneShipping(@RequestParam("shippingid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				Shipping shipping=service.getOneShippingId(id);
				if(shipping!=null) {
					resp=new ResponseEntity<Shipping>(shipping,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("Shipping '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch Shipping",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteShipping(@RequestParam("shippingid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.deleteShipping(id);;
				resp=new ResponseEntity<String>("Shipping'"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Shipping '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updateShipping(@RequestBody Shipping shipping)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updateShipping(shipping);;
				resp=new ResponseEntity<String>("Shipping '"+shipping.getShippingId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Shipping '"+shipping.getShippingId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}

