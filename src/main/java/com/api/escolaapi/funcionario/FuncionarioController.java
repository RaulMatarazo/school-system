package com.api.escolaapi.funcionario;

import com.api.escolaapi.aluno.AlunoClass;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTO;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTOGet;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTOPut;
import com.api.escolaapi.professor.DTOs.ProfessorDTOGet;
import com.api.escolaapi.professor.DTOs.ProfessorDTOPut;
import com.api.escolaapi.repositorys.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class FuncionarioController {
    @Autowired
    FuncionarioRepository repository;

    @PostMapping("/funcionarios")
    @ResponseBody
    @Transactional
    public ResponseEntity<String> cadastrar(FuncionarioDTO dados) {
        var email = repository.findByEmail(dados.email());
        var telefone = repository.findByTelefone(dados.telefone());
        if (email.isEmpty() && telefone.isEmpty()){
            repository.save(new FuncionarioClass(dados));
            System.out.println("Funcionário criado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Funcionário criado com sucesso!");
        } else {
            System.out.println("Erro ao criar o funcionário");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao criar o funcionário");
        }
    }

    @GetMapping("/funcionarios")
    public List<FuncionarioDTOGet> visualizar() {
        return repository.findAllByAtivoTrue().stream().map(FuncionarioDTOGet::new).toList();
    }

    @GetMapping("/funcionarios-desativados")
    public List<FuncionarioDTOGet> visualizarDesativados() {
        return repository.findAllByAtivoFalse().stream().map(FuncionarioDTOGet::new).toList();
    }

    @PutMapping("/editar-funcionario/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@PathVariable int id, @ModelAttribute FuncionarioDTOPut dados) {
        var email = repository.findByEmail(dados.email());
        var telefone = repository.findByTelefone(dados.telefone());
        if (email.isEmpty() && telefone.isEmpty()){
            var funcionario = repository.getReferenceById(id);
            funcionario.atualizarInformacoes(dados);
            System.out.println("Funcionário editado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Funcionário editado com sucesso!");
        } else {
            System.out.println("Erro ao editar o funcionário");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao editar o Funcionário");
        }
    }

    @DeleteMapping("/deletar-funcionario/{id}")
    @Transactional
    public String deletar(@PathVariable int id){
        repository.deleteById(id);

        return "redirect:/listar-funcionarios";
    }

    @DeleteMapping("/inativar-funcionario/{id}")
    @Transactional
    public String inativar(@PathVariable int id){
        var funcionario = repository.getReferenceById(id);
        funcionario.desativar();
        return "redirect:/listar-funcionarios";
    }

    // Método HTTP PUT
    @PutMapping("/ativar-funcionario/{id}")
    @Transactional
    public String ativar(@PathVariable int id){
        var funcionario = repository.getReferenceById(id);
        funcionario.ativar();
        return "redirect:/listar-funcionarios-desativados";
    }
}
