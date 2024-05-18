package com.api.escolaapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {
    @GetMapping("/")
    public String showWelcomeTemplate(){
        return "home";
    }

    @GetMapping("/cadastrar-aluno")
    public String showCreateNewStudentTemplate(){
        return "cadastrarAluno";
    }

    @GetMapping("/cadastrar-professor")
    public String showCreateNewTeacherTemplate(){
        return "cadastrarProfessor";
    }
}
