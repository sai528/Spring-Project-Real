package in.nit.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.service.IWhUserTypeService;
import in.nit.util.CommonUtil;
import in.nit.view.PurchaseOrderExcelView;
import in.nit.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController 
{
	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private IShipmentTypeService shipmentservice;
	
	@Autowired
	private IWhUserTypeService whuserservice;
	
	private void commonUi(Model model)
	{
		List<Object[]> shipList=shipmentservice.getShipIdAndShipCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);
		
		List<Object[]> usertypeList=whuserservice.getUserIdAndUserCode("Vendor");
		Map<Integer,String> usertypeMap=CommonUtil.convert(usertypeList);
		model.addAttribute("usertypeMap", usertypeMap);
	}
	
	@RequestMapping("/register")
	public String purchaseRegister(Model model)
	{
		model.addAttribute("purchaseOrder", new PurchaseOrder());
		commonUi(model);
		return "purchaseOrderRegister";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePurchase(@ModelAttribute PurchaseOrder purchaseOrder, Model model)
	{
		Integer id=service.savePurchaseOrder(purchaseOrder);
		String message="Purchase'"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("purchaseOrder", new PurchaseOrder());
		commonUi(model);
		return "purchaseOrderRegister";
	}

	@RequestMapping("/allpurchases")
	public String displayAllPurchases(Model model)
	{
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "purchaseOrderData";
	}
	
	@RequestMapping("/delete")
	public String deletePurchase(@RequestParam("purseid")Integer id,Model model)
	{
		service.DeletePurchaseOrder(id);
		String message="Purchase'"+id+"'deleted";
		model.addAttribute("message",message);
		
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "purchaseOrderData";
	}
	
	@RequestMapping("/edit")
	public String editPurchase(@RequestParam("purseid")Integer id, Model model)
	{
		PurchaseOrder purchaseOrder=service.getOnePurchaseOrderId(id);
		
		commonUi(model);
		model.addAttribute("purchaseOrder", purchaseOrder);
		
		return "purchaseOrderEdit";
	}
		
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePurchase(@ModelAttribute PurchaseOrder purchaseOrder,Model model)
	{
		service.updatePurchaseOrder(purchaseOrder);
	String message ="Purchase'"+purchaseOrder.getPurseId()+"'updated";
		model.addAttribute("message", message);
	
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "purchaseOrderData";
	}
	
	@RequestMapping("/view")
	public String showOnePurchase(@RequestParam("purseid")Integer id,Model model)
	{
		PurchaseOrder purchaseOrder=service.getOnePurchaseOrderId(id);
		model.addAttribute("po", purchaseOrder);
		return "purchaseOrderView";
	}
	
	@RequestMapping("/excel")
	/*
	 * public ModelAndView displayExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new PurchaseOrderExcelView());
	 * 
	 * List<PurchaseOrder> list=service.getAllPurchaseOrders(); m.addObject("list", list); return m;
	 */
	public ModelAndView displayExcel(@RequestParam(value="id", required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderExcelView());
		if(id==null) {
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list", list);
		}else
		{
			PurchaseOrder purchaseOrder=service.getOnePurchaseOrderId(id);
			m.addObject("list", Arrays.asList(purchaseOrder));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 *  public ModelAndView displayPdf() { ModelAndView m=new ModelAndView();
	 *m.setView(new PurchaseOrderPdfView()); List<PurchaseOrder> list=service.getAllPurchaseOrders();
	 *m.addObject("list", list); return m;
	 */
	 
	public ModelAndView displayPdf(@RequestParam (value="id",required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderPdfView());
		
		if(id==null) {
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list", list);
		}else
		{
			PurchaseOrder purchaseOrder=service.getOnePurchaseOrderId(id);
			m.addObject("list",Arrays.asList(purchaseOrder));
		}
		return m;
	}
	
	
	}
	

