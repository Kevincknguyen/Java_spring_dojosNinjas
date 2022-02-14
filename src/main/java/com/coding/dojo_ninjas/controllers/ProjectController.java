package com.coding.dojo_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.dojo_ninjas.models.Dojo;
import com.coding.dojo_ninjas.models.Ninja;
import com.coding.dojo_ninjas.services.DojoService;
import com.coding.dojo_ninjas.services.NinjaService;

@Controller
public class ProjectController {

	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String home(
			Model model,
			@ModelAttribute("dojo") Dojo dojo,
			@ModelAttribute("ninja") Ninja ninja
			
			) {
		
		List<Dojo> dojos=dojoService.allDojos();
		model.addAttribute("dojos",dojos);
		return "HomeAndAdd.jsp";
	}
	
	 
//	 CREATE DOJO
	 @PostMapping("/newDojo") 
	 public String newDojo(
			 @ Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result,
			 @ModelAttribute("ninja") Ninja ninja,
			 Model model)  {
		 
		 System.out.println(ninja.getFirstName());
		 if (result.hasErrors()) {
			 System.out.println("Does this redirect");
			 List<Dojo> dojos=dojoService.allDojos();
				model.addAttribute("dojos",dojos);
			 return "/HomeAndAdd.jsp";
		 }
		 dojoService.createDojo(dojo);
	 
		return "redirect:/" ;
	 }
	 
//	 CREATE NINJA
	 @PostMapping("/newNinja") 
	 public String newNinja(
			 @ Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result,
			 @ModelAttribute("dojo") Dojo dojo,
			  Model model)  {
		 
		 if (result.hasErrors()) {
			 System.out.println("Errors detected");
			 List<Dojo> dojos=dojoService.allDojos();
			model.addAttribute("dojos",dojos);
			model.addAttribute("dojo",new Dojo());
			 return "/HomeAndAdd.jsp";
		 }
		 System.out.println("Does it get here in the controller?");
		ninjaService.createNinja(ninja);
	 
		return "redirect:/" ;
	 }
	 
//	 DELETE DOJO
	 @DeleteMapping("/delete/dojo/{id}")
	 public String deleteDojo(@PathVariable("id")Long id) {
		 dojoService.deleteDojo(id);
		 return "redirect:/";
	 }
	 
	 
	 
//	 READ ONE AND RENDER TO EDIT PAGE
//	 @GetMapping("/expense/{id}") 
//	 public String oneExpense(Model model,@PathVariable("id") Long id){
//		 
//		 
//		 Expense expense=expenseService.findExpense(id);
//		 if (expense !=null) {
//			 
//			 model.addAttribute("expense", expense);
//			 return "OneExpense.jsp" ;
//		 }
//		 else {
//			 return "redirect:/expense";
//		 }
//	 }
	 
//	 READ ONE AND SHOW PAGE
	 @GetMapping("/dojo/show/{id}") 
	 public String showDojo(Model model,@PathVariable("id") Long id){
		 
		 
		 Dojo dojo=dojoService.findDojo(id);
		 if (dojo !=null) {
			 
			 List<Ninja> ninjas=ninjaService.allNinjasAtDojo(id);
			 model.addAttribute("dojo", dojo);
			 model.addAttribute("ninjas", ninjas);
			 return "ThisDojo.jsp" ;
		 }
		 else {
			 return "redirect:/";
		 }
	 }
	 
	 
//	 EDIT
//	 @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
//		public String editExpense(@PathVariable ("id")Long id,
//				@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
//			
//		 if (result.hasErrors()) {
//			 return "OneExpense.jsp";
//		 } else {
//			 expenseService.updateExpense(expense);
//			 return "redirect:/expense";
//		 }
//			
//			
//		}
}