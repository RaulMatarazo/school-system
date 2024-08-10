package com.api.escolaapi.funcionario.DTOs;

import com.api.escolaapi.Enums.TipoEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record FuncionarioDTOPut(@NotNull int id, @Enumerated TipoEnum tipo, String email, String telefone,
                                Float salario) {
}
