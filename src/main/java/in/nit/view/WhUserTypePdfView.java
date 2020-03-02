package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.OrderMethod;
import in.nit.model.WhUserType;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

response.addHeader("Content-Disposition","attachment;filename=whusertypepdf.pdf");
		
		Paragraph p=new Paragraph("WELCOME TO WHUSER TYPE LIST");
		
		document.add(p);
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		PdfPTable t=new PdfPTable(9);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("USER FOR");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("ID PROOF");
		t.addCell("OTHER");
		t.addCell("ID NUMBER");
	for(WhUserType wt:list)
	{
		t.addCell(wt.getUserId().toString());
		t.addCell(wt.getUserType());
		t.addCell(wt.getUserCode());
		t.addCell(wt.getUserFor());
		t.addCell(wt.getUserEmail());
		t.addCell(wt.getUserContact().toString());
		t.addCell(wt.getUserIdType());
		t.addCell(wt.getIfOther());
		t.addCell(wt.getIdNumber().toString());
	}
	document.add(t);
	document.add(new Paragraph(new Date().toString()));
	}

	}


