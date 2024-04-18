package com.api.escolaapi.professor;

import com.api.escolaapi.professor.DTOs.ProfessorDTO;
import com.api.escolaapi.professor.DTOs.ProfessorDTOGet;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ProfessorDTO dados) {
        repository.save(new ProfessorClass(dados));
    }

    @GetMapping
    public List<ProfessorDTOGet> visualizar() {
        return repository.findAllByAtivoTrue().stream().map(ProfessorDTOGet::new).toList();
    }

}
