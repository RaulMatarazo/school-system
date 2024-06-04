package com.api.escolaapi.aluno;

import com.api.escolaapi.aluno.DTOs.AlunoDTO;
import com.api.escolaapi.aluno.DTOs.AlunoDTOGet;
import com.api.escolaapi.aluno.DTOs.AlunoDTOPut;
import com.api.escolaapi.repositorys.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping("/alunos")
    @ResponseBody
    @Transactional
    public RedirectView cadastrar(AlunoDTO dados) {
        repository.save(new AlunoClass(dados));
        return new RedirectView("/cadastrar-aluno");
    }

    @GetMapping("/alunos")
    public List<AlunoDTOGet> listar() {
        return repository.findAll().stream().map(AlunoDTOGet::new).toList();
    }

    @PutMapping("/editar-aluno/{id}")
    @Transactional
    public String atualizar(@PathVariable int id, @ModelAttribute AlunoDTOPut dados, BindingResult result) {
        if (result.hasErrors()) {
            return "editarAluno";
        }
        var aluno = repository.getReferenceById(id);
        aluno.atualizarInformacoes(dados);
        return "redirect:/listar-alunos";
    }

    @DeleteMapping("/deletar-aluno/{id}")
    @Transactional
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/listar-alunos";
    }

    @DeleteMapping("/inativar-aluno/{id}")
    @Transactional
    public void inativar(@PathVariable int id){
        var aluno = repository.getReferenceById(id);
        aluno.desativar();
    }

    @PutMapping("/ativar-aluno/{id}")
    @Transactional
    public void ativar(@PathVariable int id){
        var aluno = repository.getReferenceById(id);
        aluno.ativar();
    }

}
