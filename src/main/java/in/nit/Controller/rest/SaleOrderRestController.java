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

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;


	@RestController
	@RequestMapping("/rest/sale")
	public class SaleOrderRestController {

		@Autowired
		private ISaleOrderService service;

		@PostMapping("/save")
		public ResponseEntity<String> saveSaleOrder(@RequestBody SaleOrder saleOrder)
		{
			ResponseEntity<String> resp=null;
			try {
				Integer id=service.saveSaleOrder(saleOrder);
				resp=new ResponseEntity<String>("SaleOrder'"+id+"'saved",HttpStatus.CREATED);
			}catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to save SaleOrder",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}


		@GetMapping("/all")
		public ResponseEntity<?> getAllSaleOrders() {

			ResponseEntity<?> resp=null;
			try {
				List<SaleOrder> list=service.getAllSaleOrders();
				if(list!=null && !list.isEmpty()) {
					resp=new ResponseEntity<List<SaleOrder>>(list,HttpStatus.OK);
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
		public ResponseEntity<?> getOneSaleOrder(@RequestParam("saleid")Integer id)
		{
			ResponseEntity<?> resp=null;
			try {
				SaleOrder so=service.getOneSaleOrderId(id);
				if(so!=null) {
					resp=new ResponseEntity<SaleOrder>(so,HttpStatus.OK);
				}else {
					resp=new ResponseEntity<String>("SaleOrder '"+id+"'not exist",HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch SaleOrder",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@DeleteMapping("/delete")
		public ResponseEntity<String> deleteSaleOrder(@RequestParam("saleid")Integer id)
		{
			ResponseEntity<String> resp=null;
			try {
				service.DeleteSaleOrder(id);;
				resp=new ResponseEntity<String>("SaleOrder'"+id+"'deleted",HttpStatus.OK);	
			} catch (Exception e) {
				resp=new ResponseEntity<String>("SaleOrder '"+id+"'not exist",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
			return resp;
		}

		@PutMapping("/update")
		public ResponseEntity<String> updateSaleOrder(@RequestBody SaleOrder saleOrder)
		{
			ResponseEntity<String> resp=null;

			try {
				service.updateSaleOrder(saleOrder);
				resp=new ResponseEntity<String>("SaleOrder '"+saleOrder.getSaleId()+"' Updated",HttpStatus.RESET_CONTENT);			
			} catch (Exception e) {
				resp=new ResponseEntity<String>("SaleOrder '"+saleOrder.getSaleId()+"' not exist",HttpStatus.BAD_REQUEST);			
				e.printStackTrace();
			}
			return resp;
		}


	}
