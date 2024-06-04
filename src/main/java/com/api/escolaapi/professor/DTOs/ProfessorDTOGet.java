package com.api.escolaapi.professor.DTOs;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.professor.ProfessorClass;

public record ProfessorDTOGet(int id, String primeiro_nome, String sobrenome, CursoEnum curso,
                              Float salario) {
    public ProfessorDTOGet(ProfessorClass professorClass) {
        this(professorClass.getProfessor_id(), professorClass.getPrimeiro_nome(), professorClass.getSobrenome(),
                professorClass.getCurso(), professorClass.getSalario());
    }
}
