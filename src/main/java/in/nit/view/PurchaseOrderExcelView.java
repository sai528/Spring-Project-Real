package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.PurchaseOrder;
import in.nit.model.ShipmentType;

public class PurchaseOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=purchases.xlsx");
		Sheet s=workbook.createSheet("Purchase Orders");
		setHeaders(s);
		List<PurchaseOrder> list=(List<PurchaseOrder>)model.get("list");
		setBody(s,list);

	}

	private void setHeaders(Sheet s)
	{
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");

		r.createCell(2).setCellValue("SHIPCODE");
		r.createCell(3).setCellValue("VENDOR");

		r.createCell(4).setCellValue("REF NUMBER");
		r.createCell(5).setCellValue("QUALITY");
		r.createCell(6).setCellValue("STATUS");
		r.createCell(7).setCellValue("NOTE");
	}
	private void setBody(Sheet s,List<PurchaseOrder> list)
	{
		int count=1;
		for(PurchaseOrder po:list)
		{
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(po.getPurseId());
			r.createCell(1).setCellValue(po.getOrdCode());
			
			 r.createCell(2).setCellValue(po.getShipCodeOb().toString());
			 r.createCell(3).setCellValue(po.getUserVendorOb().toString());
			
			r.createCell(4).setCellValue(po.getRefNumber());
			r.createCell(5).setCellValue(po.getQualityCheck());
			r.createCell(6).setCellValue(po.getDefaultStatus());
			r.createCell(7).setCellValue(po.getPurDesc());

		}
	}
}


