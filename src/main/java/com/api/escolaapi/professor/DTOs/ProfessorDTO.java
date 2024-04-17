package com.api.escolaapi.professor.DTOs;

import com.api.escolaapi.Enums.CursoEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record ProfessorDTO(@NotBlank String primeiro_nome, @NotBlank String sobrenome,
                           @NotBlank int sexo, @Email String email, @NotBlank String telefone,
                           @Past LocalDate data_nascimento, @NotBlank float salario,
                           @Enumerated CursoEnum curso)
        {
}
