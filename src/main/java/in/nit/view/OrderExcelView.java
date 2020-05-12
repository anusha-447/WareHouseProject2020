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

public class OrderExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-distribution",
				"attachement:filename=Orders.xslx");
	Sheet s= workbook.createSheet("ORDER METHODS");
	setHeaders(s);
	List<Order> list=(List<Order>) model.get("list");
	setBody(s,list);
	}
	private void setHeaders(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("TYPE");
		//r.createCell(4).setCellValue("ACCEPTANCE");
		r.createCell(5).setCellValue("DESCRIPTION");
	}
	private void setBody(Sheet s,List<Order> list) {
		int count=1;
		for(Order o:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(o.getOrderId());
			r.createCell(1).setCellValue(o.getOrderMode());
			r.createCell(2).setCellValue(o.getOrderCode());
			r.createCell(3).setCellValue(o.getOrderMethod());
			//r.createCell(4).setCellValue(o.getOrderAccept());
			r.createCell(5).setCellValue(o.getDescription());
		}
	}

}
