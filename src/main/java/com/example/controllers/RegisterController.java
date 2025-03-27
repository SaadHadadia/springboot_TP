package com.example.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisteryForm() {
        return "register";
    }

    @PostMapping("/login")
    public ModelAndView getDataLoginForm(@RequestParam Map<String,String> allParams){
        ModelAndView model = new ModelAndView();
        List<Login> list = loginRepository.findByLoginAndMdp(allParams.get("login"),allParams.get("mdp"));
        if (list.size()>0){
            List<Login> logins = loginRepository.findAll();
            model.addObject("logedusers",ManageLogins.instance.addLogin(allParams.get("login"),allParams.get("mdp")));
            model.addObject("users", userRepository.getInfoUsers());
            model.addObject("currentlogeduser",allParams.get("login"));
            model.setViewName("loginsList");
        }else{
            model.addObject("Error","Identifiants incorrects");
            model.setViewName("login");
        }
        return model;
    }

    @PostMapping("/register")
    public ModelAndView getDataRegistryForm(@RequestParam Map<String,String> allParams) throws ParseException {
        ModelAndView model = new ModelAndView();
        List<Login> list = loginRepository.findByLogin(allParams.get("login"));
        if (list.size()>0){
            model.addObject("Error","Identifiant existe déjà");
            model.setViewName("register");
            return model;
        }

        try {
            // Create and save the user
            User user = new User("saad", "junior");
            userRepository.save(user);

            // Create login with reference to saved user
            Login login = new Login(allParams.get("login"), allParams.get("mdp")); 
            login.setUser(user);
            loginRepository.save(login);

            // Create and save the fonction
//            Fonction fonction = new Fonction("developer");
//            fonctionRepository.save(fonction);

            // Create affectation with composite key
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            Affectation affectation = new Affectation();
//            AffectationId affectationId = new AffectationId(user.getId(), fonction.getLibelle());
//            affectation.setId(affectationId);
//            affectation.setUser(user);
//            affectation.setFonction(fonction);
//            affectation.setDb(dateFormat.parse("01-01-2025"));
//            affectation.setDf(dateFormat.parse("23-03-2025"));
//            affectationRepository.save(affectation);
            
            model.setViewName("register");
            model.addObject("Success", "Inscrit avec succès");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addObject("Error", "Une erreur s'est produite lors de l'enregistrement");
            model.setViewName("register");
        }
        
        return model;
    }

    @PostMapping("/logout")
    public ModelAndView logout(@RequestParam Map<String,String> allParams){
        ModelAndView model = new ModelAndView();
        ManageLogins.instance.deleteLogin(allParams.get("currentlogeduser"));
        model.setViewName("login");
        return model;
    }

    @PostMapping("/myProfile")
    public ModelAndView getProfileForm(@RequestParam Map<String,String> allParams) {
        ModelAndView model = new ModelAndView();
        String currentlogeduser = allParams.get("currentlogeduser");
        User user = userRepository.getDetailsUser(currentlogeduser);
        model.addObject("user", user);
        model.addObject("currentlogeduser", currentlogeduser);
        model.setViewName("myProfile");
        return model;
    }

    @PostMapping("/updateprofile")
    public ModelAndView updateProfile(@RequestParam Map<String, String> allParams) {
        ModelAndView model = new ModelAndView();
        try {
            String currentlogeduser = allParams.get("currentlogeduser");
            User user = userRepository.getDetailsUser(currentlogeduser);

            if (user == null) {
                model.addObject("error", "User not found");
                model.setViewName("myProfile");
                return model;
            }

            // Validate input fields
            String username = allParams.get("username");
            String grade = allParams.get("grade");

            if (username == null || username.trim().isEmpty()) {
                model.addObject("error", "Username cannot be empty");
                model.setViewName("myProfile");
                return model;
            }

            if (grade == null || grade.trim().isEmpty()) {
                model.addObject("error", "Grade cannot be empty");
                model.setViewName("myProfile");
                return model;
            }

            // Update user information
            user.setNom(username.trim());
            user.setGrade(grade.trim());

            // Save the updated user
            userRepository.save(user);

            // Refresh the page with updated data
            model.addObject("user", user);
            model.addObject("currentlogeduser", currentlogeduser);
            model.addObject("success", "Profile updated successfully");
            model.setViewName("myProfile");
        } catch (Exception e) {
            model.addObject("error", "An error occurred while updating the profile: " + e.getMessage());
            model.setViewName("myProfile");
        }
        return model;
    }

    @PostMapping("/changePassword")
    public ModelAndView changePassword(@RequestParam Map<String, String> allParams) {
        ModelAndView model = new ModelAndView();
        try {
            String currentlogeduser = allParams.get("currentlogeduser");
            String currentPassword = allParams.get("currentPassword");
            String newPassword = allParams.get("newPassword");
            String confirmPassword = allParams.get("confirmPassword");

            // Validate input fields
            if (currentPassword == null || currentPassword.trim().isEmpty() ||
                newPassword == null || newPassword.trim().isEmpty() ||
                confirmPassword == null || confirmPassword.trim().isEmpty()) {
                model.addObject("error", "All fields are required");
                model.setViewName("myProfile");
                return model;
            }

            if (!newPassword.equals(confirmPassword)) {
                model.addObject("error", "New password and confirmation do not match");
                model.setViewName("myProfile");
                return model;
            }

            // Fetch the user by login
            Login login = loginRepository.findByLogin(currentlogeduser).stream().findFirst().orElse(null);
            if (login == null) {
                model.addObject("error", "User not found");
                model.setViewName("myProfile");
                return model;
            }

            // Check if the current password matches
            if (!login.getMdp().equals(currentPassword)) {
                model.addObject("error", "Current password is incorrect");
                model.setViewName("myProfile");
                return model;
            }

            // Update the password
            login.setMdp(newPassword);
            loginRepository.save(login);

            model.addObject("success", "Password changed successfully");
            model.setViewName("myProfile");
        } catch (Exception e) {
            model.addObject("error", "An error occurred while changing the password: " + e.getMessage());
            model.setViewName("myProfile");
        }
        return model;
    }

}
