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

import in.nit.model.SaleOrder;

public class SaleOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=Sale.pdf");
		Paragraph p=new Paragraph("WELCOME TO SALE ORDER");
		document.add(p);
		List<SaleOrder> list=(List<SaleOrder>)model.get("list");
		PdfPTable t=new PdfPTable(7);
		t.addCell("ID");
		t.addCell("CODE");
		/*
		 * t.addCell("SHIPCODE"); t.addCell("CUSTOMER");
		 */
		t.addCell("REF NUMBER");
		t.addCell("STOCKMODE");
		t.addCell("SOURCE");
		t.addCell("STATUS");
		t.addCell("NOTE");

		for(SaleOrder so:list)
		{
			t.addCell(so.getSaleId().toString());
			t.addCell(so.getOrdCode());
			/*
			 * t.addCell(so.getShipCode()); t.addCell(so.getUserType());
			 */
			t.addCell(so.getRefNumber().toString());
			t.addCell(so.getStockMode());
			t.addCell(so.getStockSource());
			t.addCell(so.getDefaultStatus());
			t.addCell(so.getSaleDesc());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));

	}

}


