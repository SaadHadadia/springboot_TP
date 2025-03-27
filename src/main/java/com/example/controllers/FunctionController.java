package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FunctionController {
    @GetMapping("functions/{id:.+}")
    public ModelAndView functionView(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("functions");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping("updateuserfunctions")
    public ModelAndView updateUserFunctions(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView("functions");
        modelAndView.addObject("id", id);
        return modelAndView;
    }
}