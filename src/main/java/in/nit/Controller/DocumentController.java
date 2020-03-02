package in.nit.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	@Autowired
	private IDocumentService service;

	@RequestMapping("/show")
	public String showUpload(Model model)
	{
		List<Object[]> list=service.getFileIdAndNames();
		model.addAttribute("list", list);
		return "document";
	}

	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String doUpload(@RequestParam Integer fileId,@RequestParam CommonsMultipartFile fileOb,Model model)
	{
		if(fileOb!= null)
		{
			Document d=new Document();
			d.setFileId(fileId);
			d.setFileName(fileOb.getOriginalFilename());
			d.setFileData(fileOb.getBytes());
			service.saveDocument(d);
			String message=fileId+"upload";
			model.addAttribute("message",message);

		}
		return "redirect:show";
	}

	
	@RequestMapping("/download")
public void doDownload(@RequestParam Integer fid,HttpServletResponse resp)
{
		Document d=service.getOneDocument(fid);
		resp.addHeader("Content-Disposition","attachment;filename="+d.getFileName());
		
		try {
			FileCopyUtils.copy(d.getFileData(),resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}

