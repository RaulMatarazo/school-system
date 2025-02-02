package com.api.escolaapi.funcionario.DTOs;


import com.api.escolaapi.Enums.TipoEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record FuncionarioDTO(@NotBlank String primeiro_nome, @NotBlank String sobrenome,
                             @Past LocalDate data_nascimento, @Enumerated TipoEnum tipo, @Email String email,
                             @NotBlank String telefone, @NotBlank Float salario , @NotBlank String senha) {
}
