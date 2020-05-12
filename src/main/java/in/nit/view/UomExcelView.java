package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Order;
import in.nit.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("Content-distribution",
				"attachement:filename=UOMS.xslx");
	Sheet s= workbook.createSheet("UOMS");
	setHeaders(s);
	List<Uom> list=(List<Uom>) model.get("list");
	setBody(s,list);
		
	}
	private void setHeaders(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("UOMTYPE");
		r.createCell(2).setCellValue("UOMMODEL");
		r.createCell(3).setCellValue("DESCRIPTION");
		
		
	}
	private void setBody(Sheet s,List<Uom> list) {
		int count=1;
		for(Uom o:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(o.getUomId());
			
			r.createCell(2).setCellValue(o.getUomType());
			r.createCell(1).setCellValue(o.getUomModel());
			r.createCell(3).setCellValue(o.getDescription());
			
		}
		
	}

}
