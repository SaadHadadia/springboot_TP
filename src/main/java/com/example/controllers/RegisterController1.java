package com.example.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.config.ManageLogins;

//@Controller
public class RegisterController1 {

	//@RequestMapping(method =)
	@GetMapping("/")
	public String getRegisteryForm() {
		return "inscription";
	}
//	@PostMapping("/registry")
//	public String getDataRegistryForm(@RequestParam String login, @RequestParam String mdp, Model model)
//	{
//		System.out.println(login+"---"+mdp);
//		model.addAttribute("identifiant", login);
//		return "login";
//	}
	@PostMapping("/registry")
	//public ModelAndView getDataRegistryForm(@RequestParam String login, @RequestParam String mdp)
		//	System.out.println(login+"---"+mdp);
	public ModelAndView getDataRegistryForm(@RequestParam Map<String,String> allParams)
	{
		//System.out.println(allParams.get("login")+"---"+allParams.get("mdp"));
		ModelAndView model = new ModelAndView();
		
		//gerer la liste 
		//ManageLogins manageLogins = new ManageLogins();
		//model.addObject("identifiant", allParams.get("login"));
		model.addObject("logins", ManageLogins.instance.addLogin(allParams.get("login"),allParams.get("mdp")));
		
		// la page ou on veut forward the data
		model.setViewName("logins");
		
		return model;
	}
}
