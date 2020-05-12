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
import in.nit.model.WhUserType;

public class WhUserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.addHeader("Content-distribution",
				"attachement:filename=whusertypes.xslx");
	Sheet s= workbook.createSheet("WHUSERTYPES");
	setHeaders(s);
	List<WhUserType> list=(List<WhUserType>) model.get("list");
	setBody(s,list);
	}
	private void setHeaders(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("USERIDTYPE");
		r.createCell(6).setCellValue("IFOTHER");
		r.createCell(7).setCellValue("IDNUMBER");
	}
	
	private void setBody(Sheet s,List<WhUserType> list) {
		int count=1;
		for(WhUserType u:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(u.getUserId());
			r.createCell(1).setCellValue(u.getUserType());
			r.createCell(2).setCellValue(u.getUserCode());
			r.createCell(3).setCellValue(u.getUserFor());
			r.createCell(4).setCellValue(u.getUserEmail());
			r.createCell(5).setCellValue(u.getUserIdType());
			r.createCell(6).setCellValue(u.getIfOther());
			r.createCell(7).setCellValue(u.getIdNumber());
		}
	
	}

}
