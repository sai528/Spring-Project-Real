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

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;


	@RestController
	@RequestMapping("/rest/purchase")
	public class PurchaseOrderRestController {

		@Autowired
		private IPurchaseOrderService service;
		
		@PostMapping("/save")
		public ResponseEntity<String> savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.savePurchaseOrder(purchaseOrder);
				resp=new ResponseEntity<String>("PurchaseOrder'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save PurchaseOrder",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllPurchaseOrders() {

			ResponseEntity<?> resp=null;
			try {
				List<PurchaseOrder> list=service.getAllPurchaseOrders();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<PurchaseOrder>>(list,HttpStatus.OK);
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
		public ResponseEntity<?> getOnePurchaseOrder(@RequestParam("purseid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				PurchaseOrder po=service.getOnePurchaseOrderId(id);
				if(po!=null) {
					resp=new ResponseEntity<PurchaseOrder>(po,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("PurchaseOrder '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch PurchaseOrder",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deletePurchaseOrder(@RequestParam("purseid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.DeletePurchaseOrder(id);;
				resp=new ResponseEntity<String>("PurchaseOrder'"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("PurchaseOrder '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updatePurchaseOrder(purchaseOrder);
				resp=new ResponseEntity<String>("PurchaseOrder '"+purchaseOrder.getPurseId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("PurchaseOrder '"+purchaseOrder.getPurseId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}

