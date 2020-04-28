package in.nit.Controller;

import java.util.Arrays;
import java.util.List;

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

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.validator.ShipmentTypeValidator;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController 
{
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;
	@Autowired
	private ShipmentTypeValidator validator;

	@RequestMapping("/register")
	public String showeRegPage(Model model)
	{
		model.addAttribute("shipmentType", new ShipmentType());
		return "shipmentTypeRegister";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,Errors errors,Model model)
	{
		validator.validate(shipmentType, errors);
		if(!errors.hasErrors()) {

			Integer id=service.saveShipmentType(shipmentType);
			String message="ShipmentType'"+id+"'saved";
			model.addAttribute("message",message);
			model.addAttribute("shipmentType", new ShipmentType());
		}else {
			model.addAttribute("message","please check all errors");
		}
		return "shipmentTypeRegister";
	}

	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model) 
	{
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "shipmentTypeData";
	}

	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid")Integer id,Model model)
	{
		service.deleteShipmentType(id);
		String message="shipment'"+id+"'deleted";
		model.addAttribute("message", message);

		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "shipmentTypeData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id, Model model)
	{
		ShipmentType st=service.getOneShipmentTypeId(id);
		model.addAttribute("shipmentType",st);
		return "shipmentTypeEdit";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model)
	{
		service.updateShipmentType(shipmentType);
		String message="shipmentType'"+shipmentType.getShipId()+"'updated";
		model.addAttribute("message",message);

		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "shipmentTypeData";

	}

	@RequestMapping("/view")
	public String showOneShipment(@RequestParam("sid")Integer id,Model model) 
	{
		ShipmentType st=service.getOneShipmentTypeId(id);
		model.addAttribute("ob",st);
		return "shipmentTypeView";
	}

	@RequestMapping("/excel")
	/*
	 * public ModelAndView showExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new ShipmentTypeExcelView()); List<ShipmentType>
	 * list=service.getAllShipmentTypes(); m.addObject("list", list); return m;
	 */
	public ModelAndView showExcel(@RequestParam(value="id", required = false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());

		if(id==null)
		{
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list", list);
		}
		else {
			ShipmentType st=service.getOneShipmentTypeId(id);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 * public ModelAndView showPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new ShipmentTypePdfView()); List<ShipmentType>
	 * list=service.getAllShipmentTypes(); m.addObject("list", list); return m;
	 */
	public ModelAndView showPdf(@RequestParam(value="id", required = false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if(id==null)
		{
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list", list);	
		}
		else {
			ShipmentType st=service.getOneShipmentTypeId(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}
	@RequestMapping("/charts")
	public String showCharts()
	{
		List<Object[]> list=service.getShipmentModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "shipmentTypeCharts";
	}

}
