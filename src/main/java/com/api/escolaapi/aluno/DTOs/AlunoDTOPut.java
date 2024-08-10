package com.api.escolaapi.aluno.DTOs;

import com.api.escolaapi.Enums.SerieEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record AlunoDTOPut(@NotNull int id,
                          @Enumerated  SerieEnum serie, String telefone, String email) {

}
