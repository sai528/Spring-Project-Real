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

import in.nit.model.Part;


public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=Part.pdf");
		Paragraph p=new Paragraph("WELCOME TO PART");
		document.add(p);
		List<Part> list=(List<Part>)model.get("list");
		PdfPTable t=new PdfPTable(8);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("WIDTH");
		t.addCell("LENGTH");
		t.addCell("HEIGHT");
		t.addCell("COST");
		t.addCell("CURRENCY");
		/*
		 * t.addCell("UOM"); t.addCell("ORDER METHOD CODE");
		 */
		t.addCell("NOTE");
		
		for(Part pt:list)
		{
			t.addCell(pt.getPartId().toString());
			t.addCell(pt.getPartCode());
			t.addCell(pt.getPartWidth().toString());
			t.addCell(pt.getPartLength().toString());
			t.addCell(pt.getPartHeight().toString());
			t.addCell(pt.getPartBaseCost().toString());
			t.addCell(pt.getPartBaseCurrency());
			/*
			 * t.addCell(pt.getUom()); t.addCell(pt.getOrderMethodCode());
			 */
			t.addCell(pt.getPartDesc());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
		
	}
	}


