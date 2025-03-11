package com.example.controllers;

import java.util.List;
import java.util.Map;

import com.example.model.User;
import com.example.repositories.UserRepository;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Login;
import com.example.config.ManageLogins;
import com.example.repositories.LoginRepository;

@Controller
public class RegisterController {
	
	//injection des dependences
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	UserRepository userRepository;
	
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

		List<Login> list = loginRepository.findByLoginAndMdp(allParams.get("login"),allParams.get("mdp"));
		for(Object log : list) {
			System.out.println(((Login) log).getLogin()+ " - " + ((Login) log).getMdp());
		}

		model.setViewName("logins");

		// Add users
		User u1 = new User("Saad","isi");
		User u2 = new User("walid","ai");
		Login lg1 = new Login("saad@1","1234567890");
		Login lg2 = new Login("saad@2","1234567890");
		Login lg3 = new Login("walid@1","1234567890");

		lg1.setUser(u1);
		lg2.setUser(u1);
		lg3.setUser(u2);

		userRepository.save(u1);
		userRepository.save(u2);

		loginRepository.save(lg1);
		loginRepository.save(lg2);
		loginRepository.save(lg3);

		// Test
		for(Object o : userRepository.getAllLogins()){
			System.out.println(((Login) o ).getLogin());
		}

		return model;
	}
}
