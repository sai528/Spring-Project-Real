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

import in.nit.model.Part;
import in.nit.service.IOrderMethodService;
import in.nit.service.IPartService;
import in.nit.service.IUomService;
import in.nit.util.CommonUtil;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController
{
	@Autowired
	private IPartService service;
	
	@Autowired
	private IUomService uomService;
	
	@Autowired
	private IOrderMethodService orderService;

	private void commonUi(Model model)
	{
		List<Object[]> uomList=uomService.getUomIdAndUomMode();
		Map<Integer,String> uomMap=CommonUtil.convert(uomList);
		/* model.addAttribute("uomList", uomList); */
		 model.addAttribute("uomMap", uomMap);
		 
		 List<Object[]> orderList=orderService.getOrdIdAndOrdCode("Sale");
		 Map<Integer,String> orderMap=CommonUtil.convert(orderList);
		 model.addAttribute("orderMap", orderMap);
		
		 List<Object[]> ordList=orderService.getOrdIdAndOrdCode("Purchase");
		 Map<Integer,String> ordMap=CommonUtil.convert(ordList);
		 model.addAttribute("ordMap", ordMap);
		
	}
	
	@RequestMapping ("/register")
	public String PartRegister(Model model) 
	{
		model.addAttribute("part", new Part());
		commonUi(model);
		return "partRegister"; 
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePart(@ModelAttribute Part part,Model model)
	{
		Integer id=service.savePart(part);
		String message="Part'"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("part", new Part());
		commonUi(model);
		return "partRegister";
	}
	@RequestMapping("/allparts")
	public String displayAllParts(Model model)
	{
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "partData";
	}

	@RequestMapping("/delete")
	public String DeletePartById(@RequestParam("pid") Integer id,Model model)
	{
		service.DeletePart(id);
		String message="Part'"+id+"'Deleted";
		model.addAttribute("message",message);

		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "partData";
	}
	
	@RequestMapping("/edit")
	public String editPartPage(@RequestParam("pid") Integer id, Model model)
	{
		Part part=service.getOnePartId(id);
		model.addAttribute("part",part);
		commonUi(model);
		return "partEdit";
	}
	
	@RequestMapping("/update")
	public String updatePart(@ModelAttribute Part part,Model model)
	{
		service.updatePart(part);
		String message="Part'"+part.getPartId()+"'updated";
		model.addAttribute("message",message);
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "partData";
	}
	
	@RequestMapping("/view")
	public String showOnePart(@RequestParam("pid") Integer id,Model model)
	{
		Part part=service.getOnePartId(id);
		model.addAttribute("pt",part);
		return "partView";
	}
	
	@RequestMapping("/excel")
	/*
	 * public ModelAndView showExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new PartExcelView()); List<Part>
	 * list=service.getAllParts(); m.addObject("list", list); return m;
	 */
		public ModelAndView showExcel(@RequestParam(value="id", required = false)Integer id)
		{
			ModelAndView m=new ModelAndView();
			m.setView(new PartExcelView());
			
			if(id==null)
			{
			List<Part> list=service.getAllParts();
			m.addObject("list", list);
			}
			else {
				Part pt=service.getOnePartId(id);
				m.addObject("list", Arrays.asList(pt));
			}
			return m;
	}
	
	@RequestMapping("/pdf")
	/*
	 * public ModelAndView showPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new PartPdfView()); List<Part>
	 * list=service.getAllParts(); m.addObject("list", list); return m;
	 */
		public ModelAndView showPdf(@RequestParam(value="id", required = false)Integer id)
		{
			ModelAndView m=new ModelAndView();
			m.setView(new PartPdfView());
			if(id==null)
			{
				List<Part> list=service.getAllParts();
				m.addObject("list", list);	
			}
			else {
				Part pt=service.getOnePartId(id);
				m.addObject("list",Arrays.asList(pt));
			}
			return m;
	}
}
