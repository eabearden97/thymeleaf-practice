package learn.thymeleaf.controller;

import learn.thymeleaf.domain.EncouragementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class thymeleafUIController {

    @Autowired
    EncouragementService encouragementService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/encouragement")
    public String encouragement(Model model) {
        String encouragement = encouragementService.getRandomEncouragement();
        model.addAttribute("encouragement", encouragement);
        return "encouragement";
    }

    @GetMapping("/personalizedEncouragement")
    public String getPersonalized() {
        return "personalizedEncouragement";
    }

    @PostMapping("/personalizedEncouragement")
    public String handleGetPersonName(Model model, String personName) {
        String personalizedEncouragement = encouragementService.getPersonalizedEncouragement(personName);
        model.addAttribute("personalizedEncouragement", personalizedEncouragement);
        return "personalizedEncouragement";
    }


}
