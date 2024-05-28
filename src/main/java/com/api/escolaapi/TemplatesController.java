package com.api.escolaapi;

import com.api.escolaapi.aluno.AlunoClass;
import com.api.escolaapi.aluno.AlunoController;
import com.api.escolaapi.aluno.DTOs.AlunoDTOGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TemplatesController {

    @Autowired
    private AlunoController alunoController;

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

    @GetMapping("/listar-alunos")
    public String showListAllStudentsTemplate(Model model){
        List<AlunoDTOGet> alunos = alunoController.listar();
        model.addAttribute("alunos", alunos);
        return "listarAlunos";
    }
}
