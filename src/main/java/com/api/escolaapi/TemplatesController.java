package com.api.escolaapi;

import com.api.escolaapi.aluno.AlunoController;
import com.api.escolaapi.aluno.DTOs.AlunoDTOGet;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTOGet;
import com.api.escolaapi.funcionario.FuncionarioClass;
import com.api.escolaapi.funcionario.FuncionarioController;
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

    @Autowired
    private FuncionarioController funcionarioController;

    @GetMapping("/login")
    public String login(){
        return "/templates outros/login";
    }

    @GetMapping("/")
    public String home(){
        return "/templates outros/home";
    }

    @GetMapping("/cadastrar-aluno")
    public String cadastrarAluno(){
        return "/templates alunos/cadastrarAluno";
    }

    @GetMapping("/listar-alunos")
    public String listarAlunosAtivados(Model model){
        List<AlunoDTOGet> alunos = alunoController.listar();
        model.addAttribute("alunos", alunos);
        return "/templates alunos/listarAlunos";
    }

    @GetMapping("/editar-aluno/{id}")
    public String editarAluno(@PathVariable int id, Model model){
        model.addAttribute("alunoId", id);
        return "/templates alunos/editarAluno";
    }

    @GetMapping("/listar-alunos-desativados")
    public String listarAlunosDesativados(Model model){
        List<AlunoDTOGet> alunos = alunoController.listarDesativados();
        model.addAttribute("alunos", alunos);
        return "/templates alunos/listarAlunosDesativados";
    }

    // -------------------------------------------------------------------------------

    @GetMapping("/cadastrar-professor")
    public String cadastrarProfessor(){
        return "/templates professores/cadastrarProfessor";
    }

    @GetMapping("/listar-professores")
    public String listarProfessoresAtivados(Model model){
        List<ProfessorDTOGet> professores = professorController.visualizar();
        model.addAttribute("professores", professores);
        return "/templates professores/listarProfessores";
    }

    @GetMapping("/editar-professor/{id}")
    public String editarProfessor(@PathVariable int id, Model model){
        model.addAttribute("professorId", id);
        return "/templates professores/editarProfessor";
    }

    @GetMapping("/listar-professores-desativados")
    public String listarProfessoresDesativados(Model model){
        List<ProfessorDTOGet> professores = professorController.visualizarDesativados();
        model.addAttribute("professores", professores);
        return "/templates professores/listarProfessoresDesativados";
    }

    // -------------------------------------------------------------------------------

    @GetMapping("/cadastrar-funcionario")
    public String cadastrarFuncionario(){
        return "/templates funcionarios/cadastrarFuncionario";
    }

    @GetMapping("/listar-funcionarios")
    public String listarFuncionariosAtivados(Model model){
        List<FuncionarioDTOGet> funcionarios = funcionarioController.visualizar();
        model.addAttribute("funcionarios", funcionarios);
        return "/templates funcionarios/listarFuncionarios";
    }

    @GetMapping("/editar-funcionario/{id}")
    public String editarFuncionario(@PathVariable int id, Model model){
        model.addAttribute("funcionarioId", id);
        return "/templates funcionarios/editarFuncionario";
    }

    @GetMapping("/listar-funcionarios-desativados")
    public String listarFuncionariosDesativados(Model model){
        List<FuncionarioDTOGet> funcionario = funcionarioController.visualizarDesativados();
        model.addAttribute("funcionarios", funcionario);
        return "/templates funcionarios/listarFuncionariosDesativados";
    }
}
