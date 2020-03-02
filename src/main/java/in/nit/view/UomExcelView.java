package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		response.addHeader("Content-Disposition","attachment;filename=uom.xlsx");
		Sheet s=workbook.createSheet("UOM");
		setHeaders(s);
		List<Uom> list=(List<Uom>)model.get("list");
		setBody(s,list);
	}

	private void setHeaders(Sheet s)
	{
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(3).setCellValue("NOTE");
	}

	private void setBody(Sheet s,List<Uom> list)
	{
		int count=1;
		for(Uom u:list)
		{
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(u.getUomId());
			r.createCell(1).setCellValue(u.getUomType());
			r.createCell(2).setCellValue(u.getUomModel());
			r.createCell(3).setCellValue(u.getUomDesc());
		}
	}
}
