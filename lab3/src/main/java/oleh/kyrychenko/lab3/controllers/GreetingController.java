package oleh.kyrychenko.lab3.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Oleh Kyrychenko" );
        model.addAttribute("group", "SE-17-1" );
        return "greeting";
    }
}
