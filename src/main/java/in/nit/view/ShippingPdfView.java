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

import in.nit.model.Shipping;

public class ShippingPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition","attachment;filename=shipping.pdf");
		Paragraph p=new Paragraph("Welcome to Shipping");
		document.add(p);
		List<Shipping> list=(List<Shipping>) model.get("list");
		PdfPTable t=new PdfPTable(9);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("REF NUMBER");
		t.addCell("COUR REF NUMBER");
		t.addCell("CONT DETAILS");
		t.addCell("sale Order Code");
		t.addCell("NOTE");
		t.addCell("BILL TO ADDR");
		t.addCell("SHIP TO ADDR");


		for(Shipping sp:list)
		{
			t.addCell(sp.getShippingId().toString());	
			t.addCell(sp.getShippingCode());	
			t.addCell(sp.getShippingRefNum().toString());	
			t.addCell(sp.getCourierRefNum().toString());	
			t.addCell(sp.getContactDetails());	
			t.addCell(sp.getSaleOrdCodeOb().getOrdCode());	
			t.addCell(sp.getShippingDesc());	
			t.addCell(sp.getBillToAddr());	
			t.addCell(sp.getShipToAddr());	
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
		
	}
}
