package com.example.medicinksi_ustanovitest.Web.Servlet;


import ch.qos.logback.core.layout.EchoLayout;
import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Controller
@RequestMapping(name = "DetailedView", value = "/MedicalLAB/{id}")
public class DetailedViewController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public DetailedViewController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }


    @GetMapping
    public String getDetailedView(Model model, @PathVariable int id) {
        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));
        return "Detailed View LAB";
    }

    @PostMapping("/test")
    public String postDetailedView(Model model, @PathVariable int id, HttpServletResponse resp,
                                   HttpServletRequest req) {
        HttpSession httpSession = req.getSession();

        String adresa = req.getParameter("adresa");
        httpSession.setAttribute("adresa", adresa);

        String izbranaAdresa = req.getParameter("izbranaAdresa");
        if (izbranaAdresa==null){
            izbranaAdresa="TEST IZBRANA ADRESA";
            model.addAttribute("izbranaAdresa", izbranaAdresa);
        }
        else {
            model.addAttribute("izbranaAdresa", izbranaAdresa);
        }
        httpSession.setAttribute("izbranaAdresaSesija",izbranaAdresa );
        model.addAttribute("izbranaAdresa1",httpSession.getAttribute("izbranaAdresaSesija"));

        model.addAttribute("adresa", httpSession.getAttribute("adresa"));

        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));

        return "Detailed View LAB";
    }

//    @PostMapping("/route")
//    public String postRouteDetailedView(Model model, @PathVariable int id, HttpServletResponse resp,
//                                        HttpServletRequest req) {
//        HttpSession httpSession = req.getSession();
//        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));
//        String izbranaAdresa = req.getParameter("izbranaAdresa");
//        httpSession.setAttribute("izbranaAdresaSesija",izbranaAdresa );
//
//        model.addAttribute("izbranaAdresa1",httpSession.getAttribute("izbranaAdresaSesija"));
////        Double lat_adresa = Double.parseDouble(izbranaAdresa.split(",")[5].split(" ")[1]);
////        Double lng_adresa = Double.parseDouble(izbranaAdresa.split(",")[6].split(" ")[1]);
////        model.addAttribute("lat_adresa", lat_adresa);
////        model.addAttribute("lng_adresa", lng_adresa);
//
//        return "Detailed View LAB";
//    }


}
