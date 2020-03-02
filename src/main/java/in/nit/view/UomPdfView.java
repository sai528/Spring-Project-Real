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

import in.nit.model.Uom;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=uom.pdf");

		Paragraph p=new Paragraph("WELCOME TO UOM");
		document.add(p);
		List<Uom> list=(List<Uom>)model.get("list");
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("NOTE");

		for(Uom uom:list)
		{
			t.addCell(uom.getUomId().toString());
			t.addCell(uom.getUomType());
			t.addCell(uom.getUomModel());
			t.addCell(uom.getUomDesc());
		}

		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
