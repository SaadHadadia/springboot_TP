package com.example.controllers;

import java.util.List;
import java.util.Map;

import com.example.model.*;
import com.example.repositories.AffectationRepository;
import com.example.repositories.FonctionRepository;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.config.ManageLogins;
import com.example.repositories.LoginRepository;

@Controller
public class RegisterController {

    //injection des dependences
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FonctionRepository fonctionRepository;

    @Autowired
    AffectationRepository affectationRepository;

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

        // Tests
        for(Object o : userRepository.getAllLogins()){
            System.out.println(((Login) o ).getLogin());
        }

        for(Object o : userRepository.getInfoUsers()){
            System.out.println(o);
        }

        // Ajout des affectations
        User user = new User("nom3","grade3");
        userRepository.save(user);
        Fonction fonction = new Fonction();
        fonction.setLibelle("informaticen");
        AffectationId affectationId= new AffectationId(
                userRepository.findByNom("nom3").get(0).getId(),
                "informaticen"
        );
        Affectation affectation = new Affectation(affectationId, "01-01-2025", "01-01-2025");
        fonctionRepository.save(fonction);
        affectationRepository.save(affectation);

        return model;
    }
}
