package com.api.escolaapi.aluno;

import com.api.escolaapi.aluno.DTOs.AlunoDTO;
import com.api.escolaapi.aluno.DTOs.AlunoDTOGet;
import com.api.escolaapi.aluno.DTOs.AlunoDTOPut;
import com.api.escolaapi.repositorys.AlunoRepository;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.xml.crypto.Data;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping("/alunos")
    @ResponseBody
    @Transactional
    public ResponseEntity<String> cadastrar(AlunoDTO dados) {
        var email = repository.findByEmail(dados.email());
        var telefone = repository.findByTelefone(dados.telefone());
        if (email.isEmpty() && telefone.isEmpty()){
            repository.save(new AlunoClass(dados));
            System.out.println("Aluno criado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aluno criado com sucesso!");
        } else {
            System.out.println("Erro ao criar o aluno");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao criar o aluno");
        }
    }

    @GetMapping("/alunos")
    public List<AlunoDTOGet> listar() {
        return repository.findAllByAtivoTrue().stream().map(AlunoDTOGet::new).toList();
    }

    @GetMapping("/alunos-desativados")
    public List<AlunoDTOGet> listarDesativados() {
        return repository.findAllByAtivoFalse().stream().map(AlunoDTOGet::new).toList();
    }

    @PutMapping("/editar-aluno/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@PathVariable int id, @ModelAttribute AlunoDTOPut dados) {
        var email = repository.findByEmail(dados.email());
        var telefone = repository.findByTelefone(dados.telefone());
        if (email.isEmpty() && telefone.isEmpty()){
            var aluno = repository.getReferenceById(id);
            aluno.atualizarInformacoes(dados);
            System.out.println("Aluno editado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aluno editado com sucesso!");
        } else {
            System.out.println("Erro ao editar o aluno");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao editar o aluno");
        }

    }

    @DeleteMapping("/deletar-aluno/{id}")
    @Transactional
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/listar-alunos";
    }

    @DeleteMapping("/deletar-aluno-desativado/{id}")
    @Transactional
    public String deletarDesativado(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/listar-alunos-desativados";
    }

    @DeleteMapping("/inativar-aluno/{id}")
    @Transactional
    public String inativar(@PathVariable int id){
        var aluno = repository.getReferenceById(id);
        aluno.desativar();
        return "redirect:/listar-alunos";
    }

    @PutMapping("/ativar-aluno/{id}")
    @Transactional
    public String ativar(@PathVariable int id){
        var aluno = repository.getReferenceById(id);
        aluno.ativar();
        return "redirect:/listar-alunos-desativados";
    }

}
