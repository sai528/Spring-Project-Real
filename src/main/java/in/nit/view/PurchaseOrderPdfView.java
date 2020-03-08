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

import in.nit.model.PurchaseOrder;
import in.nit.model.ShipmentType;

public class PurchaseOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=Purchase.pdf");
		Paragraph p=new Paragraph("WELCOME TO PURCHASE ORDER");
		document.add(p);
		List<PurchaseOrder> list=(List<PurchaseOrder>)model.get("list");
		PdfPTable t=new PdfPTable(8);
		t.addCell("ID");
		t.addCell("CODE");

		t.addCell("SHIPCODE"); 
		t.addCell("VENDOR");

		t.addCell("REF NUMBER");
		t.addCell("QUALITY");
		t.addCell("STATUS");
		t.addCell("NOTE");

		for(PurchaseOrder po:list)
		{
			t.addCell(po.getPurseId().toString());
			t.addCell(po.getOrdCode());

			t.addCell(po.getShipCodeOb().toString());
			t.addCell(po.getUserVendorOb().toString());

			t.addCell(po.getRefNumber().toString());
			t.addCell(po.getQualityCheck());
			t.addCell(po.getDefaultStatus());
			t.addCell(po.getPurDesc());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));

	}


}


