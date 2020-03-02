package in.nit.Controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.util.UomUtil;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController 
{
	@Autowired
	private IUomService service;
	
	@Autowired
	private UomUtil util;
	
	@Autowired
	private ServletContext context;

	@RequestMapping("/register")
	public String uomRegister(Model model)
	{
		model.addAttribute("uom", new Uom());
		return "uomRegister";
	}

	@RequestMapping(value="/saveuom", method = RequestMethod.POST)
	public String saveUomMode(@ModelAttribute Uom uom ,Model model)
	{
		Integer id=service.saveUom(uom);
		String message="Uom'"+id+"'saved";
		model.addAttribute("message",message);
		model.addAttribute("uom", new Uom());
		return "uomRegister";
	}

	@RequestMapping("/alluoms")
	public String displayAllUoms(Model model) {
		List<Uom> list=service.displayAllUoms();
		model.addAttribute("list", list);
		return "uomData";
	}

	@RequestMapping("/delete")
	public String deleteUomById(@RequestParam("uomid")Integer id, Model model)
	{
		service.deleteUomById(id);
		String message="Uom'"+id+"'Deleted";
		model.addAttribute("message", message);

		List<Uom> list=service.displayAllUoms();
		model.addAttribute("list", list);

		return "uomData";

	}

	@RequestMapping("/edit")
	public String editShowPage(@RequestParam ("uomid")Integer id, Model model)
	{
		Uom uom=service.getOneUomId(id);
		model.addAttribute("uom",uom);
		return "uomEdit";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom,Model model)
	{
		service.updateUom(uom);
		String message="Uom'"+uom.getUomId()+"'updated";
		model.addAttribute("message", message);
		List<Uom> list=service.displayAllUoms();
		model.addAttribute("list", list);
		return "uomData";
	}

	@RequestMapping("/view")
	public String showOneUom(@RequestParam("uomid")Integer id, Model model)
	{
		Uom uom=service.getOneUomId(id);
		model.addAttribute("ou", uom);
		return "uomView";
	}

	@RequestMapping("/excel")
	/*
	 * public ModelAndView displayExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new UomExcelView());
	 * 
	 * List<Uom> list=service.displayAllUoms(); m.addObject("list", list); return m;
	 */
	public ModelAndView displayExcel(@RequestParam (value="id",required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==null) {
			List<Uom> list=service.displayAllUoms();
			m.addObject("list", list);
		}else
		{
			Uom uom=service.getOneUomId(id);
			m.addObject("list", Arrays.asList(uom));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 * public ModelAndView displayPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new UomPdfView()); List<Uom> list=service.displayAllUoms();
	 * m.addObject("list", list); return m;
	 */	
	public ModelAndView displayPdf(@RequestParam (value="id",required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		if(id==null) {
			List<Uom> list=service.displayAllUoms();
			m.addObject("list", list);
		}else
		{
			Uom uom=service.getOneUomId(id);
			m.addObject("list",Arrays.asList(uom));
		}
		return m;
	}
	@RequestMapping("/charts")
	public String showCharts()
	{
		List<Object[]> list=service.getUomTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "uomCharts";
	}

}