package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Login;
import com.example.model.ManageLogins;
import com.example.repositories.LoginRepository;

@Controller
public class RegisterController {
	
	//injection des dependences
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/")
	public String getRegisteryForm() {
		return "inscription";
	}

	@PostMapping("/registry")
	public ModelAndView getDataRegistryForm(@RequestParam Map<String,String> allParams)
	{
		ModelAndView model = new ModelAndView();
		model.addObject("logins", ManageLogins.instance.addLogin(allParams.get("login"),allParams.get("mdp")));
		
		//Persistence des objets login
		loginRepository.save(new Login(allParams.get("login"),allParams.get("mdp")));

//		Optional<Login> l = loginRepository.findById(allParams.get("login"));
//		if(l.isPresent()) {
//			System.out.println(l);
//		}else{
//			System.out.println("inexistant");
//
//		}
		//List<Login> list = loginRepository.findByLoginAndMdp("test", "s");
		List<Login> list = loginRepository.findByLoginAndMdp(allParams.get("login"),allParams.get("mdp"));
		for(Object log : list) {
			System.out.println(((Login) log).getLogin()+ " - " + ((Login) log).getMdp());
		}
		
		
		model.setViewName("logins");
		return model;
	}
}
