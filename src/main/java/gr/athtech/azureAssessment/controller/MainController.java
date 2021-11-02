package gr.athtech.azureAssessment.controller;

import gr.athtech.azureAssessment.model.Visitor;
import gr.athtech.azureAssessment.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    VisitorService visitorService;

    @GetMapping("/")
    public String index(Model model) {
        List<Visitor> visitors = visitorService.findVisitors();
        if (visitors != null) {
            model.addAttribute("visitors", visitors);
        }
        return "index";
    }

    @PostMapping("/visitor/add")
    public String addItem(@RequestParam String name) {
        visitorService.saveVisitor(new Visitor(name));
        return "redirect:/";
    }
}
