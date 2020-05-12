package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Part;
import in.nit.service.IOrderService;
import in.nit.service.IPartService;
import in.nit.service.IUomService;
import in.nit.util.CommonUtil;

@RequestMapping("/part")
@Controller
public class PartController {
	@Autowired
	private IPartService service;
	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderService orderService;
	
	

	private void commonUi(Model model) {
		List<Object[]> uomlist = uomService.getUomIdAndModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomlist);
		model.addAttribute("uomMap",uomMap);
		
		List<Object[]> OmSalelist = orderService.getOrderIdAndCode("Sale");
		Map<Integer,String> omSaleMap=CommonUtil.convert(OmSalelist);
		model.addAttribute("omSaleMap",omSaleMap);
		
		List<Object[]> omPurcasheList=orderService.getOrderIdAndCode("Purchase");
		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurcasheList);
		model.addAttribute("omPurchaseMap", omPurchaseMap);
	}
	@RequestMapping("/register")
	public String show(Model model) {
	
		model.addAttribute("part", new Part());
		commonUi(model);
		return "PartRegistration";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute Part part ,Model model) {
		commonUi(model);
		model.addAttribute("part", new Part());
		Integer id=service.savePart(part);
		
		String message="part with '"+id+"'saved";
		
		model.addAttribute("message",message);
		
		return "PartRegistration";
	}
	@RequestMapping("/all")
	public String getAllParts(Model model) {
		commonUi(model);
		List<Part> list=service.getAllParts();
		
		model.addAttribute("list",list);
        return "PartData";
	}

}
