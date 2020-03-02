package in.nit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;

@Controller
@RequestMapping("/sale")
public class SaleOrderController
{
@Autowired
private ISaleOrderService service;

	@RequestMapping("/register")
	public String saleRegister(Model model)
	{
		model.addAttribute("saleOrder", new SaleOrder());
		return "saleOrderRegister";
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveSale(@ModelAttribute SaleOrder saleOrder,Model model)
	{
		Integer id=service.saveSaleOrder(saleOrder);
		String message="Sale'"+id+"'saved";
		model.addAttribute("message", message);
		return "saleOrderRegister";
	}
	
	@RequestMapping("/allsales")
	public String displayAllSales(Model model)
	{
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list", list);
		return "saleOrderData";
	}
	
	@RequestMapping("/delete")
	public String daleteSale(@RequestParam("saleid")Integer id,Model model)
	{
		service.DeleteSaleOrder(id);
		String message="sale'"+id+"'deleted";
		model.addAttribute("message", message);
		
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list", list);
		return "saleOrderData";
	}
	
	@RequestMapping("/edit")
	public String editSale(@RequestParam("saleId")Integer id,Model model)
	{
		SaleOrder saleOrder=service.getOneSaleOrderId(id);
		model.addAttribute("saleOrder",saleOrder);
		return "saleOrderEdit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateSale(@ModelAttribute SaleOrder saleOrder ,Model model)
	{
		service.updateSaleOrder(saleOrder);
		String message="Sale'"+saleOrder.getSaleId()+"'update";
		model.addAttribute("message", message);
		 
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list", list);
		return "saleOrderData";
	}
	
	@RequestMapping("/view")
	public String showOneSale(@RequestParam("saleid")Integer id,Model model)
	{
	  SaleOrder saleOrder=service.getOneSaleOrderId(id);
	  model.addAttribute("so", saleOrder);
	  return "saleOrderView";
	}
	
	
	
}
