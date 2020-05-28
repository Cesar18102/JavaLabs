package oleh.kyrychenko.lab3.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController {
    @RequestMapping(value = "/error/{code}")
    public String renderErrorPage(Model model, @PathVariable("code") String code) {
        model.addAttribute("code", code);
        return "error";
    }
}
