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


import in.nit.model.Uom;

public class UomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		//1.download file
		response.addHeader("Content-Disposition", "attachment;filename=uom.pdf");
		//2.create element
		Paragraph p= new Paragraph("welcome to uom");
		//3.add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>) model.get("list");
	  PdfPTable  pt= new PdfPTable(6);
			  pt.addCell("ID");
			  pt.addCell("MODEL");
			 
			  pt.addCell("TYPE");
			  pt.addCell("NOTE");
			  
			  
	  //ADDING DATA TO TABLE
			  for(Uom o:list) {
				  
				 pt.addCell(o.getUomId().toString());
				 pt.addCell(o.getUomModel().toString());
				 pt.addCell(o.getUomType().toString());
				 pt.addCell(o.getDescription().toString());
				
				 
			  }
			  document.add(pt);
			  document.add(new Paragraph(new Date().toString()));
			  
	} 

}
