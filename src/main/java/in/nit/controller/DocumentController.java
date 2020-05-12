package in.nit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	private IDocumentService service;
	//1.show document
	@RequestMapping("/show")
	public String show() {

		return "Documents";
	}
	//2.upload document to db
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String doUpload(
			@RequestParam Integer fileId,
			@RequestParam CommonsMultipartFile fileOb,
			Model model
			) {
		
		if(fileOb!=null) {
			
			Document d = new Document();
		    d.setFileId(fileId);
			d.setFileData(fileOb.getBytes());
			d.setFileName(fileOb.getOriginalFilename());
			service.saveDocument(d);
			String msg=fileId+" is uploaded";
			//System.out.println(fileId);
			List<Object[]> list=service.getFileIdAndNames();
			model.addAttribute("list",list);
			model.addAttribute("msg",msg);
        }

        return "Documents";
	}
//	@RequestMapping("/showdata")
//	public String uploadPage(Model model) {
//		
//		List<Object[]> list=service.getFileIdAndNames();
//		model.addAttribute("list",list);
//		return "Documents";
//	}
//	@RequestMapping("/download")
//   public void download(@RequestParam Integer fid,HttpServletResponse resp) {
//		
//	   Document doc=service.getOneDocument(fid);
//	   resp.addHeader("content-disposition", "attachement:filename=+doc.getFileName()");
//	   
//	 try {
//		 FileCopyUtils.copy(doc.getFileName(),resp.getOutputStream());
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
 //  }
}
