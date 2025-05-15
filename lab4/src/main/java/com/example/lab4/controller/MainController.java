package com.example.lab4.controller;

import com.example.lab4.service.FunctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(
            @RequestParam(defaultValue = "1.5") double a,
            @RequestParam(defaultValue = "0.8") double xStart,
            @RequestParam(defaultValue = "2.0") double xEnd,
            @RequestParam(defaultValue = "0.005") double dx,
            Model model) {

        model.addAttribute("a", a);
        model.addAttribute("xStart", xStart);
        model.addAttribute("xEnd", xEnd);
        model.addAttribute("dx", dx);
        model.addAttribute("values", FunctionService.calculateValues(xStart, xEnd, dx, a));

        return "index";
    }
}
