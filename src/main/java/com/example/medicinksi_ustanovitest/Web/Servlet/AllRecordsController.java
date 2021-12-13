package com.example.medicinksi_ustanovitest.Web.Servlet;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "All Records Controller",value = "/MedicalLAB")
public class AllRecordsController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public AllRecordsController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getAllMedicalLabPage(Model model){
        model.addAttribute("Ustanovi", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        return "All Records";
    }
}
