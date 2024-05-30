package com.api.escolaapi.aluno;

import com.api.escolaapi.aluno.DTOs.AlunoDTO;
import com.api.escolaapi.aluno.DTOs.AlunoDTOGet;
import com.api.escolaapi.aluno.DTOs.AlunoDTOPut;
import com.api.escolaapi.repositorys.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

// Controller para cadastrar um novo aluno
// Essas anotações veem da dependência Spring Web

// Controller
@Controller
// Endereço web padrão
public class AlunoController {
    // Autowired
    @Autowired
    private AlunoRepository repository;

    // Método HTTP POST
    @PostMapping("/alunos")
    @ResponseBody
    @Transactional
    public RedirectView cadastrar(AlunoDTO dados) {
        repository.save(new AlunoClass(dados));
        return new RedirectView("/cadastrar-aluno");
    }

    // Método HTTP GET
    @GetMapping("/alunos")
    public List<AlunoDTOGet> listar() {
        return repository.findAll().stream().map(AlunoDTOGet::new).toList();
    }

    // Método HTTP PUT
    @PutMapping("/editar-aluno")
    @Transactional
    public void atualizar(@RequestBody @Valid AlunoDTOPut dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    // Método HTTP DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable int id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // Método HTTP DELETE
    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable int id){
        var aluno = repository.getReferenceById(id);
        aluno.desativar();
    }

    // Método HTTP PUT
    @PutMapping("ativar/{id}")
    @Transactional
    public void ativar(@PathVariable int id){
        var aluno = repository.getReferenceById(id);
        aluno.ativar();
    }

}
