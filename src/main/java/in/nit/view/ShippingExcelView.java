package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import in.nit.model.Shipping;

public class ShippingExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=shipping.xlsx");
		Sheet s=workbook.createSheet("SHIPPING");
		setHeaders(s);
		List<Shipping> list=(List<Shipping>) model.get("list");
	setBody(s,list);
	
	}

	private void setHeaders(Sheet s)
	{
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("REF NUMBER");
		r.createCell(3).setCellValue("COUR REF NUMBER");
		r.createCell(4).setCellValue("CONT DETAILS");
		r.createCell(5).setCellValue("sale Order Code");
		r.createCell(6).setCellValue("NOTE");
		r.createCell(7).setCellValue("BILL TO ADDR");
		r.createCell(8).setCellValue("SHIP TO ADDR");
	}
	private void setBody(Sheet s,List<Shipping> list)
	{
		int count=1;
		for(Shipping sp:list) 
		{
		Row r=s.createRow(count++);
		r.createCell(0).setCellValue(sp.getShippingId());
		r.createCell(1).setCellValue(sp.getShippingCode());
		r.createCell(2).setCellValue(sp.getShippingRefNum());
		r.createCell(3).setCellValue(sp.getCourierRefNum());
		r.createCell(4).setCellValue(sp.getContactDetails());
		r.createCell(5).setCellValue(sp.getSaleOrdCodeOb().getOrdCode());
		r.createCell(6).setCellValue(sp.getShippingDesc());
		r.createCell(7).setCellValue(sp.getBillToAddr());
		r.createCell(8).setCellValue(sp.getShipToAddr());
		}
	}
}
