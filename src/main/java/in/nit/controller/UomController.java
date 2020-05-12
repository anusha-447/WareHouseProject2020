package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private ApplicationContext cntxt;
	@RequestMapping("/register")
	public 	String showUom(Model model) {
		model.addAttribute("uom", new Uom());
		System.out.println("object:"+cntxt.getClass().getName());
		return "UomRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom,Model model ) {
		Integer id=service.saveUom(uom);
		String message="uom is '"+id+"' saved";
		System.out.println(message);
		
		model.addAttribute("message", message);
		return "UomRegister";
	}
	@RequestMapping("/all")
	public String getAllUoms(Model model) {
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		
		return "UomData";
		
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("uoid")Integer id,Model model) {
		service.deleteUom(id);
		String message="uom is '"+id+"' deleted";
		model.addAttribute("message",message);
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/edit")
	public String editUom(@RequestParam("uoid")Integer id,Model model) {
		Uom uom=service.getOneUom(id);
		model.addAttribute("uom",uom);
		return "UomEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom,Model model) {
		service.updateUom(uom);
		String message="uom is '"+uom.getUomId()+"' updated";
		model.addAttribute("message",message);
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/view")
	public String showView(@RequestParam("uoid") Integer id,Model model) {
		Uom uom=service.getOneUom(id);
		model.addAttribute("ob",uom);
		return "UomView";
		
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="uoid",required=false) Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new UomExcelView());
		if(id==null) {
			List<Uom> list=service.getAllUoms();
			m.addObject("list",list);
			}
			else {
				Uom uom=service.getOneUom(id);
				m.addObject("list",Arrays.asList(uom));
			}
			
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="uoid",required=false) Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new UomPdfView());
		if(id==null) {
		List<Uom> list=service.getAllUoms();
		m.addObject("list",list);
		}
		else {
			Uom uom=service.getOneUom(id);
			m.addObject("list",Arrays.asList(uom));
		}
		
		return m;
	}
}
