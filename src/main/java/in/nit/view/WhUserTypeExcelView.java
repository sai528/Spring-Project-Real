package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.OrderMethod;
import in.nit.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=whusertypesheet.xlsx");
		Sheet s=workbook.createSheet("WHUSER TYPES");
		setHeaders(s);
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		setBody(s,list);
	}

	public void setHeaders(Sheet s)
	{
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("ID PROOF");
		r.createCell(7).setCellValue("OTHER");
		r.createCell(8).setCellValue("ID NUMBER");
	}
public void setBody(Sheet s,List<WhUserType> list)
{
	int count=1;
	for(WhUserType wt:list)
	{
		Row r=s.createRow(count++);
		r.createCell(0).setCellValue(wt.getUserId());
		r.createCell(1).setCellValue(wt.getUserType());
		r.createCell(2).setCellValue(wt.getUserCode());
		r.createCell(3).setCellValue(wt.getUserFor());
		r.createCell(4).setCellValue(wt.getUserEmail());
		r.createCell(5).setCellValue(wt.getUserContact());
		r.createCell(6).setCellValue(wt.getUserIdType());
		r.createCell(7).setCellValue(wt.getIfOther());
		r.createCell(8).setCellValue(wt.getIdNumber());
	}
}

	}


