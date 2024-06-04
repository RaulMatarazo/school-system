package com.api.escolaapi;

import com.api.escolaapi.aluno.AlunoClass;
import com.api.escolaapi.aluno.AlunoController;
import com.api.escolaapi.aluno.DTOs.AlunoDTOGet;
import com.api.escolaapi.professor.DTOs.ProfessorDTOGet;
import com.api.escolaapi.professor.ProfessorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TemplatesController {

    @Autowired
    private AlunoController alunoController;

    @Autowired
    private ProfessorController professorController;

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

    @GetMapping("/listar-professores")
    public String showListAllTeachersTemplate(Model model){
        List<ProfessorDTOGet> professores = professorController.visualizar();
        model.addAttribute("professores", professores);
        return "listarProfessores";
    }

    @GetMapping("/editar-aluno/{id}")
    public String showEditStudentTemplate(@PathVariable int id, Model model){
        model.addAttribute("alunoId", id);
        return "editarAluno";
    }

    @GetMapping("/editar-professor/{id}")
    public String showEditTeacherTemplate(@PathVariable int id, Model model){
        model.addAttribute("professorId", id);
        return "editarProfessor";
    }
}
