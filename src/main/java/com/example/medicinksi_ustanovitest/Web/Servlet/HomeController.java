package com.example.medicinksi_ustanovitest.Web.Servlet;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "Home controller", value = "/home")
public class HomeController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public HomeController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("countAll", medicinski_ustanoviService.all());
        model.addAttribute("countCovid", medicinski_ustanoviService.covid());
        return "Home";
    }

}
