package in.nit.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.PurchaseDetails;
import in.nit.model.PurchaseOrder;
import in.nit.service.IPartService;
import in.nit.service.IPurchaseService;
import in.nit.service.IShipmentTypeService;
import in.nit.service.IWhUserService;
import in.nit.util.CommonUtil;


@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseService service;
	
	@Autowired 
	private IShipmentTypeService shipService;
	
	@Autowired
	private IPartService partService;
	
	@Autowired
	private IWhUserService userService;
	private void commonUi(Model model) {
		//shipment
		List<Object[]> shiplist = shipService.getShipIdAndShipCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shiplist);
		model.addAttribute("shipMap",shipMap);
		//whuser type
		List<Object[]> userlist = userService.getUserTypeAndCode("Vendor");
		Map<Integer,String> userMap=CommonUtil.convert(userlist);
		model.addAttribute("userMap",userMap);
		//part type
		List<Object[]> partList=partService.getOrderIdAndCode();
		Map<Integer,String> partMap=CommonUtil.convert(partList);
		System.out.println(partMap);
		model.addAttribute("partMap",partMap);
		
	}
	private void commonOb(Model model) {
		PurchaseOrder po= new PurchaseOrder();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder", po);
	}
	@RequestMapping("/register")
	public String show(Model model) {
		commonOb(model);
		commonUi(model);
		return "PurchaseOrderRegistration";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model model) {

		commonOb(model);
		commonUi(model);
		Integer id=service.savePurchaseOrder(purchaseOrder);
		
		String message="PurchaseOrder'"+id+"'saved";
		model.addAttribute("message",message);
		return "PurchaseOrderRegistration";

	}
	@RequestMapping("/all")
	public String getAllPurchaseOrders(Model model) {

		List<PurchaseOrder> list=service.getAllPurchaseOrderTypes();
		System.out.println(list);
		model.addAttribute("list",list);

		return "PurchaseOrderData";
	}
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("pid") Integer id,Model model)

	{
		//System.out.println(id);
		service.deletePurchaseOrder(id);;
		String message="PurchaseOrder '"+id+"' is deleted";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrderTypes();
		//System.out.println(list);
		model.addAttribute("list",list);

		return "PurchaseOrderData";
	}
	@RequestMapping("/edit")
	public String getOneShipment(@RequestParam("pid") Integer id,Model model) {
		commonOb(model);
		commonUi(model);
		PurchaseOrder st=service.getOnePurchaseOrderType(id);
		model.addAttribute("purchaseOrder",st);

		return "PurchaseOrderEdit";

	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model model) {
		commonUi(model);
		commonOb(model);
		service.updatePurchaseOrderType(purchaseOrder);;
		String message="PurchaseOrder '"+purchaseOrder.getPurchaseId()+"' is updated";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrderTypes();

		model.addAttribute("list",list);

		return "PurchaseOrderData";
	}
	//	}
	//	@RequestMapping("/view")
	//	public String showView(@RequestParam("pid") Integer id,Model model) {
	//		PurchaseOrder st=service.getOnePurchaseOrderType(id);
	//		model.addAttribute("ob",st);
	//		return "shipmentView";
	//		
	//	}
///=================that provides data required to UI SCREEN#2 i,e PurchaseDetails
	@RequestMapping("/parts")
	public String showChilds(@RequestParam("pid") Integer id,Model model) {
		//1.get One po
		
		PurchaseOrder po=service.getOnePurchaseOrderType(id);
		model.addAttribute("parent", po);
		//2.form backing objects
		model.addAttribute("purchaseDtl", new PurchaseDetails());
		commonUi(model);
		List<PurchaseDetails> childs=po.getChilds();
		int i=1; //slno setting
		for(PurchaseDetails dtl:childs) {
			i++;
			dtl.setSlno(i);
		}
		model.addAttribute("childs", childs);
		
		
		return "PurchaseParts";
		
	}
	@RequestMapping(value="/addPart",method=RequestMethod.POST)
	public String savePurchaseDtl(@ModelAttribute PurchaseDetails purchaseDtl,Model model) {
		
		service.savePurchaseDtl(purchaseDtl);
		model.addAttribute("purchaseDtl", new PurchaseDetails());
		Integer poId=purchaseDtl.getPo().getPurchaseId();
		service.updatePoStatus(poId, "PICKING");
		System.out.println(poId);
		return "redirect:parts?poId="+poId;
	}

}
