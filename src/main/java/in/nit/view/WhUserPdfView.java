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

import in.nit.model.WhUserType;

public class WhUserPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		//1.download file
		response.addHeader("Content-Disposition", "attachment;filename=whuser.pdf");
		//2.create element
		Paragraph p= new Paragraph("welcome to whuser");
		//3.add element to document
		document.add(p);
		//read data from model
		List<WhUserType> list=(List<WhUserType>) model.get("list");
	  PdfPTable  pt= new PdfPTable(8);
			  pt.addCell("ID");
			  pt.addCell("TYPE");
			  pt.addCell("CODE");
			  pt.addCell("USER FOR");
			  pt.addCell("USER EAMIL");
			  
			  pt.addCell("IDTYPE");
			  pt.addCell("IFOTHER");
			  pt.addCell("IDNUMBER");
			  
			  
	  //ADDING DATA TO TABLE
			  for(WhUserType o:list) {
				  
				 pt.addCell(o.getUserId().toString());
				 pt.addCell(o.getUserType());
				 pt.addCell(o.getUserCode());
				 pt.addCell(o.getUserFor());
				 pt.addCell(o.getUserEmail());
				 pt.addCell(o.getUserIdType());
				 pt.addCell(o.getIfOther());
				 pt.addCell(o.getIdNumber());
				 
				 
			  }
			  document.add(pt);
			  document.add(new Paragraph(new Date().toString()));
			  
	}


}
