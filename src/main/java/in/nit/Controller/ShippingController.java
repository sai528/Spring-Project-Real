package in.nit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.Shipping;
import in.nit.service.IShippingService;

@Controller
@RequestMapping("/shipping")
public class ShippingController
{
	@Autowired
	private IShippingService service;

	@RequestMapping("/register")
	public String shippingRegister(Model model)
	{
		model.addAttribute("shipping",new Shipping());
		return "shippingRegister";
	}

	@RequestMapping("/saveshipping")
	private String saveShipping(@ModelAttribute Shipping shipping,Model model)
	{
		Integer id=service.saveShipping(shipping);
		String message="Shipping'"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("shipping",new Shipping());
		return "shippingRegister";
	}
}
