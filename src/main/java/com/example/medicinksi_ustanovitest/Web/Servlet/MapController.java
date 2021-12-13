package com.example.medicinksi_ustanovitest.Web.Servlet;

import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(name = "Map View",value = "/map")
public class MapController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public MapController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getMapPage(Model model){
        model.addAttribute("Covid19TestingUstanovi", medicinski_ustanoviService.findAllCovid19TestingLabs());
        model.addAttribute("Ustanovi", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        return "Map View";
    }

}
