package in.nit.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.GoodsReceiveNote;
import in.nit.service.IGoodsReceiveNoteService;
import in.nit.view.GoodsReceiveNoteExcelView;
import in.nit.view.GoodsReceiveNotePdfView;

@Controller
@RequestMapping("/goods")
public class GoodsReceiveNoteController {

	@Autowired
	private IGoodsReceiveNoteService service;

	@RequestMapping("/register")
	public String goodsRegister(Model model)
	{
		model.addAttribute("goodsReceiveNote",new GoodsReceiveNote());
		return "goodsReceiveNoteRegister";
	}

	@RequestMapping(value="/savegoods", method=RequestMethod.POST)
	public String saveGoods(@ModelAttribute GoodsReceiveNote goodsReceiveNote, Model model)
	{
		Integer id=service.saveGoodsReceiveNote(goodsReceiveNote);
		String message="GoodsReceived'"+id+"'saved";

		model.addAttribute("message", message);
		model.addAttribute("goodsReceiveNote",new GoodsReceiveNote());
		return "goodsReceiveNoteRegister";
	}

	@RequestMapping("/allgoods")
	public String displayAllGoods(Model model)
	{
		List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
		model.addAttribute("list", list);
		return "goodsReceiveNoteData";
	}

	@RequestMapping("/edit")
	public String editGoods(@RequestParam("goodsid")Integer id,Model model)
	{
		GoodsReceiveNote goodsReceiveNote=service.getOneGoodsReceiveNoteId(id);
		model.addAttribute("goodsReceiveNote", goodsReceiveNote);
		return "goodsReceiveNoteEdit";
	}

	@RequestMapping("/delete")
	public String deleteGoods(@RequestParam("goodsid")Integer id,Model model)
	{
		service.deleteGoodsReceiveNote(id);
		String message="GoodsReceived'"+id+"'Deleted";
		model.addAttribute("message", message);
		
		List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
		model.addAttribute("list", list);
		return "goodsReceiveNoteData";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateGoods(@ModelAttribute GoodsReceiveNote goodsReceiveNote, Model model)
	{
		service.updateGoodsReceiveNote(goodsReceiveNote);
		String message="Goods'"+goodsReceiveNote.getGoodsId()+"'updated";
		model.addAttribute("message", message);
		
		List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
		model.addAttribute("list", list);
		return "goodsReceiveNoteData";
	}
	
	@RequestMapping("/view")
	public String viewGoods(@RequestParam("goodsid")Integer id,Model model)
	{
		GoodsReceiveNote goodsReceiveNote =service.getOneGoodsReceiveNoteId(id);
		model.addAttribute("grn", goodsReceiveNote);
		return "goodsReceiveNoteView";
	}
	
	@RequestMapping("/excel")
	/*
	 * public ModelAndView displayExcel() { ModelAndView m=new ModelAndView();
	 * m.setView(new GoodsReceiveNoteExcelView()); 
	 * List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes(); m.addObject("list", list); return m;
	 */
	public ModelAndView displayExcel(@RequestParam (value="id",required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new GoodsReceiveNoteExcelView());
		if(id==null) {
			List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
			m.addObject("list", list);
		}else
		{
			GoodsReceiveNote goodsReceiveNote =service.getOneGoodsReceiveNoteId(id);
			m.addObject("list", Arrays.asList(goodsReceiveNote));
		}
		return m;
	}

	@RequestMapping("/pdf")
	/*
	 * public ModelAndView displayPdf() { ModelAndView m=new ModelAndView();
	 * m.setView(new GoodsReceiveNotePdfView()); List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
	 * m.addObject("list", list); return m;
	 */	
	public ModelAndView displayPdf(@RequestParam (value="id",required=false)Integer id)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new GoodsReceiveNotePdfView());
		if(id==null) {
			List<GoodsReceiveNote> list=service.getAllGoodsReceiveNotes();
			m.addObject("list", list);
		}else
		{
			GoodsReceiveNote goodsReceiveNote=service.getOneGoodsReceiveNoteId(id);
			m.addObject("list",Arrays.asList(goodsReceiveNote));
		}
		return m;
	}
	
}
