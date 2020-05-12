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

import in.nit.model.WhUserType;
import in.nit.service.IWhUserService;
import in.nit.view.WhUserExcelView;
import in.nit.view.WhUserPdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserService service;
	
	@RequestMapping("/register")
	public String showWhUserPage(Model model) {
		model.addAttribute("user" ,new WhUserType());
		return "WhUserTypeRegistration";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute WhUserType whuserType,Model model ) {
		model.addAttribute("user" ,new WhUserType());
	Integer id=service.saveWhUser(whuserType);
	String msg="user saved '"+id+"' successfully";
	model.addAttribute("msg",msg);
	return "WhUserTypeRegistration";
	}
	@RequestMapping("/all")
	public String getAllUser(Model model) {
		List<WhUserType> list=service.getAllWhUsers();
		model.addAttribute("list",list);
		return "WhUserData";
	}
	@RequestMapping("/delete")
	public String deleteWhUser(@RequestParam("uid") Integer id,Model model) {
		
		service.deleteWhUser(id);
		String msg="WhUser '"+id+"' deleted";
		model.addAttribute("msg",msg);
		List<WhUserType> list=service.getAllWhUsers();
		model.addAttribute("list",list);
		return "WhUserData";
	}
	@RequestMapping("/edit")
	public String getOneWhUsser(@RequestParam("uid") Integer id,Model model) {
		WhUserType wuser=service.getOneWhUser(id);
		model.addAttribute("user",wuser);
		return "WhUserTypeEdit";
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public  String updateWhUser(@ModelAttribute WhUserType user, Model model) {
		service.updateWhuser(user);
		String msg="WhUser '"+user.getUserId()+"' updated";
		model.addAttribute("msg",msg);
		List<WhUserType> list=service.getAllWhUsers();
		model.addAttribute("list",list);
		return "WhUserData";
	}
	@RequestMapping("/view")
	public String showView(@RequestParam("uid") Integer id,Model model) {
		WhUserType wuser=service.getOneWhUser(id);
		model.addAttribute("ob",wuser);
		return "WhUserView";
		
	}
	@RequestMapping("/excel")
	public ModelAndView showexcel(@RequestParam (value="uid",required=false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new WhUserExcelView());
		
		if(id==null) {
			List<WhUserType> list=service.getAllWhUsers();
			m.addObject("list",list);
		}
		else {
			WhUserType wuser=service.getOneWhUser(id);
			m.addObject("list",Arrays.asList(wuser));
		}
		
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam (value="uid",required=false)Integer id) {
		ModelAndView m= new ModelAndView();
		m.setView(new WhUserPdfView());
		
		if(id==null) {
			List<WhUserType> list=service.getAllWhUsers();
			m.addObject("list",list);
		}
		else {
			WhUserType wuser=service.getOneWhUser(id);
			m.addObject("list",Arrays.asList(wuser));
		}
		
		return m;
	}
}
