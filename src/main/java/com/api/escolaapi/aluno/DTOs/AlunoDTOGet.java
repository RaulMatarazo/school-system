package com.api.escolaapi.aluno.DTOs;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.Enums.SerieEnum;
import com.api.escolaapi.aluno.AlunoClass;

import java.time.LocalDate;

public record AlunoDTOGet(int id, String primeiro_nome, String sobrenome, CursoEnum curso,
                          SerieEnum serie, String email, String telefone, LocalDate data_nascimento) {

    public AlunoDTOGet(AlunoClass alunoClass) {
        this(alunoClass.getAluno_id(), alunoClass.getPrimeiro_nome(), alunoClass.getSobrenome(), alunoClass.getCurso(),
                alunoClass.getSerie(), alunoClass.getEmail(), alunoClass.getTelefone(), alunoClass.getData_nascimento());
    }
}
