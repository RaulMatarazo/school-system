package com.api.escolaapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String showWelcomeTemplate(){
        return "welcome";
    }

    @GetMapping("/cadastrar-aluno")
    public String showCreateNewStudentTemplate(){
        return "cadastrarAluno";
    }
}
