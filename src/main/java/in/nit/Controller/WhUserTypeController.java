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

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;
import in.nit.util.WhUserTypeUtil;
import in.nit.validator.WhUserTypeValidator;
import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController
{
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private WhUserTypeUtil util;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeValidator validator;

	@RequestMapping ("/register")
	public String showRegisterPage(Model model)
	{
		model.addAttribute("whUserType", new WhUserType());
		return "whuserTypeRegister";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute WhUserType whUserType, Errors errors, Model model)
	{
		validator.validate(whUserType, errors);
		if(!errors.hasErrors()) {
		Integer id=service.saveWhUserType(whUserType);
		String message="WhUserType'"+id+"'Saved";
		model.addAttribute("message", message);
		model.addAttribute("whUserType", new WhUserType());
		}else {
			model.addAttribute("message", "please check all errors");
		}
		return "whuserTypeRegister";
	}
	@RequestMapping("/allwhusers")
	public String displayAllWhUserTypes(Model model)
	{
		List<WhUserType> list=service.displayAllWhUserTypes();
		model.addAttribute("list", list);
		return "whuserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteWhUserById(@RequestParam ("userid")Integer id, Model model)
	{
		service.deleteWhUserById(id);
		String message="WhUserType'"+id+"'Deleted";
		model.addAttribute("message", message);

		List<WhUserType> list=service.displayAllWhUserTypes();
		model.addAttribute("list", list);
		return "whuserTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam ("userid")Integer userid, Model model)
	{
		WhUserType wut=service.getOneWhUserTypeId(userid);
		model.addAttribute("whUserType", wut);
		return "whuserTypeEdit";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateWhUserType(@ModelAttribute WhUserType whUserType, Model model)
	{
		service.updateWhUserType(whUserType);	
		String message="WhUserType'"+whUserType.getUserId()+"'updated";
		model.addAttribute("message", message);
		List<WhUserType> list=service.displayAllWhUserTypes();
		model.addAttribute("list", list);
		return "whuserTypeData";
	}
	
	@RequestMapping("/view")
	public String showOneWhUser(@RequestParam("userid")Integer id,Model model)
	{
		WhUserType wut=service.getOneWhUserTypeId(id);
		model.addAttribute("wt",wut);
		return "whuserTypeView";
	}

	@RequestMapping ("/excel")
	/*
	 * public ModelAndView displayExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new WhUserTypeExcelView()); List<WhUserType>
	 * list=service.displayAllWhUserTypes(); m.addObject("list",list); return m;
	 */		
	public ModelAndView displayExcel(@RequestParam(value="id",required = false)Integer id)
	{

		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());

		if(id==null) {
			List<WhUserType> list=service.displayAllWhUserTypes();
			m.addObject("list",list);
		}else
		{
			WhUserType wt=service.getOneWhUserTypeId(id);
			m.addObject("list",Arrays.asList(wt));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 * public ModelAndView displayPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new WhUserTypePdfView()); List<WhUserType> 
	 * list=service.displayAllWhUserTypes(); m.addObject("list",list); return m;
	 */
	public ModelAndView displayPdf(@RequestParam(value = "id",required = false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());

		if(id==null) {
			List<WhUserType> list=service.displayAllWhUserTypes();
			m.addObject("list",list);
		}else
		{
			WhUserType om=service.getOneWhUserTypeId(id);
			m.addObject("list", Arrays.asList(om));
		}
		return m;
	}
	
	@RequestMapping("/charts")
	public String showCharts()
	{
		List<Object[]> list=service.getWhUserTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "whuserTypeCharts";
	}

	
}
