package com.api.escolaapi.aluno.DTOs;

import com.api.escolaapi.Enums.SerieEnum;
import jakarta.validation.constraints.NotNull;

public record AlunoDTOAtualizar(@NotNull int id,
                                SerieEnum serie, String telefone, String email) {

}
