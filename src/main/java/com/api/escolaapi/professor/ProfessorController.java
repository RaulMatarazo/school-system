package com.api.escolaapi.professor;

import com.api.escolaapi.aluno.AlunoClass;
import com.api.escolaapi.aluno.DTOs.AlunoDTOPut;
import com.api.escolaapi.professor.DTOs.ProfessorDTO;
import com.api.escolaapi.professor.DTOs.ProfessorDTOGet;
import com.api.escolaapi.professor.DTOs.ProfessorDTOPut;
import com.api.escolaapi.repositorys.ProfessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.*;
import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping("/professores")
    @ResponseBody
    @Transactional
    public ResponseEntity<String> cadastrar(ProfessorDTO dados) {
        var email = repository.findByEmail(dados.email());
        var telefone = repository.findByTelefone(dados.telefone());
        if (email.isEmpty() && telefone.isEmpty()){
            repository.save(new ProfessorClass(dados));
            System.out.println("Professor criado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Professor criado com sucesso!");
        } else {
            System.out.println("Erro ao criar o professor");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao criar o Professor");
        }
    }

    @GetMapping("/professores")
    public List<ProfessorDTOGet> visualizar() {
        return repository.findAllByAtivoTrue().stream().map(ProfessorDTOGet::new).toList();
    }

    @GetMapping("/professores-desativados")
    public List<ProfessorDTOGet> visualizarDesativados() {
        return repository.findAllByAtivoFalse().stream().map(ProfessorDTOGet::new).toList();
    }

    @PutMapping("/editar-professor/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@PathVariable int id, @ModelAttribute ProfessorDTOPut dados) {
        var email = repository.findByEmail(dados.email());
        var telefone = repository.findByTelefone(dados.telefone());
        if (email.isEmpty() && telefone.isEmpty()){
            var professor = repository.getReferenceById(id);
            professor.atualizarInformacoes(dados);
            System.out.println("Professor editado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Professor editado com sucesso!");
        } else {
            System.out.println("Erro ao editar o professor");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao editar o professor");
        }
    }

    @DeleteMapping("/deletar-professor/{id}")
    @Transactional
    public String deletar(@PathVariable int id){
        repository.deleteById(id);

        return "redirect:/listar-professores";
    }

    @DeleteMapping("/inativar-professor/{id}")
    @Transactional
    public String inativar(@PathVariable int id){
        var professor = repository.getReferenceById(id);
        professor.desativar();
        return "redirect:/listar-professores";
    }

    // Método HTTP PUT
    @PutMapping("/ativar-professor/{id}")
    @Transactional
    public String ativar(@PathVariable int id){
        var professor = repository.getReferenceById(id);
        professor.ativar();
        return "redirect:/listar-professores-desativados";
    }

}
