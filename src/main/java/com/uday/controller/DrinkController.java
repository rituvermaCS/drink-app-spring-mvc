package com.uday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uday.model.Drink;
import com.uday.service.DrinkService;

@Controller
@RequestMapping("/drink")

public class DrinkController {

	@Autowired
	private DrinkService service;
	
	@RequestMapping("/display")
	public ModelAndView displayDrinkInfo() {
		
		ModelAndView mv = new ModelAndView("displayDrink");
		
		List<Drink> drinks = service.displayDrink();
		
		mv.addObject("drinks", drinks);
		
		return mv;
	}
	
	@RequestMapping("/addDrink")
	public ModelAndView addDrink() {
		
		ModelAndView mv = new ModelAndView("addDrink");
		Drink drink = new Drink();
		
		mv.addObject("command", drink);
		
		return mv;
	}
	@RequestMapping(value = "/saveDrink", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("drink") Drink drink) {
		
		ModelAndView mv = new ModelAndView("displayDrink");
		service.addDrink(drink);
		List<Drink> drinks = service.displayDrink();
		mv.addObject("drinks", drinks);
		mv.addObject("msg", drink.getName() + " added successfully");
		return mv;
		
	}
	
	@RequestMapping(value = "/editForm/{id}")
	public ModelAndView editForm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editForm");
		Drink drink = service.getDrinkId(id);
		mv.addObject("command",drink);
		return mv;
		
	}
	
	@RequestMapping(value = "/editForm/editSave", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("drink") Drink drink)
	{
		service.update(drink);
		return "redirect:/drink/display"; 
	}
	
	   @RequestMapping(value="/DeleteForm/{id}",method = RequestMethod.GET)    
	    public String DeleteForm(@PathVariable int id){    
	        service.delete(id);    
	        return "redirect:/drink/display";    
	    }     

}
