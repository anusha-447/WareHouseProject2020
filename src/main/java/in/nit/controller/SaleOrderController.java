package in.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.SaleOrder;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {
	
	@RequestMapping("/register")
	public String show(Model model) {
		
		model.addAttribute("saleOrder", new SaleOrder());
		
		return "SaleOrderRegistartion";
	}

}
