package com.example.medicinksi_ustanovitest.Web.Servlet;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "DetailedView",value = "/MedicalLAB/{id}")
public class DetailedViewController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public DetailedViewController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }


    @GetMapping
    public String getDetailedView(Model model, @PathVariable int id ){
        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));
        return "Detailed View LAB";
    }


}
