package com.api.escolaapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/")
public class WelcomeController {
    @GetMapping
    public String showWelcomeTemplate(){
        return "welcome";
    }
}
