package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.nit.model.SaleOrder;
import in.nit.model.ShipmentType;

public class SaleOrderExcelView extends AbstractXlsView {

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

		r.createCell(4).setCellValue("REF NUMBER");
		r.createCell(5).setCellValue("STOCKMODE");
		r.createCell(5).setCellValue("SOURCE");
		r.createCell(5).setCellValue("STATUS");
		r.createCell(5).setCellValue("NOTE");
	}
	private void setBody(Sheet s,List<SaleOrder> list)
	{
		int count=1;
		for(SaleOrder so:list)
		{
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(so.getSaleId());
			r.createCell(1).setCellValue(so.getOrdCode());

			/*r.createCell(2).setCellValue(so.getShipCode());
				r.createCell(3).setCellValue(so.getUserType());*/

			r.createCell(2).setCellValue(so.getRefNumber());
			r.createCell(3).setCellValue(so.getStockMode());
			r.createCell(4).setCellValue(so.getStockSource());
			r.createCell(5).setCellValue(so.getDefaultStatus());
			r.createCell(6).setCellValue(so.getSaleDesc());
		}
	}
}


