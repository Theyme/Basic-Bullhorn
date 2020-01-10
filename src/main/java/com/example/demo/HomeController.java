package com.example.demo;
import java.io.IOException;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    TheymeRepository theymeRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listTheymes(Model model){
        model.addAttribute("theymes", theymeRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String theymeForm(Model model){
        model.addAttribute("theyme", new Theyme());
        return "theymeform";
    }
    @PostMapping("/add")
    public String processTheyme(@ModelAttribute Theyme theyme, @RequestParam("file")MultipartFile file){
//        if (file.isEmpty()){
//            return "redirect:/add";
//        }
        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            theyme.setHeadshot(uploadResult.get("url").toString());
            theymeRepository.save(theyme);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/add";
        }
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





            @PostMapping("/process")
            public String processForm (@Valid Theyme theyme, BindingResult result){
                if (result.hasErrors()) {
                    return "theymeform";
                }
                theymeRepository.save(theyme);
                return "redirect:/";
            }

        }

