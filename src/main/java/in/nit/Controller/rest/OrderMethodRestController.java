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

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;




	@RestController
	@RequestMapping("/rest/order")
	public class OrderMethodRestController {

		@Autowired
		private IOrderMethodService service;

		@PostMapping("/save")
		public ResponseEntity<String> saveOrderMethod(@RequestBody OrderMethod orderMethod)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.saveOrderMethod(orderMethod);
				resp=new ResponseEntity<String>("OrderMethod'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save OrderMethod",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllOrderMethods() {

			ResponseEntity<?> resp=null;
			try {
				List<OrderMethod> list=service.getAllOrderMethods();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<OrderMethod>>(list,HttpStatus.OK);
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
		public ResponseEntity<?> getOneOrderMethod(@RequestParam("ordid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				OrderMethod om=service.getOneOrderMethodId(id);
				if(om!=null) {
					resp=new ResponseEntity<OrderMethod>(om,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("OrderMethod '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch OrderMethod",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteOrderMethod(@RequestParam("ordid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.deleteOrderMethod(id);
				resp=new ResponseEntity<String>("Order Method '"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("OrderMethod '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updateOrderMethod(@RequestBody OrderMethod orderMethod)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updateOrderMethod(orderMethod);
				resp=new ResponseEntity<String>("orderMethod '"+orderMethod.getOrdId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("orderMethod '"+orderMethod.getOrdId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}
