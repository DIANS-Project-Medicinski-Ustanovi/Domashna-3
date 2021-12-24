package com.example.medicinksi_ustanovitest.Web.Servlet;

import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;


@Controller
@RequestMapping(name = "Map View", value = "/map")
public class MapController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public MapController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getMapPage(Model model) {

        model.addAttribute("AllCovid19TestingLabs", medicinski_ustanoviService.findAllCovid19TestingLabs());
        model.addAttribute("AllMedicalLabs", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        model.addAttribute("AllNotCovid19TestingLabs", medicinski_ustanoviService.findAllNotCovid19Testing());
        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("medicinski", medicinski_ustanoviService.testList());

        return "Map View";
    }

    @PostMapping
    public String postMapPage(Model model, HttpServletRequest req, HttpServletResponse resp) {

        String category = req.getParameter("category");
        String city = req.getParameter("city");
        String covidTest = req.getParameter("covidTest");

        model.addAttribute("MedicalLabsByAllFilters",
                medicinski_ustanoviService.getMedicalLabsByFilter(category,city,covidTest));
        model.addAttribute("AllCovid19TestingLabs", medicinski_ustanoviService.findAllCovid19TestingLabs());
        model.addAttribute("AllMedicalLabs", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        model.addAttribute("AllNotCovid19TestingLabs", medicinski_ustanoviService.findAllNotCovid19Testing());
        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("filteredList", (medicinski_ustanoviService.getMedicalLabsByFilter(category, city, covidTest)));
        model.addAttribute("medicinski", medicinski_ustanoviService.testList());

        return "Map View";
    }
}
