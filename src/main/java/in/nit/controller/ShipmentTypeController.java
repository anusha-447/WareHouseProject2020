package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentUtil util;

	@Autowired
	private IShipmentTypeService service;
	@RequestMapping("/register")
	public String show(Model model) {
    model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,Model model) {
		//System.out.println(shipmentType.getClass().getName());
		
		    model.addAttribute("shipmentType",new ShipmentType());
		Integer id=service.saveShipment(shipmentType);
		//System.out.println(id);
		String message="shipment type'"+id+"'saved";
		model.addAttribute("message",message);
		return "ShipmentTypeRegister";

	}
	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model) {
		
		List<ShipmentType> list=service.getAllShipmentTypes();
		//System.out.println(list);
		model.addAttribute("list",list);
		
		return "ShipmentTypeData";
	}
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid") Integer id,Model model)
	
	{
		//System.out.println(id);
		service.deleteShipment(id);
		String message="shipmentType '"+id+"' is deleted";
		model.addAttribute("message",message);
		List<ShipmentType> list=service.getAllShipmentTypes();
		//System.out.println(list);
		model.addAttribute("list",list);
		
		return "ShipmentTypeData";
	}
	@RequestMapping("/edit")
	public String getOneShipment(@RequestParam("sid") Integer id,Model model) {
		
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType",st);
		
		return "ShipmentTypeEdit";
		
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
	service.updateShipmentType(shipmentType);
	String message="shipmentType '"+shipmentType.getShipmentId()+"' is updated";
	model.addAttribute("message",message);
	List<ShipmentType> list=service.getAllShipmentTypes();
	
	model.addAttribute("list",list);
	
	return "ShipmentTypeData";
	}
	@RequestMapping("/view")
	public String showView(@RequestParam("sid") Integer id,Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("ob",st);
		return "shipmentView";
		
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="sid",required=false) Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if(id==null) {
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list",list);
			} 
			else {
				ShipmentType st=service.getOneShipmentType(id);
				m.addObject("list",Arrays.asList(st));
			}
		return m;
		
	}
	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="sid",required=false) Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if(id==null) {
		List<ShipmentType> list=service.getAllShipmentTypes();
		m.addObject("list",list);
		} 
		else {
			ShipmentType st=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}
	@RequestMapping("/charts")
	public String showCharts() {
	List<Object[]> list=service.getShipmentModeCount();
	String path=context.getRealPath("/");
	util.generatePie(path, list);
	util.generateBar(path, list);
	return "ShipementTypeControllerCharts";
	
}
}