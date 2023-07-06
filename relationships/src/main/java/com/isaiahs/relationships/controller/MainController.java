package com.isaiahs.relationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isaiahs.relationships.models.Dojo;
import com.isaiahs.relationships.models.Ninja;
import com.isaiahs.relationships.services.DojoService;
import com.isaiahs.relationships.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("newDojo") Dojo newDojo, Model viewModel) {
		viewModel.addAttribute("allTheDojos", dojoService.allDojos());
		return "index.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allTheDojos", dojoService.allDojos());
			return "index.jsp";
		}
		this.dojoService.createDojo(newDojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/ninjas/new")
	public String index(@ModelAttribute("newNinja") Ninja newNinja, Model viewModel) {
		viewModel.addAttribute("allTheDojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allTheDojos", dojoService.allDojos());
			return "newNinja.jsp";
		}
		this.ninjaService.createNinja(newNinja);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("/dojos/{dojoId}")
	public String viewDojo(@PathVariable("dojoId") Long id, Model viewModel) {
		viewModel.addAttribute("dojo", dojoService.findDojo(id));
		return "ninjaLocation.jsp";
	}
}
