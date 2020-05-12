package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.ShipmentType;

public class ShipmentTypePdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		//1.download file
		response.addHeader("Content-Disposition", "attachment;filename=ShipmentType.pdf");
		//2.create element
		Paragraph p= new Paragraph("welcome to shiptype");
		//3.add element to document
		document.add(p);
		//read data from model
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
	  PdfPTable  pt= new PdfPTable(6);
			  pt.addCell("ID");
			  pt.addCell("MODE");
			  pt.addCell("CODE");
			  pt.addCell("GRADE");
			  pt.addCell("ENABLE");
			  pt.addCell("NOTE");
			  
			  
	  //ADDING DATA TO TABLE
			  for(ShipmentType o:list) {
				  
				 pt.addCell(o.getShipmentId().toString());
				 pt.addCell(o.getShipmentMode());
				 pt.addCell(o.getShipCode());
				
				 pt.addCell(o.getShipmentGrade());
				
				 pt.addCell(o.getEnableShipment());
				 pt.addCell(o.getShipDescription());
				 
			  }
			  document.add(pt);
			  document.add(new Paragraph(new Date().toString()));
			  
	}


}
