package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.SaleOrder;

public class SaleOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=sales.xlsx");
		Sheet s=workbook.createSheet("SALES");
		setHeaders(s);
		List<SaleOrder> list=(List<SaleOrder>)model.get("list");
		setBody(s,list);

	}

	private void setHeaders(Sheet s)
	{
		Row r=s.createRow(0);

		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");

		/*r.createCell(2).setCellValue("SHIPCODE");
			r.createCell(3).setCellValue("CUSTOMER");*/

		r.createCell(2).setCellValue("REF NUMBER");
		r.createCell(3).setCellValue("STOCKMODE");
		r.createCell(4).setCellValue("SOURCE");
		r.createCell(5).setCellValue("STATUS");
		r.createCell(6).setCellValue("NOTE");
	}
	private void setBody(Sheet s,List<SaleOrder> list)
	{
		int count=1;
		for(SaleOrder so:list)
		{
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(so.getSaleId());
			r.createCell(1).setCellValue(so.getOrdCode());

			r.createCell(2).setCellValue(so.getShipCodeOb().getShipCode());
				r.createCell(3).setCellValue(so.getUserCustomerOb().getUserCode());

			r.createCell(4).setCellValue(so.getRefNumber());
			r.createCell(5).setCellValue(so.getStockMode());
			r.createCell(6).setCellValue(so.getStockSource());
			r.createCell(7).setCellValue(so.getDefaultStatus());
			r.createCell(8).setCellValue(so.getSaleDesc());
		}
	}
}


