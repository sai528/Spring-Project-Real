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

import in.nit.model.Shipping;
import in.nit.service.ISaleOrderService;
import in.nit.service.IShippingService;
import in.nit.util.CommonUtil;
import in.nit.view.ShippingExcelView;
import in.nit.view.ShippingPdfView;

@Controller
@RequestMapping("/shipping")
public class ShippingController
{
	@Autowired
	private IShippingService service;

	@Autowired
	private ISaleOrderService saleOrderService;

	public void commonUi(Model model)
	{
		List<Object[]> saleOrdCodeList=saleOrderService.getSaleIdAndSaleOrdCode();
		Map<Integer,String> saleOrdCodeMap=CommonUtil.convert(saleOrdCodeList);
		model.addAttribute("saleOrdCodeMap", saleOrdCodeMap);
	}

	@RequestMapping("/register")
	public String shippingRegister(Model model)
	{
		model.addAttribute("shipping",new Shipping());
		commonUi(model);
		return "shippingRegister";
	}

	@RequestMapping(value="/save" , method=RequestMethod.POST)
	private String saveShipping(@ModelAttribute Shipping shipping,Model model)
	{
		Integer id=service.saveShipping(shipping);
		String message="Shipping'"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("shipping",new Shipping());
		commonUi(model);
		return "shippingRegister";
	}

	@RequestMapping("/allshippings")
	public String getAllShippings(Model model)
	{
		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list", list);
		return "shippingData";
	}


	@RequestMapping("/edit")
	public String editShipping(@RequestParam("shippingid")Integer id,Model model)
	{
		Shipping shipping=service.getOneShippingId(id);
		model.addAttribute("shipping", shipping);
		commonUi(model);
		return "shippingEdit";
	}

	@RequestMapping("/delete")
	public String deleteShipping(@RequestParam("shippingid")Integer id,Model model)
	{
		service.deleteShipping(id);
		String message="Shipping"+id+"deleted";
		model.addAttribute("message", message);

		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list", list);
		return "shippingData";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateShipping(@ModelAttribute Shipping shipping,Model model)
	{
		service.updateShipping(shipping);
		String message="Shipping"+shipping.getShippingId()+"updated";
		model.addAttribute("message", message);

		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list", list);
		return "shippingData";
	}
	@RequestMapping("/view")
	public String viewShipping(@RequestParam("shippingid")Integer id,Model model)
	{
		Shipping shipping=service.getOneShippingId(id);
		model.addAttribute("sp", shipping);
		return "shippingView";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id" , required =false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingExcelView());

		if(id==null)
		{
			List<Shipping> list=service.getAllShippings();
			m.addObject("list", list);
		}
		else
		{
			Shipping sp=service.getOneShippingId(id);
			m.addObject("list", Arrays.asList(sp));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="id" , required = false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingPdfView());

		if(id==null)
		{
			List<Shipping> list=service.getAllShippings();
			m.addObject("list", list);
		}
		else {
			Shipping shipping=service.getOneShippingId(id);
			m.addObject("list", Arrays.asList(shipping));
		}
		return m;
	}
}




