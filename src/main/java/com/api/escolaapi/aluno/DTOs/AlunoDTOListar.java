package com.api.escolaapi.aluno.DTOs;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.Enums.SerieEnum;
import com.api.escolaapi.aluno.AlunoClass;

public record AlunoDTOListar(int id, String primeiro_nome, String sobrenome, CursoEnum curso,
                             SerieEnum serie) {

    public AlunoDTOListar(AlunoClass alunoClass) {
        this(alunoClass.getId(), alunoClass.getPrimeiro_nome(), alunoClass.getSobrenome(), alunoClass.getCurso(),
                alunoClass.getSerie());
    }
}
