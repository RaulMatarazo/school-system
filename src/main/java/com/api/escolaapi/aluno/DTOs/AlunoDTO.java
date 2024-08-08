package com.api.escolaapi.aluno.DTOs;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.Enums.SerieEnum;
import com.api.escolaapi.aluno.AlunoClass;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

// DTO para os dados dos alunos
public record AlunoDTO(@NotBlank String primeiro_nome, @NotBlank String sobrenome, @NotBlank boolean sexo,
                       @Past LocalDate data_nascimento, @Enumerated SerieEnum serie,
                       @Enumerated CursoEnum curso, @Email String email,
                       @NotBlank String telefone) {
}
