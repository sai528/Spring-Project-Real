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

import in.nit.model.GoodsReceiveNote;
import in.nit.model.Uom;

public class GoodsReceiveNotePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=goods.pdf");

		Paragraph p=new Paragraph("WELCOME TO GOODS RECEIVE NOTE");
		document.add(p);
		List<GoodsReceiveNote> list=(List<GoodsReceiveNote>)model.get("list");
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("TYPE");
		/* t.addCell("OrdCode"); */
		t.addCell("NOTE");

		for(GoodsReceiveNote grn:list)
		{
			t.addCell(grn.getGoodsId().toString());
			t.addCell(grn.getGoodsCode());
			t.addCell(grn.getGoodsType());
			/* t.addCell(grn.getOrdCode()); */
			t.addCell(grn.getGoodsDesc());
		}

		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}


	}


