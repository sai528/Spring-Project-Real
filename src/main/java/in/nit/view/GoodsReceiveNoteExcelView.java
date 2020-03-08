package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.GoodsReceiveNote;
import in.nit.model.Uom;

public class GoodsReceiveNoteExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=goods.xlsx");
		Sheet s=workbook.createSheet("GOODS RECEIVE NOTE");
		setHeaders(s);
		List<GoodsReceiveNote> list=(List<GoodsReceiveNote>)model.get("list");
		setBody(s,list);
	}

	private void setHeaders(Sheet s)
	{
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("TYPE");
		/* r.createCell(2).setCellValue("ORDCODE"); */
		r.createCell(3).setCellValue("NOTE");
	}

	private void setBody(Sheet s,List<GoodsReceiveNote> list)
	{
		int count=1;
		for(GoodsReceiveNote grn:list)
		{
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(grn.getGoodsId());
			r.createCell(1).setCellValue(grn.getGoodsCode());
			r.createCell(2).setCellValue(grn.getGoodsType());
			/* r.createCell(2).setCellValue(grn.getOrdCode()); */
			r.createCell(3).setCellValue(grn.getGoodsDesc());
		}
	}
	}


