package com.api.escolaapi.professor.DTOs;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.professor.ProfessorClass;

import java.time.LocalDate;

public record ProfessorDTOGet(int id, String primeiro_nome, String sobrenome, CursoEnum curso,
                              Float salario, String email, String telefone, LocalDate data_nascimento) {
    public ProfessorDTOGet(ProfessorClass professorClass) {
        this(professorClass.getProfessor_id(), professorClass.getPrimeiro_nome(), professorClass.getSobrenome(),
                professorClass.getCurso(), professorClass.getSalario(), professorClass.getEmail(), professorClass.getTelefone(), professorClass.getData_nascimento());
    }
}
