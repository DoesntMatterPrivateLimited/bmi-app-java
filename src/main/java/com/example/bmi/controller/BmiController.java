
package com.example.bmi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateBmi(@RequestParam double weight,
                               @RequestParam double height,
                               Model model) {
        double heightM = height / 100;
        double bmi = weight / (heightM * heightM);
        String category;
        if (bmi < 18.5) category = "Underweight";
        else if (bmi < 25) category = "Normal weight";
        else if (bmi < 30) category = "Overweight";
        else category = "Obese";

        model.addAttribute("bmi", String.format("%.2f", bmi));
        model.addAttribute("category", category);
        return "index";
    }
}
