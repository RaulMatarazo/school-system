package com.api.escolaapi.professor.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record ProfessorDTOPut(@NotNull int id, String email, String telefone,
                              Float salario) {
}
