package com.api.escolaapi.professor;

import com.api.escolaapi.professor.DTOs.ProfessorDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid ProfessorDTO dados){
        repository.save(new ProfessorClass(dados));
    }

}
