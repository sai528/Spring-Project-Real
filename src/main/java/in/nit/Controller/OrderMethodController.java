package in.nit.Controller;

import java.util.List;
import java.util.Arrays;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
import in.nit.util.OrderMethodUtil;
import in.nit.validator.OrderMethodValidator;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;

	@Autowired
	private OrderMethodUtil util;

	@Autowired
	private ServletContext context;

	@Autowired
	private OrderMethodValidator validator;

	@RequestMapping("/register")
	public String showRegPage(Model model)
	{
		model.addAttribute("orderMethod",new OrderMethod());
		return "orderMethodRegister";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,Errors errors,Model model)
	{
		validator.validate( orderMethod, errors);
		if(!errors.hasErrors()) {

			Integer id=service.saveOrderMethod(orderMethod);
			String message="OrderMethod'"+id+"'Saved";
			model.addAttribute("orderMethod", new OrderMethod());
			model.addAttribute("message",message);
		}else {
			model.addAttribute("message","please check all errors");
		}
		return "orderMethodRegister";
	}

	@RequestMapping("/allorders")
	public String displayAllOrders(Model model)
	{
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "orderMethodData";
	}

	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("ordid")Integer id,Model model)
	{
		service.deleteOrderMethod(id);
		String message="OrderMethod'"+id+"'Deleted";
		model.addAttribute("message",message);

		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "orderMethodData";
	}

	@RequestMapping("/edit")
	public String editOrderMethod(@RequestParam("ordid")Integer id, Model model)
	{
		OrderMethod orderMethod=service.getOneOrderMethodId(id);
		model.addAttribute("orderMethod", orderMethod);
		return "orderMethodEdit";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod,Model model)
	{
		service.updateOrderMethod(orderMethod);
		String message="orderMethod'"+orderMethod.getOrdId()+"'updated";
		model.addAttribute("message", message);

		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "orderMethodData";
	}

	@RequestMapping("/view")
	public String showOneOrder(@RequestParam("ordid")Integer id,Model model)
	{
		OrderMethod orderMethod=service.getOneOrderMethodId(id);
		model.addAttribute("om",orderMethod);
		return "orderMethodView";
	}

	@RequestMapping("/excel")
	/*
	 * public ModelAndView displayExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new OrderMethodExcelView()); List<OrderMethod>
	 * list=service.getAllOrderMethods(); m.addObject("list",list); return m;
	 */		
	public ModelAndView displayExcel(@RequestParam(value="id",required = false)Integer id)
	{

		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());

		if(id==null) {
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
		}else
		{
			OrderMethod om=service.getOneOrderMethodId(id);
			m.addObject("list",Arrays.asList(om));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 * public ModelAndView displayPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new OrderMethodPdfView()); List<OrderMethod> 
	 * list=service.getAllOrderMethods(); m.addObject("list",list); return m;
	 */
	public ModelAndView displayPdf(@RequestParam(value = "id",required = false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());

		if(id==null) {
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
		}else
		{
			OrderMethod om=service.getOneOrderMethodId(id);
			m.addObject("list", Arrays.asList(om));
		}
		return m;
	}

	@RequestMapping("/charts")
	public String showCharts()
	{
		List<Object[]> list=service.getOrderTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "orderMethodCharts";
	}

}
