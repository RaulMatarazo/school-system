package com.api.escolaapi.funcionario;

import com.api.escolaapi.funcionario.DTOs.FuncionarioDTO;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTOGet;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTOPut;
import com.api.escolaapi.professor.DTOs.ProfessorDTOGet;
import com.api.escolaapi.professor.DTOs.ProfessorDTOPut;
import com.api.escolaapi.repositorys.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RedirectView cadastrar(FuncionarioDTO dados) {
        repository.save(new FuncionarioClass(dados));
        return new RedirectView("/cadastrar-funcionario");
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
    public String atualizar(@PathVariable int id, @ModelAttribute FuncionarioDTOPut dados, BindingResult result) {
        if (result.hasErrors()) {
            return "editarFuncionarios";
        }
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);
        return "redirect:/listar-funcionarios";
    }
}
