package oleh.kyrychenko.lab2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {
    @RequestMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>(
            "Oleh Kyrychenko, SE-17-1, My FIRST Spring App",
                HttpStatus.OK
        );
    }
}
