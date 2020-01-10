package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
public class HomeController {
    @Autowired
    TheymeRepository theymeRepository;

    @RequestMapping("/")
    public String listTheymes(Model model){
        model.addAttribute("theyme", theymeRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String theymeForm(Model model){
        model.addAttribute("theyme", new Theyme());
        return "theymeform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Theyme theyme, BindingResult result) {
        if (result.hasErrors()) {
            return "theymeform";
        }
        theymeRepository.save(theyme);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String theyme(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("theyme", theymeRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateTheyme(@PathVariable("id") long id, Model model){
        model.addAttribute("theyme", theymeRepository.findById(id).get());
        return "theymeform";

    }
    @RequestMapping("/delete/{id}")
    public String delTheyme(@PathVariable("id") long id){
        theymeRepository.deleteById(id);
        return "redirect:/";
    }
}
