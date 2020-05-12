package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Order;
import in.nit.service.IOrderService;
import in.nit.view.OrderExcelView;
import in.nit.view.OrderPdfView;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private IOrderService service;
	@RequestMapping("/register")
	public String show(Model model) {
		
		model.addAttribute("order",new Order());
		
		return "OrderRegistration";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute Order order ,Model model) {
		Integer id=service.saveOrder(order);
		String message="Order with '"+id+"'saved";
		model.addAttribute("message",message);
		
		return "OrderRegistration";
	}
	@RequestMapping("/all")
	public String getAllOrders(Model model) {
		List<Order> list=service.getAllOrders();
		model.addAttribute("list",list);
		
		return "OrderData";
	}
	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("oId") Integer id,Model model) {
		service.deleteOrder(id);
		String message="shipmentType '"+id+"' is deleted";
		model.addAttribute("message",message);
		List<Order> list=service.getAllOrders();
		model.addAttribute("list",list);
		return "OrderData";
		
	}
	
	@RequestMapping("/edit")
	public String getOneOrder(@RequestParam("oId") Integer id,Model model) {
		Order or=service.getOneOrder(id);
		model.addAttribute("order",or);
		return "OrderEdit";
		
	}
	@RequestMapping("/update")
	public String updateOrder(Order order,Model model) {
		 service.updateOrder(order);
		 String message="Order '"+order.getOrderId()+"' is updated";
			model.addAttribute("message",message);
		List<Order> list=service.getAllOrders();
		model.addAttribute("list",list);
		return "OrderData";
		
	}
	@RequestMapping("/view")
	public String showView(@RequestParam("oId") Integer id,Model model) {
		Order or=service.getOneOrder(id);
		model.addAttribute("ob",or);
		return "OrderView";
		
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="oId",required=false) Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new OrderExcelView());
		if(id==null) {
		List<Order> list=service.getAllOrders();
		m.addObject("list",list);
		}
		else {
			Order or=service.getOneOrder(id);
			m.addObject("list",Arrays.asList(or));
		}
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="oId",required=false) Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new OrderPdfView());
		if(id==null) {
		List<Order> list=service.getAllOrders();
		m.addObject("list",list);
		}
		else {
			Order or=service.getOneOrder(id);
			m.addObject("list",Arrays.asList(or));
			
		}
		return m;
	}
}
