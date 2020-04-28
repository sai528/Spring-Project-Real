package in.nit.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.service.IWhUserTypeService;
import in.nit.util.CommonUtil;
import in.nit.validator.SaleOrderValidator;
import in.nit.view.SaleOrderExcelView;
import in.nit.view.SaleOrderPdfView;

@Controller
@RequestMapping("/sale")
public class SaleOrderController
{
	@Autowired
	private ISaleOrderService service;

	@Autowired
	private IShipmentTypeService shipmentservice;

	@Autowired
	private IWhUserTypeService whuserservice;

	@Autowired
	private SaleOrderValidator validator;

	private void commonUi(Model model)
	{
		List<Object[]> shipList=shipmentservice.getShipIdAndShipCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);

		List<Object[]> usertypeList=whuserservice.getUserIdAndUserCode("Customer");
		Map<Integer,String> usertypeMap=CommonUtil.convert(usertypeList);
		model.addAttribute("usertypeMap", usertypeMap);
	}

	@RequestMapping("/register")
	public String saleRegister(Model model)
	{
		model.addAttribute("saleOrder", new SaleOrder());
		commonUi(model);
		return "saleOrderRegister";
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveSale(@ModelAttribute SaleOrder saleOrder,Errors errors,Model model)
	{
		validator.validate(saleOrder, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveSaleOrder(saleOrder);
			String message="Sale'"+id+"'saved";
			model.addAttribute("message", message);
			model.addAttribute("saleOrder", new SaleOrder());
		}else {
			model.addAttribute("message", "Please Check All Errors");
		}
		commonUi(model);
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
	public String editSale(@RequestParam("saleid")Integer id,Model model)
	{
		SaleOrder saleOrder=service.getOneSaleOrderId(id);
		model.addAttribute("saleOrder",saleOrder);
		commonUi(model);
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

	@RequestMapping("/excel")
	/*
	 * public ModelAndView showExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new SaleOrderExcelView()); List<SaleOrder>
	 * list=service.getAllSaleOrders(); m.addObject("list", list); return m;
	 */
	public ModelAndView showExcel(@RequestParam(value="id", required = false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderExcelView());

		if(id==null)
		{
			List<SaleOrder> list=service.getAllSaleOrders();
			m.addObject("list", list);
		}
		else {
			SaleOrder so=service.getOneSaleOrderId(id);
			m.addObject("list", Arrays.asList(so));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 * public ModelAndView showPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new SaleOrderPdfView()); List<SaleOrder>
	 * list=service.getAllSaleOrders(); m.addObject("list", list); return m;
	 */
	public ModelAndView showPdf(@RequestParam(value="id", required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderPdfView());
		if(id==null)
		{
			List<SaleOrder> list=service.getAllSaleOrders();
			m.addObject("list", list);	
		}
		else {
			SaleOrder so=service.getOneSaleOrderId(id);
			m.addObject("list",Arrays.asList(so));
		}
		return m;
	}

}

