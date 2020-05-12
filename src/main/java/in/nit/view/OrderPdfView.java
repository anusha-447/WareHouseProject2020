package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.Order;

public class OrderPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		//1.download file
		response.addHeader("Content-Disposition", "attachment;filename=order.pdf");
		//2.create element
		Paragraph p= new Paragraph("welcome to shiptype");
		//3.add element to document
		document.add(p);
		//read data from model
		List<Order> list=(List<Order>) model.get("list");
	  PdfPTable  pt= new PdfPTable(6);
			  pt.addCell("ID");
			  pt.addCell("MODE");
			  pt.addCell("CODE");
			  pt.addCell("ACCEPTANCE");
			  pt.addCell("METHOD");
			  pt.addCell("NOTE");
			  
			  
	  //ADDING DATA TO TABLE
			  for(Order o:list) {
				  
				 pt.addCell(o.getOrderId().toString());
				 pt.addCell(o.getOrderMode());
				 pt.addCell(o.getOrderCode());
			//	 pt.addCell(o.getOrderAccept());
				 pt.addCell(o.getOrderMethod());
				 pt.addCell(o.getDescription());
				 
			  }
			  document.add(pt);
			  document.add(new Paragraph(new Date().toString()));
			  
	}

}
